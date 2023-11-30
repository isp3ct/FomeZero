//CRIADOR: BRUNO DOS SANTOS PEREIRA DO NASCIMENTO


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Registro {

    private DAO dao;
    private String nome;
    private String dataNascimento;
    private String email;
    private String cpf;
    private Date dataFormatada;

    public Registro(DAO dao) {
        this.dao = dao;
    }

    public void main(String[] args) {
        registrar();
    }

    public void registrar() {
        Scanner input = new Scanner(System.in);
        Double rendaMinima = 1320.0;
        boolean validacao = false;

        // Estabelece a conexão com o banco de dados

        while (!validacao) {
            System.out.print("Para dar início ao projeto, precisamos do seu nome: ");
            nome = input.nextLine();
            if (validarNome(nome)) {
                validacao = true;
            } else {
                limparConsole();
                System.out.println("Nome inválido. Tente novamente.");
            }
        }

        validacao = false;
        limparConsole();

        while (!validacao) {
            System.out.print("Insira a sua data de nascimento em formato (dia/mes/ano por extenso):  ");
            dataNascimento = input.nextLine();

            if (validarDataNascimento(dataNascimento)) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    dataFormatada = sdf.parse(dataNascimento);
                    validacao = true;
                } catch (ParseException e) {
                    throw new RuntimeException("Erro ao converter data.", e);
                }
            } else {
                limparConsole();
                System.out.println("A data de nascimento é inválida!");
            }
        }

        validacao = false;
        limparConsole();

        while (!validacao) {
            System.out.print("Para dar continuação, me fale seu e-mail: ");
            email = input.nextLine();

            if (validarEmail(email)) {
                validacao = true;
            } else {
                limparConsole();
                System.out.println("E-mail inválido. Tente novamente.");
            }
        }

        validacao = false;
        limparConsole();

        while (!validacao) {
            System.out.print("OK, vou precisar do seu CPF: ");
            cpf = input.nextLine();

            if (cpfValido(cpf)) {
                validacao = true;
            } else {
                limparConsole();
                System.out.println("CPF inválido. Tente novamente.");
            }
        }

        validacao = false;
        limparConsole();

        while (!validacao) {
            System.out.println("Agora para finalizar, você é:\n[1] Doador\n[2] Beneficiário");
            int escolhaRegistro = input.nextInt();

            limparConsole();

            switch (escolhaRegistro) {
                case 1:
                    limparConsole();
                    System.out.println("Registro feito com sucesso! Obrigado por participar dessa campanha!");
                    int usuarioId = dao.inserirDadosUsuario(nome, dataFormatada, email, cpf, escolhaRegistro);
                    System.out.print("\nEsse é o doador"+usuarioId);
                    Doador doador = new Doador();  
                    doador.realizarDoacoes(usuarioId);
                    break;

                case 2:
                    limparConsole();
                    System.out.println("Certo, para se tornar um beneficiário você precisa responder umas perguntas extras.\n\nQual é sua renda mensal?");
                    double rendaMensal = input.nextDouble();

                    limparConsole();
                    System.out.println("Qual é a quantidade de pessoas que vivem na mesma casa?");
                    int numeroPessoas = input.nextInt();

                    double rendaPerCapita = rendaMensal / numeroPessoas;

                    if (rendaPerCapita < rendaMinima) {
                        System.out.print("A família é apta para receber a cesta básica. Registro completado!");
                        dao.inserirDadosUsuario(nome, dataFormatada, email, cpf, escolhaRegistro);
                        Beneficiario.registrarReceptor();
                    } else {
                        System.out.print("A família não é apta para receber a cesta básica. Falha no registro!");
                    }
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente com as opções existentes!\n");
                    continue;
            }
            break;
        }

        input.close();
    }

    private boolean validarNome(String nome) {
        return nome != null && nome.matches("^[a-zA-Z\\s]*$");
    }

    private boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    private boolean validarDataNascimento(String dataNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dataNascimento);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean cpfValido(String cpf) {
        return cpf.matches("\\d{11}"); // Verifica se o CPF tem 11 dígitos.
    }

    private void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
