package Main;

import Classes.Dolar;
import Classes.Euro;
import Classes.Moedas;
import Classes.Real;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);
        double opcao = 0;

        ArrayList<Moedas> listamoedas = new ArrayList<Moedas>();
        Dolar dolar = new Dolar();
        Real real = new Real();
        Euro euro = new Euro();
        listamoedas.add(dolar);
        listamoedas.add(real);
        listamoedas.add(euro);


        while (opcao != 5) {
            opcoes();
            opcao = retornaDouble(scanner.nextLine());

            switch ((int) opcao) {
                case (int) 1.0:
                    adicionarMoeda(cofrinho, scanner, listamoedas);
                    break;
                case (int) 2.0:
                    removerMoeda(cofrinho, scanner, listamoedas);
                    break;
                case (int) 3.0:
                    listarMoedas(cofrinho, listamoedas);
                    break;
                case (int) 4.0:
                    calcularTotalEmReais(cofrinho, listamoedas);
                    break;
                case (int)5.0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Inválido.");
                    break;
            }
        }

        scanner.close();
    }

    public static void opcoes() {
        System.out.println("_-_-_ Menu _-_-_");
        System.out.println("1- Adicionar moedas");
        System.out.println("2- Remover moedas");
        System.out.println("3- Listar moedas");
        System.out.println("4- Calcular total em Reais");
        System.out.println("5- Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void adicionarMoeda(Cofrinho cofrinho, Scanner scanner, ArrayList<Moedas> listaMoedas) {
        System.out.print("Digite o tipo de moeda (Dolar, Euro, Real): ");
        String tipoMoeda = scanner.nextLine();

        double quantMoeda;
        Moedas moeda;

        switch (tipoMoeda.toLowerCase().trim()) {
            case "dolar" -> {
                System.out.print("Digite a quantidade, em Dolares: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(0);
            }
            case "real" -> {
                System.out.print("Digite a quantidade, em Reais: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(1);
            }
            case "euro" -> {
                System.out.print("Digite a quantidade, em Euros: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(2);
            }
            default -> {
                System.out.println("Tipo de moeda inválido.");
                return;
            }
        }

        if(quantMoeda < 0.0){
            quantMoeda = 0.0;
            System.out.println("Quantidada negativa inválida. . .");
        }
        cofrinho.adicionarMoeda(moeda, quantMoeda);
    }

    public static void removerMoeda(Cofrinho cofrinho, Scanner scanner, ArrayList<Moedas> listaMoedas) {
        System.out.print("Digite o tipo de moeda (Dolar, Euro, Real): ");
        String tipoMoeda = scanner.nextLine();

        double quantMoeda;
        Moedas moeda;

        switch (tipoMoeda.toLowerCase().trim()) {
            case "dolar" -> {
                System.out.print("Digite a quantidade, em Dolares: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(0);
            }
            case "euro" -> {
                System.out.print("Digite a quantidade, em Euros: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(2);
            }
            case "real" -> {
                System.out.print("Digite a quantidade, em Reais: ");
                quantMoeda = retornaDouble(scanner.nextLine());
                moeda = listaMoedas.get(1);
            }
            default -> {
                System.out.println("Tipo de moeda inválido.");
                return;
            }
        }

        if(quantMoeda < 0.0){
            quantMoeda = 0.0;
            System.out.println("Quantidada negativa inválida. . .");
        }

        cofrinho.removerMoeda(moeda, quantMoeda);
    }

    public static void listarMoedas(Cofrinho cofrinho, ArrayList<Moedas> listaMoedas) {
        cofrinho.listarMoedas(listaMoedas);
    }

    public static void calcularTotalEmReais(Cofrinho cofrinho, ArrayList<Moedas> listaMoedas) {
        double total = cofrinho.calcularTotalEmReais(listaMoedas);
        System.out.println("Total em Reais: " + total);
    }

    public static Double retornaDouble(String valor){
        try{
            valor = valor.replace(",",".");
            return Double.parseDouble(valor);
        } catch(NumberFormatException e) {
            System.out.println("Não é um valor...");
            return 0.0;
        }

    }
}
