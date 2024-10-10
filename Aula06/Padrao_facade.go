package main

import "fmt"

type Cafeteira struct{}

func (c Cafeteira) MoerGraos() {
	fmt.Println("Moendo grãos de cafe")
}

func (c Cafeteira) FazerCafe() {
	fmt.Println("Fazendo cafe")
}

type Chaleira struct{}

func (c Chaleira) FerverAgua() {
	fmt.Println("Fervendo agua")
}

func (c Chaleira) FazerCha() {
	fmt.Println("Fazendo cha")
}

type BebidasFacade struct {
	cafeteira Cafeteira
	chaleira  Chaleira
}

func NewBebidasFacade() BebidasFacade {
	return BebidasFacade{
		cafeteira: Cafeteira{},
		chaleira:  Chaleira{},
	}
}

func (b BebidasFacade) PrepararCafe() {
	fmt.Println("\nPreparando cafe...")
	b.cafeteira.MoerGraos()
	b.cafeteira.FazerCafe()
}

func (b BebidasFacade) PrepararCha() {
	fmt.Println("\nPreparando cha...")
	b.chaleira.FerverAgua()
	b.chaleira.FazerCha()
}

func main() {
	facade := NewBebidasFacade()
	facade.PrepararCafe()
	facade.PrepararCha()
}
