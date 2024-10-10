//1. Criação da interface `PaymentProcessor`, que define o método `process` para realizar um pagamento.
//2. Implementação da classe `StripeProcessor`, que processa pagamentos via Stripe.
//3. Implementação da classe `PayPalService`, que utiliza um método próprio (`realizarPagamento`) para processar pagamentos via PayPal.
//4. Implementação da classe `PayPalAdapter`, que adapta o método de pagamento do PayPal para a interface `PaymentProcessor`.
//5. A classe principal (`SistemaPagamento`) demonstrará o uso de pagamentos via Stripe diretamente e via PayPal, utilizando o Adapter.

interface PaymentProcessor {
    void process(int amount);
}

class StripeProcessor implements PaymentProcessor {
    public void process(int amount) {
        System.out.println("Processando pagamento de $" + amount + " via Stripe.");
    }
}

class PayPalService {
    public void realizarPagamento(int amount) {
        System.out.println("Processando pagamento de $" + amount + " via PayPal.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    public void process(int amount) {
        payPalService.realizarPagamento(amount);
    }
}

public class SistemaPagamento {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeProcessor();
        PayPalService payPal = new PayPalService();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);

        realizarPagamento(stripe, 150);  
        realizarPagamento(payPalAdapter, 300);  
    }

    public static void realizarPagamento(PaymentProcessor sistemaPagamento, int valor) {
        sistemaPagamento.process(valor);
    }
}
