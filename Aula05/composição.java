import java.util.ArrayList;

class Motor {
    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public void ligar() {
        System.out.println("O motor está ligado");
    }

    public void desligar() {
        System.out.println("O carro está desligado");
    }
}

class Pneu {
    private String marca;
    private int tamanho;

    public Pneu(String marca, int tamanho) {
        this.marca = marca;
        this.tamanho = tamanho;
    }

    public void inflar() {
        System.out.println("O pneu está inflado");
    }

    public void desinflar() {
        System.out.println("O pneu está desinflado");
    }
}

class Carro {
    private String marca;
    private String modelo;
    private Motor motor;
    private ArrayList<Pneu> pneus;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = new Motor("Gasolina", 150);
        this.pneus = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pneus.add(new Pneu("Pirelli", 18));
        }
    }

    public void ligar() {
        motor.ligar();
        System.out.println("O carro está pronto para rodar");
    }

    public void desligar() {
        motor.desligar();
        System.out.println("O carro foi desligado");
    }

    public void trocarPneu(int indice, Pneu novoPneu) {
        pneus.set(indice, novoPneu);
        System.out.println("Pneu " + (indice + 1) + " trocado");
    }
}

public class composição {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla");
        carro.ligar();

        Pneu novoPneu = new Pneu("Michelin", 1);
        carro.trocarPneu(2, novoPneu);
        carro.desligar();
    }
}
