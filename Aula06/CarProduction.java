// Interface Abstract Factory
// Implementação da fábrica para Carros Toyota
// Implementação da fábrica para Carros Ford
// Interface para os produtos
// Implementações de produtos específicos para Toyota
// Implementações de produtos específicos para Ford

interface CarFactory {
    Sedan buildSedan();
    SUV buildSUV();
}

class ToyotaCarFactory implements CarFactory {
    public Sedan buildSedan() {
        return new CorollaSedan();
    }

    public SUV buildSUV() {
        return new Rav4SUV();
    }
}

class FordCarFactory implements CarFactory {
    public Sedan buildSedan() {
        return new FusionSedan();
    }

    public SUV buildSUV() {
        return new ExplorerSUV();
    }
}

interface Sedan {
    void showDetails();
}

interface SUV {
    void showDetails();
}

class CorollaSedan implements Sedan {
    public void showDetails() {
        System.out.println("Toyota Corolla - Sedan");
    }
}

class Rav4SUV implements SUV {
    public void showDetails() {
        System.out.println("Toyota RAV4 - SUV");
    }
}

class FusionSedan implements Sedan {
    public void showDetails() {
        System.out.println("Ford Fusion - Sedan");
    }
}

class ExplorerSUV implements SUV {
    public void showDetails() {
        System.out.println("Ford Explorer - SUV");
    }
}

public class CarProduction {
    public static void generateCars(CarFactory factory) {
        Sedan sedan = factory.buildSedan();
        SUV suv = factory.buildSUV();

        sedan.showDetails();
        suv.showDetails();
    }

    public static void main(String[] args) {
        System.out.println("Produzindo carros Toyota:");
        generateCars(new ToyotaCarFactory());

        System.out.println("\nProduzindo carros Ford:");
        generateCars(new FordCarFactory());
    }
}
