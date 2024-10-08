// Questão 8 e 9

package main

import (
	"fmt"
)

type Empregado struct {
	Nome    string
	Cargo   string
	Salario float64
}

func (e *Empregado) String() string {
	return fmt.Sprintf("%s - %s (Salário: R$%.2f)", e.Nome, e.Cargo, e.Salario)
}

type Empresa struct {
	Nome       string
	Empregados []*Empregado
}

func (e *Empresa) AdicionarEmpregado(empregado *Empregado) {
	e.Empregados = append(e.Empregados, empregado)
}

func (e *Empresa) ListarEmpregados() {
	fmt.Printf("Empregados da %s:\n", e.Nome)
	for _, empregado := range e.Empregados {
		fmt.Println(empregado)
	}
}

type Imprimivel interface {
	Imprimir()
}

type Relatorio struct {
	Titulo string
}

func (r *Relatorio) Imprimir() {
	fmt.Printf("Imprimindo relatório: %s\n", r.Titulo)
	fmt.Println("Conteúdo do relatório...")
}

type Contrato struct {
	Numero string
}

func (c *Contrato) Imprimir() {
	fmt.Printf("Imprimindo contrato número: %s\n", c.Numero)
	fmt.Println("Termos e condições do contrato...")
}

func ImprimirDocumento(doc Imprimivel) {
	doc.Imprimir()
}

func main() {
	empresa := &Empresa{Nome: "Minha Empresa Ltda."}

	emp1 := &Empregado{Nome: "João Silva", Cargo: "Desenvolvedor", Salario: 5000}
	emp2 := &Empregado{Nome: "Maria Santos", Cargo: "Gerente de Projetos", Salario: 7000}
	emp3 := &Empregado{Nome: "Carlos Oliveira", Cargo: "Analista de Dados", Salario: 4500}

	empresa.AdicionarEmpregado(emp1)
	empresa.AdicionarEmpregado(emp2)
	empresa.AdicionarEmpregado(emp3)

	empresa.ListarEmpregados()

	fmt.Println("\nTestando a interface Imprimivel:")
	relatorio := &Relatorio{Titulo: "Relatório Anual"}
	contrato := &Contrato{Numero: "C-12345"}

	ImprimirDocumento(relatorio)
	fmt.Println()
	ImprimirDocumento(contrato)
}
