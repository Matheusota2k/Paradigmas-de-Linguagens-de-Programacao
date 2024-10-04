package main

import (
	"fmt"
)

type Endereco struct {
	Rua    string
	Cidade string
	Estado string
	Cep    string
}

func (e Endereco) MostrarEndereco() {
	fmt.Printf("Rua: %s, Cidade: %s, Estado: %s, CEP: %s\n", e.Rua, e.Cidade, e.Estado, e.Cep)
}

type Pessoa struct {
	Nome     string
	Idade    int
	Endereco *Endereco
}

func (p *Pessoa) AdicionarEndereco(endereco *Endereco) {
	p.Endereco = endereco
}

func (p Pessoa) MostrarInformacoes() {
	if p.Endereco != nil {
		fmt.Println("Endereço:")
		p.Endereco.MostrarEndereco()
	} else {
		fmt.Println("Endereço não disponível")
	}
	fmt.Printf("Nome: %s, Idade: %d\n", p.Nome, p.Idade)
}

type Empresa struct {
	Nome         string
	Cnpj         string
	Funcionarios []*Pessoa
}

func (e *Empresa) ContratarFuncionario(funcionario *Pessoa) {
	e.Funcionarios = append(e.Funcionarios, funcionario)
}

func (e Empresa) ListarFuncionarios() {
	fmt.Printf("Funcionários da empresa %s:\n", e.Nome)
	for _, funcionario := range e.Funcionarios {
		funcionario.MostrarInformacoes()
		fmt.Println()
	}
	fmt.Println("Lista de nomes dos funcionários:")
	for _, funcionario := range e.Funcionarios {
		fmt.Printf("- %s\n", funcionario.Nome)
	}
}

func agregação() {
	endereco1 := &Endereco{"Av. Principal", "Cidade A", "Estado X", "12345-678"}
	pessoa1 := &Pessoa{"João", 25, nil}
	pessoa1.AdicionarEndereco(endereco1)

	endereco2 := &Endereco{"Av. Abecedário", "Cidade B", "Estado Y", "98765-432"}
	pessoa2 := &Pessoa{"Matheus", 20, nil}
	pessoa2.AdicionarEndereco(endereco2)

	empresa := &Empresa{"Empresa ABC", "12.345.678/0001-99", nil}
	empresa.ContratarFuncionario(pessoa1)
	empresa.ContratarFuncionario(pessoa2)

	empresa.ListarFuncionarios()
}
