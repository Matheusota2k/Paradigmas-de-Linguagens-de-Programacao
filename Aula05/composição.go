package main

import "fmt"

type Motor struct {
	tipo     string
	potencia int
}

func (m Motor) Ligar() {
	fmt.Println("O motor está ligado")
}

func (m Motor) Desligar() {
	fmt.Println("O carro está desligado")
}

type Pneu struct {
	marca   string
	tamanho int
}

func (p Pneu) Inflar() {
	fmt.Println("O pneu está inflado")
}

func (p Pneu) Desinflar() {
	fmt.Println("O pneu está desinflado")
}

type Carro struct {
	marca  string
	modelo string
	motor  Motor
	pneus  []Pneu
}

func NovoCarro(marca string, modelo string) Carro {
	motor := Motor{tipo: "Gasolina", potencia: 150}
	pneus := make([]Pneu, 4)
	for i := 0; i < 4; i++ {
		pneus[i] = Pneu{marca: "Pirelli", tamanho: 18}
	}
	return Carro{marca: marca, modelo: modelo, motor: motor, pneus: pneus}
}

func (c Carro) Ligar() {
	c.motor.Ligar()
	fmt.Println("O carro está pronto para rodar")
}

func (c Carro) Desligar() {
	c.motor.Desligar()
	fmt.Println("O carro foi desligado")
}

func (c *Carro) TrocarPneu(indice int, novoPneu Pneu) {
	c.pneus[indice] = novoPneu
	fmt.Printf("Pneu %d trocado\n", indice+1)
}

func composição() {
	carro := NovoCarro("Toyota", "Corolla")
	carro.Ligar()

	novoPneu := Pneu{marca: "Michelin", tamanho: 1}
	carro.TrocarPneu(2, novoPneu)
	carro.Desligar()
}
