// Questão 7

package main

import (
	"fmt"
)

type Escola struct {
	Nome        string
	Professores []*Professor
}

func (e *Escola) AdicionarProfessor(professor *Professor) {
	for _, p := range e.Professores {
		if p == professor {
			return
		}
	}
	e.Professores = append(e.Professores, professor)
	professor.AdicionarEscola(e)
}

func (e *Escola) RemoverProfessor(professor *Professor) {
	for i, p := range e.Professores {
		if p == professor {
			e.Professores = append(e.Professores[:i], e.Professores[i+1:]...)
			professor.RemoverEscola(e)
			return
		}
	}
}

func (e *Escola) ListarProfessores() []string {
	nomes := make([]string, len(e.Professores))
	for i, p := range e.Professores {
		nomes[i] = p.Nome
	}
	return nomes
}

type Professor struct {
	Nome    string
	Escolas []*Escola
}

func (p *Professor) AdicionarEscola(escola *Escola) {
	for _, e := range p.Escolas {
		if e == escola {
			return
		}
	}
	p.Escolas = append(p.Escolas, escola)
}

func (p *Professor) RemoverEscola(escola *Escola) {
	for i, e := range p.Escolas {
		if e == escola {
			p.Escolas = append(p.Escolas[:i], p.Escolas[i+1:]...)
			return
		}
	}
}

func (p *Professor) ListarEscolas() []string {
	nomes := make([]string, len(p.Escolas))
	for i, e := range p.Escolas {
		nomes[i] = e.Nome
	}
	return nomes
}

func main() {
	escola1 := &Escola{Nome: "Escola A"}
	escola2 := &Escola{Nome: "Escola B"}

	prof1 := &Professor{Nome: "João"}
	prof2 := &Professor{Nome: "Maria"}

	escola1.AdicionarProfessor(prof1)
	escola1.AdicionarProfessor(prof2)
	escola2.AdicionarProfessor(prof1)

	fmt.Printf("Professores da %s: %v\n", escola1.Nome, escola1.ListarProfessores())
	fmt.Printf("Professores da %s: %v\n", escola2.Nome, escola2.ListarProfessores())
	fmt.Printf("Escolas onde %s leciona: %v\n", prof1.Nome, prof1.ListarEscolas())
	fmt.Printf("Escolas onde %s leciona: %v\n", prof2.Nome, prof2.ListarEscolas())
}
