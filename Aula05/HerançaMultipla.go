package main

import "fmt"

type animal struct {
	nome string
}

func (a animal) EmitirSom() {

}

type Mamifero struct {
	animal
}

func (m Mamifero) Amamentar() {
	fmt.Printf("%s está amamentando", m.nome)
}

type Ave struct {
	animal
}

func (a Ave) Voar() {
	fmt.Printf("%s está voando", a.nome)
}

type Morcego struct {
	Mamifero
	Ave
}

func (m Morcego) EmitirSom() {
	fmt.Println("Morcego fazendo ruídos noturnos.")
}

func main() {
	morcego := Morcego{
		Mamifero: Mamifero{animal{"Batemane"}},
		Ave:      Ave{animal{"Batemane"}},
	}

	morcego.EmitirSom()
	morcego.Amamentar()
	morcego.Voar()
}
