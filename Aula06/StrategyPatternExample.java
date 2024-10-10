//1. Definir a interface `CarManufacturingStrategy`, que descreve o método `manufacture` para diferentes tipos de fabricação de carros.
//2. Implementar a classe `ElectricCarManufacturingStrategy`, que implementa a estratégia de fabricação de carros elétricos.
//3. Implementar a classe `GasolineCarManufacturingStrategy`, que implementa a estratégia de fabricação de carros a gasolina.
//4. Criar a classe `CarFactory`, que usa uma estratégia de fabricação de carros e pode trocar a estratégia em tempo de execução.
//5. Demonstrar o uso das estratégias no método `main`, onde a fábrica inicialmente usa a estratégia de fabricação de carros elétricos e, posteriormente, troca para a estratégia de fabricação de carros a gasolina.


interface ManufacturingStrategy {
    void execute();
}

class ElectricVehicleStrategy implements ManufacturingStrategy {
    @Override
    public void execute() {
        System.out.println("Produzindo um veículo elétrico...");
    }
}

class GasolineVehicleStrategy implements ManufacturingStrategy {
    @Override
    public void execute() {
        System.out.println("Produzindo um veículo a gasolina...");
    }
}

class VehicleFactory {
    private ManufacturingStrategy manufacturingStrategy;

    public VehicleFactory(ManufacturingStrategy manufacturingStrategy) {
        this.manufacturingStrategy = manufacturingStrategy;
    }

    public void alterarEstrategia(ManufacturingStrategy novaEstrategia) {
        this.manufacturingStrategy = novaEstrategia;
    }

    public void fabricarVeiculo() {
        manufacturingStrategy.execute();
    }
}

// Exemplo de uso
public class StrategyPatternExample {
    public static void main(String[] args) {
        ManufacturingStrategy estrategiaEletrica = new ElectricVehicleStrategy();
        ManufacturingStrategy estrategiaGasolina = new GasolineVehicleStrategy();
        VehicleFactory fabrica = new VehicleFactory(estrategiaEletrica);
        fabrica.fabricarVeiculo();
        fabrica.alterarEstrategia(estrategiaGasolina);
        fabrica.fabricarVeiculo();
    }
}
