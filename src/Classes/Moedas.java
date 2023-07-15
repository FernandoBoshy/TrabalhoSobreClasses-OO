package Classes;

public abstract class Moedas {
    public String sigla;
    public double cotacao;
    public double quant;

    public Moedas(String sigla, double cotacao, double quant) {
        this.sigla = sigla;
        this.cotacao = cotacao;
        this.quant = 0.0;
    }

    public void atualizarDinheiro(Double valor) {
        if(valor < 0.0){
            System.out.println("Não aceita valores negativos.");
        } else if (valor == 0.0) {
            System.out.println("Valor Zerado.");
        } else {
            quant += valor;
            System.out.println("Valores Adicionados com Sucesso.");
        }
    }

    public void removerDinheiro(Double valor) {
        if(valor < 0.0){
            System.out.println("Não aceita valores negativos.");
        } else if (valor == 0.0) {
            System.out.println("Valor Zerado.");
        } else {
            quant -= valor;
            System.out.println("Valores Retirados com Sucesso.");
        }
        if (quant < 0) { quant = 0; }
    }
}