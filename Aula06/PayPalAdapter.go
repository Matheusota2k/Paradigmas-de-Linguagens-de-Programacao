package main

import "fmt"

type ProcessadorPagamento interface {
	Processar(valor float64)
}

type Stripe struct{}

func (s *Stripe) Processar(valor float64) {
	fmt.Printf("Pagamento de R$ %.2f processado via Stripe.\n", valor)
}

type Paypal struct{}

func (p *Paypal) EnviarPagamento(valor float64) {
	fmt.Printf("Pagamento de R$ %.2f processado via PayPal.\n", valor)
}

type AdaptadorPaypal struct {
	paypal *Paypal
}

func (a *AdaptadorPaypal) Processar(valor float64) {
	a.paypal.EnviarPagamento(valor)
}

func processarPagamento(processador ProcessadorPagamento, valor float64) {
	processador.Processar(valor)
}

func main() {
	stripe := &Stripe{}
	paypal := &Paypal{}
	adaptadorPaypal := &AdaptadorPaypal{paypal}

	processarPagamento(stripe, 100)
	processarPagamento(adaptadorPaypal, 200)
}
