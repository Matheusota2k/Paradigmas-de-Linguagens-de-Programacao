// Questão 4 e 5
package main

import (
	"fmt"
)

type Animal interface {
	Som() string
	Tipo() string
}

type Cachorro struct{}

func (c Cachorro) Som() string {
	return "Au au!"
}

func (c Cachorro) Tipo() string {
	return "Cachorro"
}

type Gato struct{}

func (g Gato) Som() string {
	return "Miau!"
}

func (g Gato) Tipo() string {
	return "Gato"
}

// Vaca representa uma vaca
type Vaca struct{}

func (v Vaca) Som() string {
	return "Muuu!"
}

func (v Vaca) Tipo() string {
	return "Vaca"
}

func FazerBarulho(animais []Animal) {
	for _, animal := range animais {
		fmt.Printf("O %s faz: %s\n", animal.Tipo(), animal.Som())
	}
}

func Main() {
	cachorro := Cachorro{}
	gato := Gato{}
	vaca := Vaca{}

	animais := []Animal{cachorro, gato, vaca}

	FazerBarulho(animais)
}
