package trabalho.pkg1;

import java.util.ArrayList;

public class GerenciarClinica {
    
    public GerenciarClinica(){
    }
    
    public void imprimirCadastros(ArrayList<Paciente> pacientes){
        System.out.println("---------------Imprimindo cadastros----------------");
        for(Paciente paciente : pacientes){
            System.out.println("\tPaciente " + pacientes.indexOf(paciente) +": "+ paciente.getNome());
            System.out.println("\tData de nascimento:" + paciente.getDataNascimento());
            System.out.println("\tEndereçp:" + paciente.getEndereco());
            System.out.println("\tE-mail:" + paciente.getEmail());
            System.out.println("\tTelefone:" + paciente.getTelefone());
            System.out.println("\tCPF:" + paciente.getCpf());
            System.out.println("\tTipo de convenio:" + paciente.getTipoConvenio());
            System.out.println("\t---\t--\t--\n");
        }
    }
    
    public void imprimirDadosMed(ArrayList<Paciente> pacientes){
        System.out.println("---------------Imprimindo dados----------------");

        for (Paciente paciente : pacientes) {
            System.out.println("\tPaciente: "+paciente.getNome());
            System.out.println("\tFuma?:" + paciente.isFuma());
            System.out.println("\tBebe?:" + paciente.isBebe());
            System.out.println("\tColesterol?:" + paciente.isColesterol());
            System.out.println("\tDiabete?:" + paciente.isDiabete());
            System.out.println("\tDoença cardiaca?:" + paciente.isDoencaCardiaca());
            System.out.print("\tCirurgias:");
            paciente.getCirurgias().forEach((c) -> {
                System.out.print(". " + c);
            });
            System.out.println();
            System.out.print("\tAlergias:");
            paciente.getAlergias().forEach((c) -> {
                System.out.print(". " + c);
            });
            System.out.println();
            System.out.println("\tDiagnostico: " + paciente.getDiagnostico());
            System.out.println("\tTratamento: "+ paciente.getTratamento());
            System.out.println("\t---\t--\t--\n");
        }
    }

    public void imprimirConsultas(ArrayList<Consulta> consultas){
        System.out.println("---------------Imprimindo Consultas----------------");
        for(Consulta consulta : consultas){
            System.out.println("\t--------Consulta " + consultas.indexOf(consulta) + "---------");
            System.out.println("\tA data desta consulta é " + consulta.getData());
            System.out.println("\tO horário da consulta é " + consulta.getHorario());
            System.out.println("\tO tipo da consulta é " + consulta.getTipoConsulta());
            System.out.println("\tO medico desta consulta é " + consulta.getMedico().getNome());
            System.out.println("\tO paciente da consulta é " + consulta.getPaciente().getNome()+"\n");
        }
    }
}