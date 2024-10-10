class Veiculo {
    private String tipo;
    private String cor;
    private int ano;

    public Veiculo(String tipo, String cor, int ano) {
        this.tipo = tipo;
        this.cor = cor;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                '}';
    }
}

interface VeiculoBuilder {
    VeiculoBuilder definirTipo(String tipo);
    VeiculoBuilder definirCor(String cor);
    VeiculoBuilder definirAno(int ano);
    Veiculo construir();
}

class VeiculoBuilderImpl implements VeiculoBuilder {
    private String tipoVeiculo;
    private String corVeiculo;
    private int anoFabricacao;

    @Override
    public VeiculoBuilder definirTipo(String tipo) {
        this.tipoVeiculo = tipo;
        return this;
    }

    @Override
    public VeiculoBuilder definirCor(String cor) {
        this.corVeiculo = cor;
        return this;
    }

    @Override
    public VeiculoBuilder definirAno(int ano) {
        this.anoFabricacao = ano;
        return this;
    }

    @Override
    public Veiculo construir() {
        return new Veiculo(tipoVeiculo, corVeiculo, anoFabricacao);
    }
}

// Exemplo de uso:
public class Aplicacao {
    public static void main(String[] args) {
        VeiculoBuilder builder = new VeiculoBuilderImpl();

        Veiculo veiculo = builder
            .definirTipo("Fiat")
            .definirCor("Azul")
            .definirAno(2020)
            .construir();

        System.out.println(veiculo);
    }
}
