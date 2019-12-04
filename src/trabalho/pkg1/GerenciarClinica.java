package trabalho.pkg1;

import java.util.ArrayList;

public class GerenciarClinica {
    
    public GerenciarClinica(){
    }
    
    public void imprimirCadastros(ArrayList<Paciente> pacientes){
        System.out.println("---------------Imprimindo cadastros----------------");
        for(Paciente paciente : pacientes){
            System.out.println("Paciente " + pacientes.indexOf(paciente) +": "+ paciente.getNome());
            System.out.println("Data de nascimento:" + paciente.getDataNascimento());
            System.out.println("Endereçp:" + paciente.getEndereco());
            System.out.println("E-mail:" + paciente.getEmail());
            System.out.println("Telefone:" + paciente.getTelefone());
            System.out.println("Tipo de convenio:" + paciente.getTipoConvenio());
            System.out.println("\t---\t--\t--");
        }
    }
    
    public void imprimirDadosMed(ArrayList<Paciente> pacientes){
        System.out.println("---------------Imprimindo dados----------------");

        for (Paciente paciente : pacientes) {
            System.out.println("Paciente: "+paciente.getNome());
            System.out.println("Fuma?:" + paciente.isFuma());
            System.out.println("Bebe?:" + paciente.isBebe());
            System.out.println("Colesterol?:" + paciente.isColesterol());
            System.out.println("Diabete?:" + paciente.isDiabete());
            System.out.println("Doença cardiaca?:" + paciente.isDoencaCardiaca());
            System.out.print("Cirurgias:");
            paciente.getCirurgias().forEach((c) -> {
                System.out.print("/ " + c);
            });
            System.out.println();
            System.out.print("Alergias:");
            paciente.getAlergias().forEach((c) -> {
                System.out.print("/ " + c);
            });
            System.out.println();
            System.out.println("Diagnostico: " + paciente.getDiagnostico());
            System.out.println("Tratamento: "+ paciente.getTratamento());
            System.out.println("\t---\t--\t--");
        }
    }
    
    /*public void relatorioMedicos(){
        
    }*/
 
    public void imprimirConsultas(ArrayList<Consulta> consultas){
        System.out.println("---------------Imprimindo Consultas----------------");
        for(Consulta consulta : consultas){
            System.out.println("--------Consulta " + consultas.indexOf(consulta) + "---------");
            System.out.println("A data desta consulta é " + consulta.getData());
            System.out.println("O horário da consulta é " + consulta.getHorario());
            System.out.println("O tipo da consulta é " + consulta.getTipoConsulta());
            System.out.println("O medico desta consulta é " + consulta.getMedico().getNome());
            System.out.println("O paciente da consulta é " + consulta.getPaciente().getNome());
        }
    }
}