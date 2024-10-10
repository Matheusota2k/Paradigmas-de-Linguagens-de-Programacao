class CarManufacturingStrategy:
    def manufacture(self):
        pass


class ElectricCarManufacturingStrategy(CarManufacturingStrategy):
    def manufacture(self):
        print("Fabricando um carro elétrico...")

class GasolineCarManufacturingStrategy(CarManufacturingStrategy):
    def manufacture(self):
        print("Fabricando um carro a gasolina...")

class CarFactory:
    def __init__(self, strategy):
        self.strategy = strategy

    def set_strategy(self, strategy):
        self.strategy = strategy

    def produce_car(self):
        self.strategy.manufacture()


# Exemplo de uso
if __name__ == "__main__":
    electric_strategy = ElectricCarManufacturingStrategy()
    gasoline_strategy = GasolineCarManufacturingStrategy()

    factory = CarFactory(electric_strategy)
    factory.produce_car()
    factory.set_strategy(gasoline_strategy)
    factory.produce_car()
