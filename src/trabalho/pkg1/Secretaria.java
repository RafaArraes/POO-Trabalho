package trabalho.pkg1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Secretaria extends Pessoa {
    
    private Scanner leitura = new Scanner(System.in);

    public Secretaria(String nome, String dataNascimento, String endereco, 
                    String email, String telefone) {
        super(nome, dataNascimento, endereco, email, telefone);
    }
    
    public void cadastrarPaciente(ArrayList<Paciente> pacientes){
        String nome, dataNascimento, endereco, email, telefone, tipoConvenio, cpf;
        
        System.out.print("Entre com o nome do paciente:");
        nome = leitura.nextLine();
        System.out.print("Entre com a data de nascimento do paciente:");
        dataNascimento = leitura.nextLine();
        System.out.print("Digite o email do paciente:");
        email = leitura.nextLine();
        System.out.print("Digite o endereço do paciente:");
        endereco = leitura.nextLine();
        System.out.print("Digite o telefone do paciente:");
        telefone = leitura.nextLine();
        System.out.print("Digite o tipo de convenio do paciente:");
        tipoConvenio = leitura.nextLine();
        System.out.print("Digite o cpf do paciente:");
        cpf = leitura.nextLine();
        
        Paciente paciente = new Paciente(tipoConvenio, nome, dataNascimento, endereco,
                                         email, telefone, cpf);
        
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado!");
    }
    
    public void editarPaciente(ArrayList<Paciente> pacientes, Paciente p, String tipoEdicao){
        int index;
        index = pacientes.indexOf(p);
        tipoEdicao = tipoEdicao.toLowerCase();
        
        if(tipoEdicao.equals("nome")){
            String novoNome;
            
            System.out.print("Digite o novo nome do paciente:");
            novoNome = leitura.nextLine();
            pacientes.get(index).setNome(novoNome);
            System.out.println("O nome foi alterado com sucesso!!");
        }
        
        else if(tipoEdicao.equals("data de nascimento")){
            String novaData;

            System.out.print("Digite a nova data de nascimento do paciente:");
            novaData = leitura.nextLine();
            pacientes.get(index).setDataNascimento(novaData);
            System.out.println("A data de nascimento foi alterado com sucesso!!");
        }
        
        else if(tipoEdicao.equals("email")){
            String novoEmail;
            
            System.out.print("Digite o novo e-mail do paciente:");
            novoEmail = leitura.nextLine();
            pacientes.get(index).setEmail(novoEmail);
            System.out.println("O email foi alterado com sucesso!!");
        }
        
        else if(tipoEdicao.equals("endereço")){
            String novoEndereco;

            System.out.print("Digite o novo endereço do paciente:");
            novoEndereco = leitura.nextLine();
            pacientes.get(index).setEndereco(novoEndereco);
            System.out.println("O endereço foi alterado com sucesso!!");
        }
        
        else if(tipoEdicao.equals("telefone")){
            String novoTelefone;
        
            System.out.print("Digite o novo telefone do paciente:");
            novoTelefone = leitura.nextLine();
            pacientes.get(index).setTelefone(novoTelefone);
            System.out.println("O telefone foi alterado com sucesso!!");
        }
        
        else if(tipoEdicao.equals("tipo de convenio")){
            String novoConvenio;
            
            System.out.print("Digite o novo tipo de convenio do paciente:");
            novoConvenio = leitura.nextLine();
            pacientes.get(index).setTipoConvenio(novoConvenio);
            System.out.println("O tipo do convenio foi alterado com sucesso!!");
        }
    }
    
    public void excluirPaciente(ArrayList<Paciente> pacientes, Paciente p){
        int index;
        index = pacientes.indexOf(p);
        pacientes.remove(index);
        System.out.println("Paciente excluido!");
    }
    
    public void cadastrarConsulta(ArrayList<Consulta> consultas, Paciente paciente,
                                  Medico medico){
        
        String data, horario, tipoConsulta;
        
        System.out.print("Digite a data que vai ser a consulta:");
        data = leitura.nextLine();
        System.out.print("Digite o horario que vai ser a consulta:");
        horario = leitura.nextLine();
        System.out.print("Digite o tipo de consulta que vai ser realizada:");
        tipoConsulta = leitura.nextLine();
        
        Consulta consulta = new Consulta(data, horario, medico, paciente, tipoConsulta);
        
        consultas.add(consulta);
        System.out.println("Consulta cadastrada!");
    }
    
    public void editarConsulta(ArrayList<Consulta> consultas, Consulta c, String tipoEdicao,
                                ArrayList<Paciente> pacientes){
        int index;
        index = consultas.indexOf(c);
        tipoEdicao = tipoEdicao.toLowerCase();
        
        if(tipoEdicao.equals("data")){
            String novaData;
            
            System.out.print("Digite a nova data da consulta");
            novaData = leitura.nextLine();
            consultas.get(index).setData(novaData);
        }
        
        else if(tipoEdicao.equals("horario")){
            String novoHorario;
        
            System.out.print("Digite o novo horário para a consulta");
            novoHorario = leitura.nextLine();
            consultas.get(index).setHorario(novoHorario);
        }
        
        else if(tipoEdicao.equals("paciente")){
            String nome;
            boolean flag = false;
            int indice = -1;
            
            System.out.print("Digite o nome do novo paciente para essa consulta:");
            nome = leitura.nextLine();
            
            for(Paciente paciente : pacientes){
                if(paciente.getNome().equals(nome)){
                    indice = pacientes.indexOf(paciente);
                    flag = true;
                }
            }
            
            if(flag)
                consultas.get(index).setPaciente(pacientes.get(indice));
            else System.out.println("O paciente que foi digitado não está cadastrado!!");
        }
        
        else if(tipoEdicao.equals("tipo de consulta")){
            String novoTipo;
            
            System.out.print("Digite um novo tipo de consulta:");
            novoTipo = leitura.nextLine();
            consultas.get(index).setTipoConsulta(novoTipo);
        }
    }
    
    public void excluirConsulta(ArrayList<Consulta> consultas, Consulta c){
        int index;
        index = consultas.indexOf(c);
        consultas.remove(index);
        System.out.println("Consulta Excluida!");
    }
    
    public void gerarRelatorio(ArrayList<Consulta> consultas){ 
        LocalDate data = LocalDate.now();
        
        String mes = Integer.toString(data.getMonthValue()), 
                dia = Integer.toString(data.getDayOfMonth()+1), 
                ano = Integer.toString(data.getYear());
        String aux, date[];
        
        System.out.println("-----------Mostrando consultas do dia seguinte-------------");
        
        for (Consulta consulta: consultas){
            aux = consulta.getData();
            date = aux.split("/");
            
            if (date[0].equals(dia) && date[1].equals(mes) && date[2].equals(ano)){
                
                System.out.println("\t-----------Consulta " + consultas.indexOf(consulta) + "--------------");
                System.out.println("\tA data desta consulta é " + consulta.getData());
                System.out.println("\tO horário da consulta é " + consulta.getHorario());
                System.out.println("\tO tipo da consulta é " + consulta.getTipoConsulta());
                System.out.println("\tO medico desta consulta é " + consulta.getMedico().getNome());
                System.out.println("\tO paciente da consulta é " + consulta.getPaciente().getNome()+"\n");
               
            }
        }
    }
}
