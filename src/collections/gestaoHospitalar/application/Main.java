package collections.gestaoHospitalar.application;

import collections.gestaoHospitalar.entities.*;
import collections.gestaoHospitalar.services.Hospital;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while(true){
            System.out.println("\n=== Sistema Hospitalar ===");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Cadastrar médico");
            System.out.println("3 - Buscar paciente por CPF");
            System.out.println("4 - Buscar médico por CRM");
            System.out.println("5 - Buscar médicos por especialidade");
            System.out.println("6 - Adicionar paciente na fila");
            System.out.println("7 - Agendar consulta");
            System.out.println("8 - Atender próximo da fila");
            System.out.println("9 - Finalizar consulta");
            System.out.println("10 - Ver próxima consulta urgente");
            System.out.println("11 - Atender próxima urgente");
            System.out.println("12 - Listar pacientes");
            System.out.println("13 - Listar médicos");
            System.out.println("14 - Listar médicos por especialidade");
            System.out.println("15 - Listar consultas");
            System.out.println("16 - Mostrar fila de especialidade");
            System.out.println("17 - Relatório geral");
            System.out.println("18 - Sair");
            System.out.println("==========================");
            System.out.print("-> Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 18){
                System.out.println(">>> Até mais!");
                sc.close();
                break;
            }

            switch(opcao){
                case 1:
                    System.out.print("-> Digite o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("-> Digite o nome: ");
                    String nomePaciente = sc.nextLine();

                    System.out.print("-> Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("-> Digite o telefone: ");
                    String telefone = sc.nextLine();

                    Paciente paciente = new Paciente(cpf, nomePaciente, idade, telefone);
                    hospital.cadastrarPaciente(paciente);
                    break;

                case 2:
                    try {
                        System.out.print("-> Digite o CRM: ");
                        String crm = sc.nextLine();

                        System.out.print("-> Digite o nome: ");
                        String nomeMedico = sc.nextLine();

                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String especialidadeStr = sc.nextLine().toUpperCase();
                        Especialidade especialidade = Especialidade.valueOf(especialidadeStr);

                        Medico medico = new Medico(crm, nomeMedico, especialidade);
                        hospital.cadastrarMedico(medico);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 3:
                    System.out.print("-> CPF do paciente: ");
                    String cpfBusca = sc.nextLine();

                    Paciente pacienteEncontrado = hospital.buscarPacientePorCPF(cpfBusca);
                    if(pacienteEncontrado != null){
                        pacienteEncontrado.exibirInfo();
                    }
                    break;

                case 4:
                    System.out.print("-> CRM do médico: ");
                    String crmBusca = sc.nextLine();

                    Medico medicoEncontrado = hospital.buscarMedicoPorCRM(crmBusca);
                    if(medicoEncontrado != null){
                        medicoEncontrado.exibirInfo();
                    }
                    break;

                case 5:
                    try {
                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String espStr = sc.nextLine().toUpperCase();
                        Especialidade esp = Especialidade.valueOf(espStr);

                        Set<Medico> medicos = hospital.buscarMedicosPorEspecialidade(esp);
                        if(medicos.isEmpty()){
                            System.out.println(">>> Nenhum médico encontrado nessa especialidade!");
                        } else {
                            System.out.println("\n=== Médicos da Especialidade " + esp.getDescricao() + " ===");
                            for(Medico m : medicos){
                                m.exibirInfo();
                            }
                        }
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 6:
                    try {
                        System.out.print("-> CPF do paciente: ");
                        String cpfFila = sc.nextLine();

                        Paciente pacienteFila = hospital.buscarPacientePorCPF(cpfFila);
                        if(pacienteFila == null){
                            break;
                        }

                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String espFilaStr = sc.nextLine().toUpperCase();
                        Especialidade espFila = Especialidade.valueOf(espFilaStr);

                        hospital.adicionarNaFila(pacienteFila, espFila);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 7:
                    try {
                        System.out.print("-> CPF do paciente: ");
                        String cpfConsulta = sc.nextLine();

                        System.out.print("-> CRM do médico: ");
                        String crmConsulta = sc.nextLine();

                        System.out.println("-> Urgência (BAIXA/MEDIA/ALTA/EMERGENCIA): ");
                        String urgenciaStr = sc.nextLine().toUpperCase();
                        Urgencia urgencia = Urgencia.valueOf(urgenciaStr);

                        System.out.print("-> Observações: ");
                        String observacoes = sc.nextLine();

                        hospital.agendarConsulta(cpfConsulta, crmConsulta, urgencia, observacoes);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Urgência inválida!");
                    }
                    break;

                case 8:
                    try {
                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String espAtenderStr = sc.nextLine().toUpperCase();
                        Especialidade espAtender = Especialidade.valueOf(espAtenderStr);

                        hospital.atenderProximoDaFila(espAtender);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 9:
                    System.out.print("-> CRM do médico: ");
                    String crmFinalizar = sc.nextLine();

                    hospital.finalizarConsulta(crmFinalizar);
                    break;

                case 10:
                    hospital.proximaConsultaUrgente();
                    break;

                case 11:
                    hospital.atenderProximaUrgente();
                    break;

                case 12:
                    hospital.listarPacientes();
                    break;

                case 13:
                    hospital.listarMedicos();
                    break;

                case 14:
                    try {
                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String espListarStr = sc.nextLine().toUpperCase();
                        Especialidade espListar = Especialidade.valueOf(espListarStr);

                        hospital.listarMedicosPorEspecialidade(espListar);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 15:
                    hospital.listarConsultas();
                    break;

                case 16:
                    try {
                        System.out.println("-> Especialidade (CARDIOLOGIA/PEDIATRIA/ORTOPEDIA/DERMATOLOGIA/NEUROLOGIA): ");
                        String espMostrarStr = sc.nextLine().toUpperCase();
                        Especialidade espMostrar = Especialidade.valueOf(espMostrarStr);

                        hospital.mostrarFilaEspecialidade(espMostrar);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Especialidade inválida!");
                    }
                    break;

                case 17:
                    hospital.relatorioGeral();
                    break;

                default:
                    System.out.println(">>> Opção inválida!");
                    break;
            }
        }
    }
}