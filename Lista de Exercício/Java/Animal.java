package ListaDeExercicio.Java;

public class Animal {

    public static void main(String[] args) {
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        Animal[] animais = {cachorro, gato, vaca};

        fazerBarulho(animais);
    }

    // Método que faz os animais fazerem barulho
    public static void fazerBarulho(Animal[] animais) {
        for (Animal animal : animais) {
            System.out.println("O " + animal.getTipo() + " faz: " + animal.som());
        }
    }

    public String som() {
        return "";
    }

    // Retorna o tipo do animal baseado no nome da classe
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}

class Cachorro extends Animal {
    public String som() {
        return "Au au!";
    }
}

class Gato extends Animal {
    public String som() {
        return "Miau!";
    }
}

class Vaca extends Animal {
    public String som() {
        return "Muuu!";
    }
}
