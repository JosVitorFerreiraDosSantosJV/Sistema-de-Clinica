import java.time.LocalDate;
import java.util.*;

public class SistemaClinica {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Agenda> agendas;
    private Scanner scanner;

    public SistemaClinica() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.agendas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void executar(){
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gerenciar Médicos");
            System.out.println("2. Gerenciar Pacientes");
            System.out.println("3. Gerenciar Agendamentos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuMedicos();
                    break;
                case 2:
                    menuPacientes();
                    break;
                case 3:
                    menuAgendamento();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opçao inválida.");
            }
        }
    }
    // ====================== MÉTODOS CRUD MÉDICOS ======================
    private void menuMedicos() {
        while (true) {
            System.out.println("\n=== Gerenciar Médicos ===");
            System.out.println("1. Adicionar Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Atualizar Médico");
            System.out.println("4. Remover Médico");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMedico();
                    break;
                case 2:
                    listarMedicos();
                    break;
                case 3:
                    atualizarMedico();
                    break;
                case 4:
                    removerMedico();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarMedico() {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Sala de atendimento: ");
        String sala = scanner.nextLine();

        Medico medico = new Medico(nome, especialidade, crm, sala);
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    private void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Médicos ===");
        for (Medico m : medicos) {
            System.out.println("Nome: " + m.getNome() + " | CRM: " + m.getCrm() + " | Especialidade: " + m.getEspecialidade());
        }
    }

    private void atualizarMedico() {
        System.out.println("Digite o CRM do médico a ser atualizado: ");
        String crm = scanner.nextLine();
        for (Medico m : medicos) {
            if (m.getCrm().equals(crm)) {
                System.out.print("Novo nome: ");
                m.setNome(scanner.nextLine());
                System.out.print("Nova especialidade: ");
                m.setEspecialidade(scanner.nextLine());
                System.out.print("Nova sala: ");
                m.setSalaAtendimento(scanner.nextLine());
                System.out.println("Médico atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Médico não encontrado.");
    }

    private void removerMedico() {
        System.out.print("Digite o CRM do médico a ser removido: ");
        String crm = scanner.nextLine();
        medicos.removeIf(m -> m.getCrm().equals(crm));
        System.out.println("Médico removido com sucesso!");
    }
    // ====================== MÉTODOS CRUD PACIENTES ======================

    private void menuPacientes() {
        while (true) {
            System.out.println("\n=== Gerenciar Pacientes ===");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Remover Paciente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    atualizarPaciente();
                    break;
                case 4:
                    removerPaciente();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarPaciente() {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, telefone, "");
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Pacientes ===");
        for (Paciente p : pacientes) {
            System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf() + " | Idade: " + p.calcularIdade());
        }
    }

    private void atualizarPaciente() {
        System.out.print("Digite o CPF do paciente a ser atualizado: ");
        String cpf = scanner.nextLine();
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                p.setNome(scanner.nextLine());
                System.out.print("Novo telefone: ");
                p.setTelefone(scanner.nextLine());
                System.out.println("Paciente atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private void removerPaciente() {
        System.out.print("Digite o CPF do paciente a ser removido: ");
        String cpf = scanner.nextLine();
        pacientes.removeIf(p -> p.getCpf().equals(cpf));
        System.out.println("Paciente removido com sucesso!");
    }
    // ====================== MÉTODOS AGENDAMENTO ======================

    private void menuAgendamento() {
        while (true) {
            System.out.println("\n=== Gerenciar Agendamentos ===");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Listar Consultas");
            System.out.println("4. Ver Agenda de um Médico");
            System.out.println("5. Adicionar Nota ao Histórico do Paciente");
            System.out.println("6. Ver Histórico de um Paciente");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    agendarConsulta();
                    break;
                case 2:
                    cancelarConsulta();
                    break;
                case 3:
                    listarConsultas();
                    break;
                case 4:
                    verAgendaMedico();
                    break;
                case 5:
                    adicionarNotaHistorico();
                    break;
                case 6:
                    verHistoricoPaciente();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void agendarConsulta() {
        System.out.println("=== Agendamento de Consulta ===");

        // Selecionar médico
        listarMedicos();
        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medicoSelecionado = buscarMedicoPorCRM(crm);

        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        // Selecionar paciente
        listarPacientes();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente pacienteSelecionado = buscarPacientePorCPF(cpf);

        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Inserir data e horário
        System.out.print("Digite a data da consulta (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.print("Digite o horário da consulta (HH:MM): ");
        String horario = scanner.nextLine();

        // Verificar se já existe uma agenda para essa data
        Agenda agenda = buscarAgenda(medicoSelecionado, data);
        if (agenda == null) {
            agenda = new Agenda(medicoSelecionado, data);
            agendas.add(agenda);
        }

        // Agendar consulta
        if (agenda.adicionarConsulta(horario, pacienteSelecionado)) {
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Erro ao agendar consulta. Verifique se o horário está disponível.");
        }
    }

    private void cancelarConsulta() {
        System.out.println("=== Cancelamento de Consulta ===");

        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medico = buscarMedicoPorCRM(crm);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data da consulta (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        Agenda agenda = buscarAgenda(medico, data);

        if (agenda == null) {
            System.out.println("Não há consultas marcadas para essa data.");
            return;
        }

        System.out.print("Digite o horário da consulta a cancelar (HH:MM): ");
        String horario = scanner.nextLine();
        agenda.cancelarConsulta(horario);
    }

    private void listarConsultas() {
        System.out.println("\n=== Lista de Consultas Agendadas ===");

        if (agendas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        for (Agenda agenda : agendas) {
            agenda.apresentarAgenda();
        }
    }

    private void verAgendaMedico() {
        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medico = buscarMedicoPorCRM(crm);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.println("\n=== Agenda do Dr. " + medico.getNome() + " ===");
        for (Agenda agenda : agendas) {
            if (agenda.getMedico().equals(medico)) {
                agenda.apresentarAgenda();
            }
        }
    }

    private void adicionarNotaHistorico() {
        System.out.println("\n=== Adicionar Nota ao Histórico ===");

        // Selecionar paciente
        listarPacientes();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = buscarPacientePorCPF(cpf);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Adicionar a nota
        System.out.print("Digite a nota da consulta: ");
        String nota = scanner.nextLine();
        paciente.adicionarNotaHistorico(nota);
        System.out.println("Nota adicionada ao histórico do paciente!");
    }

    private void verHistoricoPaciente() {
        System.out.println("\n=== Ver Histórico de um Paciente ===");

        // Selecionar paciente
        listarPacientes();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = buscarPacientePorCPF(cpf);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Exibir histórico
        paciente.exibirHistorico();
    }

    private Medico buscarMedicoPorCRM(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        return null;
    }

    private Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    private Agenda buscarAgenda(Medico medico, String data) {
        for (Agenda agenda : agendas) {
            if (agenda.getMedico().equals(medico) && agenda.getData().equals(data)) {
                return agenda;
            }
        }
        return null;
    }
}
