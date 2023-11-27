import telas.*;
import javax.swing.*;
import java.util.*;

public class AppGUI {

    private static CameraGUI cameraGui = new CameraGUI(1, "12:00 - 13/10/2023", "19:00 - 13/10/2023");
    private static GaragemGUI garagemGui = new GaragemGUI(false, 60, 12);

    private static List<PessoaGUI> inquilinosGUI = new ArrayList<>();

    public static void limpar_Tela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void cadastrar_Inquilino() {
        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField nApartamentoField = new JTextField();
        JTextField qtdVeiculosField = new JTextField();
        JTextField generoField = new JTextField();

        Object[] message = {
                "Nome:", nomeField,
                "CPF:", cpfField,
                "Número do Apartamento:", nApartamentoField,
                "Quantidade de Veículos:", qtdVeiculosField,
                "Gênero:", generoField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cadastrando novo inquilino", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            int nApartamento = Integer.parseInt(nApartamentoField.getText());
            int qtdVeiculos = Integer.parseInt(qtdVeiculosField.getText());
            String genero = generoField.getText();

            PessoaGUI novoInquilino = new PessoaGUI(nome, cpf, nApartamento, qtdVeiculos, genero);
            inquilinosGUI.add(novoInquilino);
            JOptionPane.showMessageDialog(null, "Novo inquilino cadastrado com sucesso: " + novoInquilino.getNome());
        }
    }

    public static void fazer_Login() {
        JTextField cpfField = new JTextField();
        JTextField nApartamentoField = new JTextField();

        Object[] message = {
                "Digite o CPF:", cpfField,
                "Digite o número do apartamento:", nApartamentoField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String cpfInput = cpfField.getText();
            int nApartamentoInput = Integer.parseInt(nApartamentoField.getText());

            boolean found = false;
            PessoaGUI inquilinoEncontrado = null;
            for (PessoaGUI inquilino : inquilinosGUI) {
                if (inquilino.getCpf().equals(cpfInput) && inquilino.getN_apartamento() == nApartamentoInput) {
                    found = true;
                    inquilinoEncontrado = inquilino;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, "Olá, " + inquilinoEncontrado.getNome() + "!");
                boolean loggedIn = true;
                while (loggedIn) {
                    Object[] options = {"Requisitar Vagas", "Atribuir Veiculo", "Voltar ao Menu"};
                    int opcaoLogado = JOptionPane.showOptionDialog(
                            null,
                            "Selecione uma opção:",
                            "Opções",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    switch (opcaoLogado) {
                        case 0:
                            inquilinoEncontrado.requisitarVagas();
                            break;
                        case 1:
                            inquilinoEncontrado.atribuirVeiculo();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Retornando ao menu inicial.");
                            loggedIn = false;
                            limpar_Tela();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Retornando para o menu inicial.");
            }
        }
    }

    public static void login_ADM() {
        JTextField usuarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        Object[] message = {
                "Usuário:", usuarioField,
                "Senha:", senhaField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login ADM", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword());

            if (usuario.equals("admin") && senha.equals("admin123")) {
                limpar_Tela();
                boolean logado = true;
                while (logado) {
                    Object[] options = {"Abrir portão", "Fechar portão", "Exibir gravações das câmeras", "Voltar ao Menu Inicial"};
                    int opcao = JOptionPane.showOptionDialog(
                            null,
                            "Login bem-sucedido. Bem-vindo, Administrador!\nO portão está " + (garagemGui.isEstado() ? "aberto." : "fechado."),
                            "Opções",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    switch (opcao) {
                        case 0:
                            limpar_Tela();
                            garagemGui.abrirPortao();
                            break;

                        case 1:
                            limpar_Tela();
                            garagemGui.fecharPortao();
                            break;

                        case 2:
                            cameraGui.exibirFilmagem(usuario);
                            limpar_Tela();
                            break;

                        case 3:
                            limpar_Tela();
                            logado = false;
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Retornando para o menu inicial.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        boolean running = true;

        while (running) {
            Object[] options = {"Cadastrar Inquilino", "Login - Inquilinos", "Login - ADM", "Fechar"};
            int opcao = JOptionPane.showOptionDialog(
                    null,
                    "Bem-vindo ao sistema de estacionamento!",
                    "Opções",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (opcao) {
                case 0:
                    limpar_Tela();
                    JOptionPane.showMessageDialog(null, "Você escolheu cadastrar inquilino.");
                    cadastrar_Inquilino();
                    break;

                case 1:
                    limpar_Tela();
                    JOptionPane.showMessageDialog(null, "Você escolheu fazer Login.");
                    fazer_Login();
                    break;

                case 2:
                    limpar_Tela();
                    JOptionPane.showMessageDialog(null, "Você escolheu Login ADM.");
                    login_ADM();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema. Obrigado!");
                    running = false;
                    break;

                default:
                    limpar_Tela();
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
