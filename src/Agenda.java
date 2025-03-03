import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agenda {
   private String data;
   private Medico medico;
   private Map<String, Paciente> pacientes;

   public Agenda(Medico medico, String data) {
       this.medico = medico;
       this.data = data;
       this.pacientes = new HashMap<>();
   }

   public boolean adicionarConsulta(String horario, Paciente paciente) {
       if (!medico.getHorariosAtendimento().getOrDefault(data, List.of()).contains(horario)) {
           System.out.println("Horário não disponível!");
           return false;
       }
       pacientes.put(horario, paciente);
       System.out.println("Consulta marcada para " + paciente.getNome() + " às " + horario);
       return true;
   }
   public void cancelarConsulta(String horario){
       if (pacientes.containsKey(horario)) {
           Paciente p = pacientes.remove(horario);
           System.out.println("Consulta de " + p.getNome() + " às " + horario + " cancelada.");
       } else {
           System.out.println("Nenhuma consulta encontrada nesse horário.");
       }
   }
   public void apresentarAgenda() {
       System.out.println("Agenda do Dr. " + medico.getNome() + " - " + medico.getEspecialidade());
       for (var entrada : pacientes.entrySet()) {
           System.out.println("Horário: " + entrada.getKey() + " - Paciente: " + entrada.getValue().getNome());
       }
   }

    public Medico getMedico() { return medico; }
    public String getData() { return data; }
}
