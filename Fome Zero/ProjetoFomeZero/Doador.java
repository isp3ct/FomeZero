import java.util.Scanner;

public class Doador {
    private DAO dao;

    public Doador() {
        this.dao = new DAO();
    }

    public void realizarDoacoes(int idUsuario) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo, doador! Qual seria seu método de doação?");
        System.out.println("[1] PIX");
        System.out.println("[2] Doação de alimentos não perecíveis");

        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Escolha a ONG que deseja doar dinheiro:");
                System.out.println("[1] PIB - Primeira Igreja Batista");
                System.out.println("[2] Assembleia de Deus - Ministério Madureira");
                System.out.println("[3] Igreja Evangélica Bola de Neve");

                int localPix = input.nextInt();

                switch (localPix) {
                    case 1:
                        System.out.println("Você selecionou a ONG: PIB - Primeira Igreja Batista.");
                        System.out.println("Se encontra em: R. Barão de Jaceguai, 1019 - Centro, Mogi das Cruzes - SP, 08780-100");
                        System.out.println("O código PIX para doações é: 52.579.836/0001-96");
                        break;

                    case 2:
                        System.out.println("Você selecionou a ONG: Assembleia de Deus - Ministério Madureira");
                        System.out.println("Se encontra em: R. Cabo Diogo Oliver, 737 - Vila Mogilar, Mogi das Cruzes - SP, 08773-000");
                        System.out.println("O código PIX para doações é: admogimadureira@gmail.com");
                        break;

                    case 3:
                        System.out.println("Você selecionou a ONG: Igreja Evangélica Bola de Neve");
                        System.out.println("Se encontra em: Av. São Paulo, 33 - Jardim Armenia, Mogi das Cruzes - SP, 08780-570");
                        System.out.println("O código PIX para doações é: 04.239.797/0001-35");
                        break;

                    default:
                        System.out.println("Você selecionou uma opção inválida, por favor tente novamente!");
                        break;
                }
                break;

            case 2:
                System.out.println("Você selecionou a opção de doar alimentos não perecíveis");
                System.out.println("Por favor, selecione o alimento que deseja doar:");
                dao.realizarSelectProdutos();

                int opcaoAlimento = input.nextInt();

                switch (opcaoAlimento) {
                    case 1:
                        System.out.print("Você selecionou Arroz. Insira a quantidade em pacotes: ");
                        int qtdArroz = input.nextInt();
                        dao.inserirDoacao(idUsuario, opcaoAlimento, qtdArroz);
                        break;

                    case 2:
                        System.out.print("Você selecionou Feijão. Insira a quantidade em pacotes: ");
                        int qtdFeijao = input.nextInt();
                        dao.inserirDoacao(idUsuario, opcaoAlimento, qtdFeijao);
                        break;

                    case 3:
                        System.out.print("Você selecionou Óleo. Insira a quantidade em litros: ");
                        int litrosOleo = input.nextInt();
                        dao.inserirDoacao(idUsuario, opcaoAlimento, litrosOleo);
                        break;

                    case 4:
                        System.out.print("Você selecionou Sabonete. Insira a quantidade em unidades: ");
                        int unSabonete = input.nextInt();
                        dao.inserirDoacao(idUsuario, opcaoAlimento, unSabonete);
                        break;

                    case 5:
                        System.out.print("Você selecionou Sal Refinado. Insira a quantidade em pacotes: ");
                        int qtdSal = input.nextInt();
                        dao.inserirDoacao(idUsuario, opcaoAlimento, qtdSal);
                        break;

                    default:
                        break;
                }
                break;

            default:
                break;
        }
        input.close();
    }
}
