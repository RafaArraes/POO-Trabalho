package trabalho.pkg1;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorDeMsg {
    
    public void enviarMSG(ArrayList<Consulta> consultas){
        LocalDate data = LocalDate.now();
        
        String mes = Integer.toString(data.getMonthValue()), 
                dia = Integer.toString(data.getDayOfMonth()+1), 
                ano = Integer.toString(data.getYear());
        String aux, date[];
        
        for (Consulta consulta: consultas){
            aux = consulta.getData();
            date = aux.split("/");
            if (date[2].equals(ano) 
                    && (date[1].equals(mes)) 
                    &&(date[0].equals(dia))){
                System.out.println("\nEnviando mensagem para " + consulta.getPaciente().getNome()
                    + "\nSobre consulta dia " + dia +" (amanha) às "+consulta.getHorario()+"\n");
            }
        }
    }
}
