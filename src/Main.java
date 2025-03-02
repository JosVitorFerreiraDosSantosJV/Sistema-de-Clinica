public class Main {
    public static void main(String[] args) {

        Medico olival = new Medico("Olival","Oftalmologista");
        Medico gabriela = new Medico("Gabriela","Ginecologista");

        Paciente p1 = new Paciente("Pedro","000",30,"0000");
        Paciente p2 = new Paciente("Karol","111",25,"1111");
        Paciente p3 = new Paciente("Marcela","222",28,"2222");
        Paciente p4 = new Paciente("Roberto","333",34,"3333");
        Paciente p5 = new Paciente("Yolanda", "444",21,"4444");

        Agenda agenda1 = new Agenda(olival);
        agenda1.setData("22/10/2030");
        agenda1.adicionar(p1);
        agenda1.adicionar(p4);
        agenda1.apresentarListaDePacientes();

        Agenda agenda2 = new Agenda(gabriela);
        agenda2.setData("25/10/2030");
        agenda2.adicionar(p3);
        agenda2.adicionar(p2);
        agenda2.adicionar(p5);
        agenda2.remover("111");
        agenda2.apresentarListaDePacientes();

    }
}