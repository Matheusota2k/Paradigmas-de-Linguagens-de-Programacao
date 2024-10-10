class Carro:
    def __init__(self, modelo, cor, ano):
        self.modelo = modelo
        self.cor = cor
        self.ano = ano

    def __str__(self):
        return f"Carro {self.modelo} - Cor: {self.cor} - Ano: {self.ano}"

class CarroBuilder:
    def set_modelo(self, modelo):
        pass

    def set_cor(self, cor):
        pass

    def set_ano(self, ano):
        pass

    def build(self):
        pass

class CarroBuilderImpl(CarroBuilder):
    def __init__(self):
        self.modelo = None
        self.cor = None
        self.ano = None

    def set_modelo(self, modelo):
        self.modelo = modelo
        return self

    def set_cor(self, cor):
        self.cor = cor
        return self

    def set_ano(self, ano):
        self.ano = ano
        return self

    def build(self):
        return Carro(self.modelo, self.cor, self.ano)

class Diretor:
    def __init__(self, builder):
        self.builder = builder

    def construir_carro(self):
        return self.builder.set_modelo("Fiat").set_cor("Azul").set_ano(2020).build()

if __name__ == "__main__":
    builder = CarroBuilderImpl()
    diretor = Diretor(builder)
    carro = diretor.construir_carro()
    print(carro)
