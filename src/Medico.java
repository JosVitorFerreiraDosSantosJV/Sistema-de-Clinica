import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medico {
    private String nome;
    private String especialidade;
    private String crm;
    private Map<String, List<String>> horariosAtendimento;
    private String salaAtendimento;

    public Medico(String nome, String especialidade, String crm, String salaAtendimento) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.salaAtendimento = salaAtendimento;
        this.horariosAtendimento = new HashMap<>();
    }

    public void adicionarHorarioAtendimento(String dia, List<String> horarios) {
        horariosAtendimento.put(dia, horarios);
    }

    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getCrm() { return crm; }
    public String getSalaAtendimento() { return salaAtendimento; }
    public Map<String, List<String>> getHorariosAtendimento() { return horariosAtendimento; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public void setSalaAtendimento(String salaAtendimento) { this.salaAtendimento = salaAtendimento; }
}
