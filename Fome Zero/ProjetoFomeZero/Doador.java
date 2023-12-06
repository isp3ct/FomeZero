//CRIADOR: JOÃO VICTOR DOS SANTOS COSTA

import java.util.Scanner;

public class Doador {

    private DAO dao;

    public Doador() {
        this.dao = new DAO();
    }

    public void realizarDoacoes(int idUsuario) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nBem vindo, doador! Qual seria seu método de doação?\n");
        System.out.print("[1] PIX \n[2] Doação de alimentos não perecíveis\n");

        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Escolha a ONG que deseja doar dinheiro:\n");
                System.out.print("[1] PIB - Primeira Igreja Batista\n");
                System.out.print("[2] Assembleia de Deus - Ministério Madureira\n");
                System.out.print("[3] Igreja Evangélica Bola de Neve\n");

                int localPix = input.nextInt();

                switch (localPix) {
                    case 1:
                        System.out.print("Você selecionou a ONG: PIB - Primeira Igreja Batista.\nSe encontra em: R. Barão de Jaceguai, 1019 - Centro, Mogi das Cruzes - SP, 08780-100\nO código PIX para doações é: 52.579.836/0001-96");
                        break;

                    case 2:
                        System.out.print("Você selecionou a ONG: Assembleia de Deus - Ministério Madureira\nSe encontra em: R. Cabo Diogo Oliver, 737 - Vila Mogilar, Mogi das Cruzes - SP, 08773-000\nO código PIX para doações é: admogimadureira@gmail.com");
                        break;

                    case 3: 
                        System.out.print("Você selecionou a ONG: Igreja Evangélica Bola de Neve\nSe encontra em: Av. São Paulo, 33 - Jardim Armenia, Mogi das Cruzes - SP, 08780-570\nO código PIX para doações é: 04.239.797/0001-35");
                        break;

                    default:
                        System.out.print("Você selecionou uma opção inválida, por favor tente novamente!");
                        break;
                }
                break;

            case 2:
                System.out.print("Você selecionou a opção de doar alimentos não perecíveis\nPor favor selecione o alimento que deseja doar:\n");
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
        }
        input.close();
    }
}
