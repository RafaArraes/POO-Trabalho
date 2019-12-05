package trabalho.pkg1;
import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Pessoa {
    private int TotalClienteMes;
    private Scanner leitura = new Scanner(System.in);
    private double salario;
    private String especializacao;

    public Medico(double salario, String especializacao, String nome, String dataNascimento,
                  String endereco, String email, String telefone) {
        super(nome, dataNascimento, endereco, email, telefone);
        this.TotalClienteMes = 0;
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public void cadastrarDados(ArrayList<Paciente> paciente){
        ArrayList<String> cirurgias = new ArrayList<>();
        ArrayList<String> alergias = new ArrayList<>();
        
        boolean fuma,bebe,colesterol,flag = false, cirurg, alerg;
        int index = 0;
        
        System.out.print("Nome do consultado: ");
        String name = leitura.nextLine();
        
        for (Paciente pacientes: paciente) {
            if (pacientes.getNome().equals(name)) {
                index = paciente.indexOf(pacientes);
                flag = true;
            }
        }
        if (flag) {
            System.out.print("Fuma? (S/N):");
            fuma = leitura.nextLine().equals("S");
        
            System.out.print("Ingere bebidas alcoólicas? (S/N):");
            bebe = leitura.nextLine().equals("S");
        
            System.out.print("Problema de colesterol? (S/N):");
            colesterol = leitura.nextLine().equals("S");
        
            String aux;
            System.out.print("Já fez cirurgias? [S/N]:");
            cirurg = leitura.nextLine().equals("S");
            if (cirurg){
                System.out.println("Quais (aperte enter sem digitar para seguir): ");
                aux = leitura.nextLine();
                while (!"".equals(aux)){
                    cirurgias.add(aux);
                    aux = leitura.nextLine();
                }
            }
        
            System.out.print("Possui alergias? [S/N]:");
            alerg = leitura.nextLine().equals("S");
            if (alerg){
                System.out.println("Quais (aperte enter sem digitar para seguir):");
                aux = leitura.nextLine();
                while (!"".equals(aux)){
                    alergias.add(aux);
                    aux = leitura.nextLine();
                }
            }
        
            paciente.get(index).consultando(fuma, bebe, colesterol, bebe, 
                colesterol, cirurgias, alergias);   
            System.out.println("Cadastrado!");
            this.setTotalClienteMes(this.getTotalClienteMes()+1);
        }else{
            System.out.println("O paciente não esta cadastrado");
        }
    }

    public void editarDados(ArrayList<Paciente> pacientes, Paciente consultado, String edicao){
        int index = pacientes.indexOf(consultado);
        ArrayList<String> cirurgias = new ArrayList<>();
        ArrayList<String> alergias = new ArrayList<>();
        ArrayList<String> sintomas = new ArrayList<>();
        String newAux;
        boolean novo;
        edicao = edicao.toLowerCase();
        
        if (null != edicao)switch (edicao) {
            case "fuma":
                System.out.println("Fuma? [S/N]");
                newAux = leitura.nextLine();
                novo = newAux.equals("S");
                pacientes.get(index).setFuma(novo);
                break;
            case "bebe":
                System.out.println("Bebe? [S/N]");
                newAux = leitura.nextLine();
                novo = newAux.equals("S");
                pacientes.get(index).setBebe(novo);
                break;
            case "colesterol":
                System.out.println("Problemas de colesterol? [S/N]");
                newAux = leitura.nextLine();
                novo = newAux.equals("S");
                pacientes.get(index).setColesterol(novo);
                break;
            case "diabete":
                System.out.println("Possui diabete? [S/N]");
                newAux = leitura.nextLine();
                novo = newAux.equals("S");
                pacientes.get(index).setDiabete(novo);
                break;
            case "doencacardiaca":
                System.out.println("Possui doenças cardiacas? [S/N]");
                newAux = leitura.nextLine();
                novo = newAux.equals("S");
                pacientes.get(index).setDoencaCardiaca(novo);
                break;
            case "cirurgias":
                System.out.print("Já fez cirurgias? [S/N]");
                novo = leitura.nextLine().equals("S");
                if (novo){
                    System.out.println("Quais: ");
                    newAux = leitura.nextLine();
                    while (!"".equals(newAux)){
                        cirurgias.add(newAux);
                        newAux = leitura.nextLine();
                    }
                }
                pacientes.get(index).setCirurgias(cirurgias);
                break;
            case "alergias":
                System.out.print("Possui alergias? [S/N]:");
                novo = leitura.nextLine().equals("S");
                if (novo){
                    System.out.println("Quais:");
                    newAux = leitura.nextLine();
                    while (!"".equals(newAux)){
                        alergias.add(newAux);
                        newAux = leitura.nextLine();
                    }
                }
                pacientes.get(index).setAlergias(alergias);
                break;
            case "diagnostico":
                System.out.print("Diagnostico: ");
                newAux = leitura.nextLine();
                pacientes.get(index).setDiagnostico(newAux);
                break;
            case "sintomas":
                System.out.print("Sintomas: ");
                newAux = leitura.nextLine();
                while (!"".equals(newAux)) {
                    sintomas.add(newAux);
                    newAux = leitura.nextLine();
                }
                pacientes.get(index).setSintomas(sintomas);
                break;
            case "tratamento":
                System.out.println("Tratamento: ");
                newAux = leitura.nextLine();
                pacientes.get(index).setTratamento(newAux);
                break;            
            default:
                System.out.println("Dado não encontrado");
                break;
        }
    }
    
    public void cadastrarProntuario(ArrayList<Paciente> paciente){
        int index = 0;
        boolean flag = false;
        String sint, diagnostico,tratamento;
        ArrayList<String> sintomas = new ArrayList<>();
        
        System.out.print("Nome do consultado: ");
        String name = leitura.nextLine();

        for (Paciente pacientes: paciente) {
            if (pacientes.getNome().equals(name)) {
                index = paciente.indexOf(pacientes);
                flag = true;
            }
        }
        
        if (flag){
            System.out.print("Sintomas: ");
            sint = leitura.nextLine();
            while (!"".equals(sint)){
                sintomas.add(sint);
                sint = leitura.nextLine();
            }
            
            System.out.print("Diagnostico da doença: ");
            diagnostico = leitura.nextLine();
            
            System.out.print("Prescricao do tratamento: ");
            tratamento = leitura.nextLine();
            
            paciente.get(index).prontuario(sintomas,diagnostico,tratamento);
            
            System.out.println("Prontuario cadastrado!");
            
        }else{
            System.out.println("O paciente não esta cadastrado");
        }
    }
        
    public void excluirProntuario(ArrayList<Paciente> paciente, int index){
        ArrayList<String> limpar = new ArrayList<>();
        paciente.get(index).prontuario(limpar, null, null);
        System.out.println("Prontuario de "+ paciente.get(index).getNome() +" excluido!");
    }
    
    public void excluirDados(ArrayList<Paciente> paciente, int index){
        ArrayList<String> limpar = new ArrayList<>();
        paciente.get(index).consultando(false, false, false, false, false, limpar, limpar);
        System.out.println("Dados de " + paciente.get(index).getNome() +"excluidos");
    }
    
    public void gerarRelatorioMed(ArrayList<Paciente> paciente, ArrayList<Consulta> consultados){
        System.out.println("------------------------------------\n"
                + "Pacientes consultados no mes: " + this.getTotalClienteMes());
        consultados.forEach((consultado) -> {
        System.out.println("------------------------------------");            
            int index = paciente.indexOf(consultado.getPaciente());
            System.out.println("\nPaciente: " + consultado.getPaciente().getNome() +"\n"
                    + "Receita: " + paciente.get(index).getTratamento() + "\n"
                    + "Eu, " + consultado.getMedico().getNome() + " confirmo que "
                    + consultado.getPaciente().getNome()+ " esteve \nem consulta em "
                    + consultado.getData() + " as "+ consultado.getHorario() +""
                    + " com um acompanhante");
        });
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEspecializaca() {
        return especializacao;
    }

    public void setEspecializaca(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getTotalClienteMes() {
        return TotalClienteMes;
    }

    public void setTotalClienteMes(int TotalClienteMes) {
        this.TotalClienteMes = TotalClienteMes;
    }    
}
