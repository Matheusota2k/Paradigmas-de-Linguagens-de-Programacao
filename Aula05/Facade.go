package main

import "fmt"

// Cafeteira
type Cafeteira struct{}

func (c *Cafeteira) MoerGraos() {
	fmt.Println("Moendo grãos de café")
}

func (c *Cafeteira) FazerCafe() {
	fmt.Println("Fazendo café")
}

// Chaleira
type Chaleira struct{}

func (ch *Chaleira) FerverAgua() {
	fmt.Println("Fervendo água")
}

func (ch *Chaleira) FazerCha() {
	fmt.Println("Fazendo chá")
}

// BebidasFacade
type BebidasFacade struct {
	cafeteira Cafeteira
	chaleira  Chaleira
}

func NewBebidasFacade() *BebidasFacade {
	return &BebidasFacade{
		cafeteira: Cafeteira{},
		chaleira:  Chaleira{},
	}
}

func (b *BebidasFacade) PrepararCafe() {
	fmt.Println("\nPreparando café...")
	b.cafeteira.MoerGraos()
	b.cafeteira.FazerCafe()
}

func (b *BebidasFacade) PrepararCha() {
	fmt.Println("\nPreparando chá...")
	b.chaleira.FerverAgua()
	b.chaleira.FazerCha()
}

func Facade() {
	facade := NewBebidasFacade()
	facade.PrepararCafe()
	facade.PrepararCha()
}
