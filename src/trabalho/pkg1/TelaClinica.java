package trabalho.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaClinica {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        Scanner leitura = new Scanner(System.in);
        Scanner leitura1 = new Scanner(System.in);
        
        Secretaria secretaria = new Secretaria("Solange", "20-05-1990", "Parque das Grevilhas"
                                              ,"solange@gmail.com", "9736-4125");
        
        Medico medico1 = new Medico(10.300, "Oftamologia","Luiz Augusto","28-03-1985","Centro","MedicoHumilde@gmail.com","99706666");
       
        GerenciarClinica gerenciador;
        gerenciador = new GerenciarClinica();
        
        boolean flag;
        int op,index=-1;
        String cpf, data, horario, nome, tipoEdicao, name;
            
        System.out.println("-Conectando-\n[0] Medico\n[1] Secretaria\n");
        int conect = leitura.nextInt();
        if (conect == 1) {
            do {
                System.out.println("\n----------------Menu----------------");
                System.out.println("[0] MEDICO");
                System.out.println("[1] Cadastrar um paciente");
                System.out.println("[2] Editar os dados do paciente");
                System.out.println("[3] Excluir um paciente");
                System.out.println("[4] Imprimir cadastro");
                System.out.println("[5] Cadastrar uma consulta");
                System.out.println("[6] Editar os dados da consulta");
                System.out.println("[7] Excluir uma consulta");
                System.out.println("[8] Imprimir a(s) consultas");
                System.out.print("-------------------------------------");
                System.out.print("\nDigite a sua opção:");
                op = leitura.nextInt();
                System.out.println();
                switch (op) {
                    case 1:
                        secretaria.cadastrarPaciente(pacientes);
                        break;

                    case 2:
                        flag = false;

                        System.out.print("Digite qual dados vai ser alterado do paciente:");
                        tipoEdicao = leitura1.nextLine();
                        System.out.print("Digite o nome do paciente para fazer a edição:");
                        name = leitura1.nextLine();

                        for (Paciente paciente : pacientes) {
                            if (paciente.getNome().equals(name)) {
                                index = pacientes.indexOf(paciente);
                                flag = true;
                            }
                        }
                        if (flag) {
                            secretaria.editarPaciente(pacientes, pacientes.get(index), tipoEdicao);
                        } else {
                            System.out.println("O paciente não está cadastrado");
                        }
                        break;

                    case 3:
                        System.out.println("Digite o nome do paciente para excluir");
                        nome = leitura1.nextLine();
                        int indice = 0;
                        boolean flag1 = false;

                        for (Paciente paciente : pacientes) {
                            if (paciente.getNome().equals(nome)) {
                                indice = pacientes.indexOf(paciente);
                                flag1 = true;
                            }
                        }
                        if (flag1)
                            secretaria.excluirPaciente(pacientes, pacientes.get(indice));
                        else
                            System.out.println("O paciente não está cadastrado");
                        
                        break;
                    case 4:
                        gerenciador.imprimirCadastros(pacientes);
                        break;
                    case 5:
                        System.out.print("Digite o nome do paciente que vai fazer a consulta:");
                        nome = leitura1.nextLine();
                        flag = false;

                        for (Paciente paciente : pacientes) {
                            if (paciente.getNome().equals(nome)) {
                                index = pacientes.indexOf(paciente);
                                flag = true;
                            }
                        }
                        if (flag)
                            secretaria.cadastrarConsulta(consultas, pacientes.get(index), medico1);
                        else
                            System.out.println("O paciente não está cadastrado");
                        break;

                    case 6:
                        System.out.print("Digite o tipo de edição que vai fazer:");
                        tipoEdicao = leitura1.nextLine();
                        System.out.print("Digite a data da consulta que vai fazer a edição:");
                        data = leitura1.nextLine();
                        System.out.print("Digite o horário da consulta que vai fazer a edição:");
                        horario = leitura1.nextLine();
                        flag = false;

                        for (Consulta consulta : consultas) {
                            if (consulta.getData().equals(data) && consulta.getHorario().equals(horario)) {
                                index = consultas.indexOf(consulta);
                                flag = true;
                            }
                        }

                        if (flag) {
                            secretaria.editarConsulta(consultas, consultas.get(index),
                                    tipoEdicao, pacientes);
                        } else {
                            System.out.println("A consulta não está cadastrada");
                        }
                        break;

                    case 7:
                        System.out.print("Entre com a data da consulta que deseja excluir:");
                        data = leitura1.nextLine();
                        System.out.print("Digite o horário da consulta qur deseja excluir:");
                        horario = leitura1.nextLine();
                        flag = false;

                        for (Consulta consulta : consultas) {
                            if (consulta.getData().equals(data) && consulta.getHorario().equals(horario)) {
                                index = consultas.indexOf(consulta);
                                flag = true;
                            }
                        }
                        if (flag) {
                            secretaria.excluirConsulta(consultas, consultas.get(index));
                        } else {
                            System.out.println("A consulta não está cadastrada!!");
                        }
                        break;

                    case 8:
                        gerenciador.imprimirConsultas(consultas);
                        break;

                }
            } while(op != 0 );
        }
        
        
        
        System.out.println("-------------CONSULTAS-------------");
        do{
            System.out.println("\n----------------Menu----------------");
            System.out.println("[0] SAIR");
            System.out.println("[1] Consultando o paciente");
            System.out.println("[2] Cadastro do prontuario do paciente");
            System.out.println("[3] Editar dados do paciente");
            System.out.println("[4] Relatorio medico");
            System.out.print("-------------------------------------");
            System.out.print("\nDigite a sua opção:");
            op = leitura.nextInt();
            System.out.println();
            switch (op) {
                case 1: medico1.cadastrarDados(pacientes);
                        break;
                
                case 2: medico1.cadastrarProntuario(pacientes);
                        break;
                
                case 3: index = 0;
                        flag = false;
                        
                        System.out.print("Digite o nome do paciente para fazer a edição:");
                        name = leitura1.nextLine();
                        System.out.print("Digite qual dados vai ser alterado do paciente:");
                        tipoEdicao = leitura1.nextLine();
                        
                        for(Paciente paciente : pacientes)
                            if(paciente.getNome().equals(name)){
                                index = pacientes.indexOf(paciente);   
                                flag = true;
                            }
                        if(flag)
                            medico1.editarDados(pacientes, pacientes.get(index),tipoEdicao);
                        else System.out.println("O paciente não está cadastrado");
                        break;
                    
                case 4: gerenciador.imprimirDadosMed(pacientes);
                        System.out.println(medico1.getTotalClienteMes());
                        break;
            }
        } while(op != 0 );
    }
}