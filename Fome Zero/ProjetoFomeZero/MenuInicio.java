//CRIADOR: JOÃO VICTOR DOS SANTOS COSTA


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
            System.out.print("Seja bem-vindo ao programa de doações UMC Solidária!\nVocê deseja:\n[1] Login\n[2] Cadastrar\n[0] Sair\n");
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
            break;
        }

        input.close();
    }
}
