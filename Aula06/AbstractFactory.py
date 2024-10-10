class Carro:
    def exibir_info(self):
        raise NotImplementedError


class Sedan(Carro):
    pass


class SUV(Carro):
    pass


class FabricaCarro:
    def produzir(self, tipo):
        if tipo == "sedan":
            return self.produz_sedan()
        elif tipo == "suv":
            return self.produz_suv()
        else:
            raise ValueError("Tipo de carro desconhecido")


class FabricaToyota(FabricaCarro):
    def produz_sedan(self):
        return SedanToyota()

    def produz_suv(self):
        return SUVToyota()


class FabricaFord(FabricaCarro):
    def produz_sedan(self):
        return SedanFord()

    def produz_suv(self):
        return SUVFord()


class SedanToyota(Sedan):
    def exibir_info(self):
        print("Toyota Corolla - Sedan")


class SUVToyota(SUV):
    def exibir_info(self):
        print("Toyota RAV4 - SUV")


class SedanFord(Sedan):
    def exibir_info(self):
        print("Ford Fusion - Sedan")


class SUVFord(SUV):
    def exibir_info(self):
        print("Ford Explorer - SUV")


def produzir_carros(fabrica):
    for tipo in ["sedan", "suv"]:
        carro = fabrica.produzir(tipo)
        carro.exibir_info()


if __name__ == "__main__":
    print("Produzindo carros Toyota:")
    fabrica_toyota = FabricaToyota()
    produzir_carros(fabrica_toyota)

    print("\nProduzindo carros Ford:")
    fabrica_ford = FabricaFord()
    produzir_carros(fabrica_ford)
