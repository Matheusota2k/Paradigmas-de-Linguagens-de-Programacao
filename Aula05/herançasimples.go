package main

import (
	"fmt"
)

type Animal struct {
	especie string
	nome    string
}

func (a *Animal) EmitirSom() string {
	return ""
}

type Cachorro struct {
	Animal
}

func (c *Cachorro) EmitirSom() string {
	return "Au Au"
}

type Gato struct {
	Animal
}

func (g *Gato) EmitirSom() string {
	return "Miau"
}

func Main() {
	cachorro := Cachorro{Animal{"Canino", "Rex"}}
	gato := Gato{Animal{"Felino", "Mingau"}}

	fmt.Printf("O cachorro %s da especie %s faz o som: %s\n", cachorro.nome, cachorro.especie, cachorro.EmitirSom())
	fmt.Printf("O gato %s da especie %s faz o som: %s\n", gato.nome, gato.especie, gato.EmitirSom())
}
