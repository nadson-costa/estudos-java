package collections.sistemaKanban.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private Status status;
    private Prioridade prioridade;
    private LocalDate deadline;
    private Usuario responsavel;
    private LocalDateTime dataCriacao;

    public Tarefa(Long id, String titulo, String descricao, String categoria, Prioridade prioridade, LocalDate deadline){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.status = Status.TODO;
        this.dataCriacao = LocalDateTime.now();
        this.responsavel = null;
    }

    public void atribuir(Usuario usuario){
        this.responsavel = usuario;
    }

    public void mudarStatus(Status novoStatus){
        this.status = novoStatus;
    }

    public void exibirInfo(){
        System.out.println("\n=== Informações da Tarefa ===");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Categoria: " + categoria);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Data da criação: " + dataCriacao);
        System.out.println("Status: " + status.getDescricao());
        System.out.println("Deadline: " + deadline);

        if(responsavel != null){
            System.out.println("Responsável: " + responsavel.getNome());
        } else {
            System.out.println("Responsável: Não atribuído");
        }

        System.out.println("========================");
    }

    public void exibirResumo(){
        System.out.println("\n=== Resumo da tarefa ===");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Status: " + status.getDescricao());
        System.out.println("Prioridade: " + prioridade.getDescricao());
        System.out.println("=========================");
    }

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getCategoria(){
        return categoria;
    }

    public Status getStatus(){
        return status;
    }

    public Prioridade getPrioridade(){
        return prioridade;
    }

    public LocalDate getDeadline(){
        return deadline;
    }

    public Usuario getResponsavel(){
        return responsavel;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Tarefa tarefa = (Tarefa) obj;
        return id.equals(tarefa.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

}
