package trabalho.pkg1;

import java.util.ArrayList;

public class Paciente extends Pessoa {
    
    private String cpf;
    private String tipoConvenio;
    private boolean fuma;
    private boolean bebe;
    private boolean colesterol;
    private boolean diabete;
    private boolean doencaCardiaca;
    private ArrayList<String> cirurgias = new ArrayList<>();
    private ArrayList<String> alergias = new ArrayList<>();
    private ArrayList<String> sintomas = new ArrayList<>();
    private String diagnostico, tratamento;

    
    //sets pra private
    public Paciente(String tipoConvenio, String nome, String dataNascimento, String endereco,
                    String email, String telefone) {
        
        super(nome, dataNascimento, endereco, email, telefone);
        this.tipoConvenio = tipoConvenio;
    }

    public void consultando(boolean fuma,boolean bebe, boolean colesterol, 
            boolean diabete, boolean doencaCardiaca, 
            ArrayList<String> cirurgias, ArrayList<String> alergias){
        this.setFuma(fuma);
        this.setBebe(bebe);
        this.setColesterol(colesterol);
        this.setDiabete(diabete);
        this.setDoencaCardiaca(doencaCardiaca);
        this.setCirurgias(cirurgias);
        this.setAlergias(alergias);
    }
    
    public void prontuario(ArrayList<String> sintomas,String diagnostico,String tratamento){
        this.setDiagnostico(diagnostico);
        this.setSintomas(sintomas);
        this.setTratamento(tratamento);
    }
    
    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean isColesterol() {
        return colesterol;
    }

    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public ArrayList<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(ArrayList<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}