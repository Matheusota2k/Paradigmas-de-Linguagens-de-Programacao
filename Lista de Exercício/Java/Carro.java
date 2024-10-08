// Questões 1, 2 e 6

package ListaDeExercicio.Java;

public class Carro {

    private String marca;
    private String modelo;
    private int ano;
    private int velocidade;
    private Motor motor;

    public Carro(String marca, String modelo, int ano, String tipoMotor, int potenciaMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0;
        this.motor = new Motor(tipoMotor, potenciaMotor);
    }

    public String getMarca() {
        return marca;
    }

    public void mostrarMotor() {
        System.out.println("Motor do " + modelo + ": " + motor.toString());
    }

    public void mostrarBateria(int capacidadeBateria) {
        System.out.println("Bateria do " + modelo + ": " + capacidadeBateria + " kWh");
    }

    public void mostrarPneus(String tipoPneu) {
        System.out.println("Pneus do " + modelo + ": " + tipoPneu);
    }

    public void sobre() {
        System.out.println("Carro: " + marca + " " + modelo + " (" + ano + ")");
        System.out.println("Motor: " + motor.toString());
    }

    public void acelerar(int incremento) {
        velocidade += incremento;
        System.out.println(modelo + " acelerou para " + velocidade + " km/h");
    }

    public void frear(int decremento) {
        velocidade = Math.max(0, velocidade - decremento);
        System.out.println(modelo + " freou para " + velocidade + " km/h");
    }

    public void exibirVelocidade() {
        System.out.println("Velocidade do " + modelo + ": " + velocidade + " km/h");
    }

    public static void imprimirSeparador() {
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // Criando objetos Carro
        Carro carro1 = new Carro("Toyota", "Corolla", 2020, "V6", 200);
        Carro carro2 = new Carro("Honda", "Civic", 2018, "V4", 180);
        Carro carro3 = new Carro("Ford", "Mustang", 2022, "V8", 450);

        Carro[] carros = {carro1, carro2, carro3};

        for (Carro carro : carros) {
            imprimirSeparador();
            carro.sobre();
            int capacidadeBateria = carro.getMarca().equals("Toyota") ? 12 : carro.getMarca().equals("Honda") ? 14 : 15;
            carro.mostrarBateria(capacidadeBateria);
            String tipoPneu = carro.getMarca().equals("Toyota") ? "Radiais" : carro.getMarca().equals("Honda") ? "Esportivos" : "Off-road";
            carro.mostrarPneus(tipoPneu);
        }

        imprimirSeparador();
        System.out.println("\nTeste de aceleração e frenagem (Toyota Corolla):");
        imprimirSeparador();

        carro1.acelerar(50);
        carro1.exibirVelocidade();
        carro1.acelerar(30);
        carro1.exibirVelocidade();
        carro1.frear(20);
        carro1.exibirVelocidade();
        carro1.frear(100);
        carro1.exibirVelocidade();

        imprimirSeparador();
    }
}

class Motor {
    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return tipo + " - " + potencia + " cv";
    }
}
