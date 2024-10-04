// Classe base Animal
class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
    }
}

interface Ave {
    void voar();
}

class Mamifero extends Animal {

    public Mamifero(String nome) {
        super(nome);
    }

    public void amamentar() {
        System.out.println(this.nome + "está amamentando");
    }
}
class Morcego extends Mamifero implements Ave {

    public Morcego(String nome) {
        super(nome);
    }

    public void emitirSom() {
        System.out.println("Morcego fazendo ruídos noturnos.");
    }

    public void voar() {
        System.out.println(this.nome + "está voando");
    }
}

public class HerançaMultipla {
    public static void main(String[] args) {
        Morcego morcego = new Morcego("Batman");
        morcego.emitirSom();
        morcego.amamentar();
        morcego.voar();
    }
}
