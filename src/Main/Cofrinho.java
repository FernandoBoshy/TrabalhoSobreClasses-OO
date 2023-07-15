package Main;

import Classes.Moedas;

import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moedas> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public void adicionarMoeda(Moedas moeda, Double quant) {
        moeda.atualizarDinheiro(quant);
    }

    public void removerMoeda(Moedas moeda, Double quant) {
        moeda.removerDinheiro(quant);
    }

    public void listarMoedas(ArrayList<Moedas> listaMoedas) {

        if (listaMoedas.get(0).quant > 0.0){
            System.out.println("Quantidade de Dolares: " + listaMoedas.get(0).quant);
        } else { System.out.println("Sem Dolares na carteira..."); }

        if (listaMoedas.get(1).quant > 0.0){
            System.out.println("Quantidade de Reais: " + listaMoedas.get(1).quant);
        } else { System.out.println("Sem Reais na carteira..."); }

        if (listaMoedas.get(2).quant > 0.0) {
            System.out.println("Quantidade de Euros: " + listaMoedas.get(2).quant);
        } else { System.out.println("Sem Euros na carteira..."); }

    }

    public double calcularTotalEmReais(ArrayList<Moedas> listaMoedas) {
        double total =  (listaMoedas.get(0).quant * listaMoedas.get(0).cotacao) +
                        (listaMoedas.get(1).quant * listaMoedas.get(1).cotacao) +
                        (listaMoedas.get(2).quant * listaMoedas.get(2).cotacao);
        return total;
    }
}
