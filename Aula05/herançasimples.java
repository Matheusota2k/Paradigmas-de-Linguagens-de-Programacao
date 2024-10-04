abstract class Animal {
    protected String especie;
    protected String nome;

    public Animal(String especie, String nome) {
        this.especie = especie;
        this.nome = nome;
    }

    public abstract String emitirSom();
}

class Cachorro extends Animal {
    public Cachorro(String especie, String nome) {
        super(especie, nome);
    }

    public String emitirSom() {
        return "Au Au";
    }
}

class Gato extends Animal {
    public Gato(String especie, String nome) {
        super(especie, nome);
    }

    public String emitirSom() {
        return "Miau";
    }
}

public class herançasimples {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Canino", "Rex");
        Gato gato = new Gato("Felino", "Mingau");

        System.out.println("O cachorro " + cachorro.nome + " da especie " + cachorro.especie + " faz o som: " + cachorro.emitirSom());
        System.out.println("O gato " + gato.nome + " da especie " + gato.especie + " faz o som: " + gato.emitirSom());
    }
}
