import java.util.Scanner;

public class MenuInicio {

    public static void main(String[] args) {
        MenuInicio menuInicio = new MenuInicio();
        menuInicio.menu();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seja bem-vindo ao programa de doações UMC Solidária!");
            System.out.println("Você deseja:");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastrar");
            System.out.println("[0] Sair");

            int opcaoInicio = input.nextInt();

            switch (opcaoInicio) {
                case 1:
                    Login.logar();
                    break;

                case 2:
                    Registro registro = new Registro(new DAO());
                    registro.registrar();
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }
}
