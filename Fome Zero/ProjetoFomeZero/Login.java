//CRIADOR: GUILHERME DAL BIANCO.


import java.util.Map;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        logar();
    }

    public static boolean logar() {
        Scanner input = new Scanner(System.in);
        boolean validacaoEmail = false;
        boolean validacao = false;

        while (!validacaoEmail) {
            System.out.println("Entre com seu e-mail: ");
            String email = input.nextLine();

            if (validarEmail(email)) {
                validacaoEmail = true;
                while (!validacao) {
                    System.out.println("Insira o seu CPF:");
                    String cpf = input.nextLine();

                    if (cpfValido(cpf)) {
                        
                        // Agora, chama o método selectLogin para validar o login
                        DAO dao = new DAO();
                        Map<String, Integer> usuarios = dao.selectLogin(email, cpf);

                        if (usuarios.get("tipoUsuarioId") == 1) {
                            
                            System.out.println("Login bem-sucedido!");
                            Doador doador = new Doador();
                            doador.realizarDoacoes(usuarios.get("usuarioId"));
                            validacao = true;
                        }
                        
                        else if (usuarios.get("tipoUsuarioId") == 2) {
                            
                            System.out.println("Login bem-sucedido!");
                            Beneficiario.mostrarLocais();
                            validacao = true;
                        } 
                        
                        else {
                            System.out.println("Dados de login inválidos. Tente novamente.");
                        }
                    } else {
                        System.out.println("CPF inválido. Tente novamente.");
                    }
                }
            } else {
                System.out.println("E-mail inválido. Tente novamente.");
            }
        }

        input.close();
        return true;
    }

    public static boolean cpfValido(String cpf) {
        return cpf.matches("\\d{11}");  //Verifica se o CPF tem 11 dígitos.
    }

    public static boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";   //Validação BÁSICA para o e-mail. Podendo não cobrir todos os casos.
        return email.matches(regex);
    }
}
