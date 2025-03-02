import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;
import java.util.List;
import java.util.regex.Pattern;

public class Paciente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private List<String> historicoMedico;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String telefone, String historicoMedico) {
        if (!validarCpf(cpf)){
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.historicoMedico = new ArrayList<>();
    }

    private boolean validarCpf(String cpf) {
        return Pattern.matches("\\d{11}", cpf);
    }

    public int calcularIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public void adicionarNotaHistorico(String nota) {
        historicoMedico.add(nota);
    }

    public void exibirHistorico(){
        System.out.println("\n=== Histórico Médico de " + nome + " ===");
        if (historicoMedico.isEmpty()) {
            System.out.println("Nenhuma nota adicionada.");
        } else {
            for (String nota : historicoMedico) {
                System.out.println("- " + nota);
            }
        }
    }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getTelefone() { return telefone; }
    public List<String> getHistoricoMedico() { return historicoMedico; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
