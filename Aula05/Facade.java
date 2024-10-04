class Cafeteira {
    public void moerGraos() {
        System.out.println("Moendo grãos de café");
    }

    public void fazerCafe() {
        System.out.println("Fazendo café");
    }
}

class Chaleira {
    public void ferverAgua() {
        System.out.println("Fervendo água");
    }

    public void fazerCha() {
        System.out.println("Fazendo chá");
    }
}

class BebidasFacade {
    private Cafeteira cafeteira;
    private Chaleira chaleira;

    public BebidasFacade() {
        this.cafeteira = new Cafeteira();
        this.chaleira = new Chaleira();
    }

    public void prepararCafe() {
        System.out.println("\nPreparando café...");
        cafeteira.moerGraos();
        cafeteira.fazerCafe();
    }

    public void prepararCha() {
        System.out.println("\nPreparando chá...");
        chaleira.ferverAgua();
        chaleira.fazerCha();
    }
}

public class Facade {
    public static void main(String[] args) {
        BebidasFacade facade = new BebidasFacade();
        facade.prepararCafe();
        facade.prepararCha();
    }
}
