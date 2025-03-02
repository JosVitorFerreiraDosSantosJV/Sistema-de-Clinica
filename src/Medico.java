public class Medico {
    private String nome;
    private String especialidade;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
}
