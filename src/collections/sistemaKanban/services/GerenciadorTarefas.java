package collections.sistemaKanban.services;

import collections.sistemaKanban.entities.*;

import java.time.LocalDate;
import java.util.*;

public class GerenciadorTarefas {
    private Set<Tarefa> tarefas = new HashSet<>();
    private Map<Long, Tarefa> tarefasPorId = new HashMap<>();
    private Map<String, Set<Tarefa>> tarefasPorCategoria = new HashMap<>();
    private Map<Status, Set<Tarefa>> tarefasPorStatus = new HashMap<>();
    private Map<Usuario, Set<Tarefa>> tarefasPorUsuario = new HashMap<>();
    private PriorityQueue<Tarefa> filaPrioridade;
    private TreeSet<Tarefa> tarefasPorDeadline;

    public GerenciadorTarefas() {
        filaPrioridade = new PriorityQueue<>((t1, t2) ->
                t2.getPrioridade().getNivel() - t1.getPrioridade().getNivel()
        );

        tarefasPorDeadline = new TreeSet<>((t1, t2) -> {
            int compareData = t1.getDeadline().compareTo(t2.getDeadline());
            if (compareData != 0) return compareData;
            return t1.getId().compareTo(t2.getId());
        });
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefasPorId.put(tarefa.getId(), tarefa);

        String categoria = tarefa.getCategoria();
        Set<Tarefa> tarefaCategoria = tarefasPorCategoria.get(categoria);
        if (tarefaCategoria == null) {
            tarefaCategoria = new HashSet<>();
            tarefasPorCategoria.put(categoria, tarefaCategoria);
        }
        tarefaCategoria.add(tarefa);

        Status status = tarefa.getStatus();
        Set<Tarefa> tarefaStatus = tarefasPorStatus.get(status);
        if (tarefaStatus == null) {
            tarefaStatus = new HashSet<>();
            tarefasPorStatus.put(status, tarefaStatus);
        }
        tarefaStatus.add(tarefa);

        filaPrioridade.add(tarefa);
        tarefasPorDeadline.add(tarefa);

        System.out.println(">>> Tarefa adicionada com sucesso!");
    }

    public Tarefa buscarPorId(Long id) {
        return tarefasPorId.get(id);
    }

    public Set<Tarefa> buscarPorCategoria(String categoria) {
        Set<Tarefa> resultado = tarefasPorCategoria.get(categoria);
        if (resultado == null) {
            return new HashSet<>();
        }
        return resultado;
    }

    public Set<Tarefa> buscarPorStatus(Status status) {
        Set<Tarefa> resultado = tarefasPorStatus.get(status);
        if (resultado == null) {
            return new HashSet<>();
        }
        return resultado;
    }

    public Set<Tarefa> buscarPorUsuario(Usuario usuario) {
        Set<Tarefa> resultado = tarefasPorUsuario.get(usuario);
        if (resultado == null) {
            return new HashSet<>();
        }
        return resultado;
    }

    public void atribuirTarefa(Long id, Usuario usuario){
        Tarefa tarefa = tarefasPorId.get(id);
        if(tarefa == null){
            System.out.println(">>> Nenhuma tarefa foi encontrada!");
            return;
        }
        Usuario responsavelAntigo = tarefa.getResponsavel();
        if(responsavelAntigo != null){
            Set<Tarefa> tarefasAntigo = tarefasPorUsuario.get(responsavelAntigo);
            if(tarefasAntigo != null){
                tarefasAntigo.remove(tarefa);
            }
        }
        tarefa.atribuir(usuario);

        Set<Tarefa> tarefasUsuario = tarefasPorUsuario.get(usuario);
        if(tarefasUsuario == null){
            tarefasUsuario = new HashSet<>();
            tarefasPorUsuario.put(usuario, tarefasUsuario);
        }
        tarefasUsuario.add(tarefa);
        System.out.println(">>> Tarefa atribuída para " + usuario.getNome() + " com sucesso!");
    }

    public void mudarStatus(Long id, Status novoStatus){
        Tarefa tarefa = tarefasPorId.get(id);
        if(tarefa == null){
            System.out.println(">>> Nenhuma tarefa foi encontrada!");
            return;
        }

        Status statusAntigo = tarefa.getStatus();
        Set<Tarefa> tarefasStatusAntigo = tarefasPorStatus.get(statusAntigo);
        if(tarefasStatusAntigo != null){
            tarefasStatusAntigo.remove(tarefa);
        }
        tarefa.mudarStatus(novoStatus);

        Set<Tarefa> tarefasNovoStatus = tarefasPorStatus.get(novoStatus);
        if(tarefasNovoStatus == null){
            tarefasNovoStatus = new HashSet<>();
            tarefasPorStatus.put(novoStatus, tarefasNovoStatus);
        }
        tarefasNovoStatus.add(tarefa);
        System.out.println(">>> Status alterado de " + statusAntigo.getDescricao() +
                " para " + novoStatus.getDescricao() + "!");

    }

