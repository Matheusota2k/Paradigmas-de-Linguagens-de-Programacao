package main

import "fmt"

type EstrategiaFabricaCarros interface {
	Fabricar()
}

type EstrategiaCarroEletrico struct{}

func (e *EstrategiaCarroEletrico) Fabricar() {
	fmt.Println("Fabricando um carro elétrico...")
}

type EstrategiaCarroGasolina struct{}

func (g *EstrategiaCarroGasolina) Fabricar() {
	fmt.Println("Fabricando um carro a gasolina...")
}

type FabricaCarros struct {
	estrategia EstrategiaFabricaCarros
}

func NovaFabricaCarros(estrategia EstrategiaFabricaCarros) *FabricaCarros {
	return &FabricaCarros{estrategia: estrategia}
}

func (f *FabricaCarros) DefinirEstrategia(estrategia EstrategiaFabricaCarros) {
	f.estrategia = estrategia
}

func (f *FabricaCarros) ProduzirCarro() {
	f.estrategia.Fabricar()
}

func main() {
	estrategiaEletrica := &EstrategiaCarroEletrico{}
	estrategiaGasolina := &EstrategiaCarroGasolina{}

	fabrica := NovaFabricaCarros(estrategiaEletrica)

	fabrica.ProduzirCarro()

	fabrica.DefinirEstrategia(estrategiaGasolina)

	fabrica.ProduzirCarro()
}
