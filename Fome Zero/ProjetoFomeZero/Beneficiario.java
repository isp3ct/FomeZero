//CRIADOR: RUAN PABLO SIMÃO.

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Beneficiario {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        registrarReceptor();
    }

    public static void registrarReceptor() {
        System.out.println("\nAgora você pode escolher o local e horário para retirada da cesta básica:\n");

        mostrarLocais();
        System.out.print("Escolha o local (1, 2, 3): ");
        int escolhaLocal = input.nextInt();

        mostrarHorarios(escolhaLocal);

        System.out.print("Escolha o horário (1, 2): ");
        int escolhaHorario = input.nextInt();

        inserirDadosReceptor(escolhaLocal, escolhaHorario);
    }

    public static void mostrarLocais() {
        System.out.println("Locais disponíveis para retirada da cesta básica:");
        System.out.println("[1] PIB - Primeira Igreja Batista.\n" + //
                "Se encontra em: R. Barão de Jaceguai, 1019 - Centro, Mogi das Cruzes - SP, 08780-100\n");

        System.out.println("[2] Assembleia de Deus - Ministério Madureira\n" + //
                "Se encontra em: R. Cabo Diogo Oliver, 737 - Vila Mogilar, Mogi das Cruzes - SP, 08773-000\n");

        System.out.println("[3] Igreja Evangélica Bola de Neve\n" + //
                "Se encontra em: Av. São Paulo, 33 - Jardim Armenia, Mogi das Cruzes - SP, 08780-570\n");
    }

    public static void mostrarHorarios(int escolhaLocal) {
        Map<Integer, List<String>> horariosPorLocal = obterHorarios();

        System.out.println("Horários disponíveis para o Local " + (char) ('A' + escolhaLocal - 1) + ":");
        List<String> horarios = horariosPorLocal.get(escolhaLocal);
        for (int i = 0; i < horarios.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + horarios.get(i));
        }
    }

    public static Map<Integer, List<String>> obterHorarios() {
        Map<Integer, List<String>> horariosPorLocal = new HashMap<>();

        List<String> horariosLocalA = Arrays.asList("8:00 - 10:00", "14:00 - 16:00");
        List<String> horariosLocalB = Arrays.asList("10:00 - 12:00", "16:00 - 18:00");
        List<String> horariosLocalC = Arrays.asList("12:00 - 14:00", "18:00 - 20:00");

        horariosPorLocal.put(1, horariosLocalA);
        horariosPorLocal.put(2, horariosLocalB);
        horariosPorLocal.put(3, horariosLocalC);

        return horariosPorLocal;
    }

    public static void inserirDadosReceptor(int escolhaLocal, int escolhaHorario) {
        System.out.println("Receptor registrado para retirada no Local " +
                (char) ('A' + escolhaLocal - 1) +
                ", Horário " + escolhaHorario);
    }
}