    public Tarefa proximaTarefaPrioritaria(){
        if(filaPrioridade.isEmpty()){
            System.out.println(">>> Nenhuma tarefa na fila de prioridade!");
            return null;
        }

        Tarefa proxima = filaPrioridade.peek();
        System.out.println(">>> Próxima tarefa prioritária:");
        proxima.exibirResumo();

        return proxima;
    }

    public Tarefa processarProximaTarefa(){
        if(filaPrioridade.isEmpty()){
            System.out.println(">>> Nenhuma tarefa na fila de prioridade!");
            return null;
        }

        Tarefa tarefa = filaPrioridade.poll();
        System.out.println(">>> Tarefa processada:");
        tarefa.exibirResumo();

        return tarefa;
    }

    public void listarPorDeadline(){
        if(tarefasPorDeadline.isEmpty()){
            System.out.println(">>> Nenhuma tarefa encontrada!");
            return;
        }
        System.out.println("\n=== Tarefas Ordenadas por Deadline ===");
        for(Tarefa tarefa : tarefasPorDeadline){
            tarefa.exibirResumo();
        }
    }

    public void listarPorStatus(Status status){
        Set<Tarefa> tarefas = buscarPorStatus(status);

        if(tarefas.isEmpty()){
            System.out.println(">>> Nenhuma tarefa encontrada para o status: " + status.getDescricao() + "!");
            return;
        }
        System.out.println("\n=== Tarefas - Status: " + status.getDescricao() + " ===");
        for(Tarefa tarefa : tarefas){
            tarefa.exibirResumo();
        }
    }

    public void listarPorCategoria(String categoria){
        Set<Tarefa> tarefas = buscarPorCategoria(categoria);

        if(tarefas.isEmpty()){
            System.out.println(">>> Nenhuma tarefa na categoria: " + categoria);
            return;
        }

        System.out.println("\n=== Tarefas - Categoria: " + categoria + " ===");
        for(Tarefa tarefa : tarefas){
            tarefa.exibirResumo();
        }
    }

    public void listarTarefasUsuario(Usuario usuario){
        Set<Tarefa> tarefas = buscarPorUsuario(usuario);

        if(tarefas.isEmpty()){
            System.out.println(">>> Nenhuma tarefa atribuída a " + usuario.getNome());
            return;
        }

        System.out.println("\n=== Tarefas de " + usuario.getNome() + " ===");
        for(Tarefa tarefa : tarefas){
            tarefa.exibirResumo();
        }
    }

    public void listarTodasTarefas(){
        if(tarefas.isEmpty()){
            System.out.println(">>> Nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("\n=== Todas as Tarefas ===");
        for(Tarefa tarefa : tarefas){
            tarefa.exibirResumo();
        }
    }

    public void relatorioGeral(){
        if(tarefas.isEmpty()){
            System.out.println(">>> Nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("\n=== RELATÓRIO GERAL ===");
        System.out.println("Total de tarefas: " + tarefas.size());

        int todo = buscarPorStatus(Status.TODO).size();
        int doing = buscarPorStatus(Status.DOING).size();
        int done = buscarPorStatus(Status.DONE).size();

        System.out.println("\nPor Status:");
        System.out.println("  A Fazer: " + todo);
        System.out.println("  Em Andamento: " + doing);
        System.out.println("  Concluído: " + done);

        int alta = 0, media = 0, baixa = 0;
        for(Tarefa t : tarefas){
            switch(t.getPrioridade()){
                case ALTA:
                    alta++;
                    break;
                case MEDIA:
                    media++;
                    break;
                case BAIXA:
                    baixa++;
                    break;
            }
        }

        System.out.println("\nPor Prioridade:");
        System.out.println("  Alta: " + alta);
        System.out.println("  Média: " + media);
        System.out.println("  Baixa: " + baixa);

        LocalDate hoje = LocalDate.now();
        int atrasadas = 0;
        for(Tarefa t : tarefas){
            if(t.getDeadline().isBefore(hoje) && t.getStatus() != Status.DONE){
                atrasadas++;
            }
        }

        System.out.println("\nTarefas Atrasadas: " + atrasadas);
        System.out.println("=======================");
    }
}
