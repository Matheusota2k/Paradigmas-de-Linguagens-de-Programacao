// Questão 10, 11, 12 e 13

package main

import (
	"fmt"
)

type Calculadora struct{}

func (c *Calculadora) SomarDois(a, b int) int {
	return a + b
}

func (c *Calculadora) SomarTres(a, b, c int) int {
	return a + b + c
}

type Funcionario interface {
	CalcularSalario() float64
	Nome() string
}

type FuncionarioHorista struct {
	nome             string
	horasTrabalhadas float64
	valorHora        float64
}

func (f *FuncionarioHorista) CalcularSalario() float64 {
	return f.horasTrabalhadas * f.valorHora
}

func (f *FuncionarioHorista) Nome() string {
	return f.nome
}

type FuncionarioAssalariado struct {
	nome          string
	salarioMensal float64
}

func (f *FuncionarioAssalariado) CalcularSalario() float64 {
	return f.salarioMensal
}

func (f *FuncionarioAssalariado) Nome() string {
	return f.nome
}

type Produto struct {
	Nome  string
	Preco float64
}

func SomarProdutos(p1, p2 Produto) Produto {
	return Produto{
		Nome:  fmt.Sprintf("%s + %s", p1.Nome, p2.Nome),
		Preco: p1.Preco + p2.Preco,
	}
}

type Matematica struct{}

func (m *Matematica) Fatorial(n int) (int, error) {
	if n < 0 {
		return 0, fmt.Errorf("o fatorial não está definido para números negativos")
	}
	if n == 0 || n == 1 {
		return 1, nil
	}
	result, err := m.Fatorial(n - 1)
	if err != nil {
		return 0, err
	}
	return n * result, nil
}

func main() {
	calc := &Calculadora{}
	fmt.Println(calc.SomarDois(5, 3))
	fmt.Println(calc.SomarTres(5, 3, 2))

	horista := &FuncionarioHorista{nome: "João", horasTrabalhadas: 160, valorHora: 20}
	assalariado := &FuncionarioAssalariado{nome: "Maria", salarioMensal: 3000}

	fmt.Printf("Salário de %s: R$%.2f\n", horista.Nome(), horista.CalcularSalario())
	fmt.Printf("Salário de %s: R$%.2f\n", assalariado.Nome(), assalariado.CalcularSalario())

	produto1 := Produto{Nome: "Camiseta", Preco: 50.0}
	produto2 := Produto{Nome: "Calça", Preco: 100.0}
	produtoSoma := SomarProdutos(produto1, produto2)

	fmt.Printf("Produto 1: %s: R$%.2f\n", produto1.Nome, produto1.Preco)
	fmt.Printf("Produto 2: %s: R$%.2f\n", produto2.Nome, produto2.Preco)
	fmt.Printf("Soma dos produtos: %s: R$%.2f\n", produtoSoma.Nome, produtoSoma.Preco)

	mat := &Matematica{}
	fatorial, err := mat.Fatorial(5)
	if err == nil {
		fmt.Printf("Fatorial de 5: %d\n", fatorial)
	} else {
		fmt.Printf("Erro ao calcular fatorial: %s\n", err)
	}

	fatorial, err = mat.Fatorial(0)
	if err == nil {
		fmt.Printf("Fatorial de 0: %d\n", fatorial)
	} else {
		fmt.Printf("Erro ao calcular fatorial: %s\n", err)
	}
}
