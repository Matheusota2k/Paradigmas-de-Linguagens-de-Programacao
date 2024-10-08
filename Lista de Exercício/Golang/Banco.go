// Questão 3 e 15

package main

import (
	"errors"
	"fmt"
)

type ContaBancaria struct {
	titular string
	saldo   float64
}

func NovoContaBancaria(titular string, saldoInicial float64) *ContaBancaria {
	return &ContaBancaria{
		titular: titular,
		saldo:   saldoInicial,
	}
}

func (c *ContaBancaria) Titular() string {
	return c.titular
}

func (c *ContaBancaria) Saldo() float64 {
	return c.saldo
}

func (c *ContaBancaria) Depositar(valor float64) bool {
	if valor > 0 {
		c.saldo += valor
		return true
	}
	return false
}

func (c *ContaBancaria) Sacar(valor float64) error {
	if valor > 0 {
		if c.saldo >= valor {
			c.saldo -= valor
			return nil
		}
		return fmt.Errorf("saldo insuficiente. Saldo atual: R$%.2f, Valor do saque: R$%.2f", c.saldo, valor)
	}
	return errors.New("valor de saque inválido")
}

func main() {
	contaMaria := NovoContaBancaria("Maria", 1000)

	fmt.Printf("Titular: %s\n", contaMaria.Titular())
	fmt.Printf("Saldo inicial: R$%.2f\n", contaMaria.Saldo())

	if contaMaria.Depositar(500) {
		fmt.Printf("Depósito realizado. Novo saldo: R$%.2f\n", contaMaria.Saldo())
	} else {
		fmt.Println("Falha no depósito.")
	}

	err := contaMaria.Sacar(200)
	if err == nil {
		fmt.Printf("Saque realizado. Novo saldo: R$%.2f\n", contaMaria.Saldo())
	} else {
		fmt.Printf("Falha no saque: %s\n", err)
	}

	err = contaMaria.Sacar(2000)
	if err == nil {
		fmt.Printf("Saque realizado. Novo saldo: R$%.2f\n", contaMaria.Saldo())
	} else {
		fmt.Printf("Falha no saque: %s\n", err)
	}
}
