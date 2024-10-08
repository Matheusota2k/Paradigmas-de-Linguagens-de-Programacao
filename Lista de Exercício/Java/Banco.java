// Questões 3 e 15

package ListaDeExercicio.Java;

public class Banco {

    public static void main(String[] args) throws SaldoInsuficienteException {
        ContaBancaria contaMaria = new ContaBancaria("Maria", 1000);

        System.out.println("Titular: " + contaMaria.getTitular());
        System.out.printf("Saldo inicial: R$%.2f%n", contaMaria.getSaldo());

        // Realizando depósito
        if (contaMaria.depositar(500)) {
            System.out.printf("Depósito realizado. Novo saldo: R$%.2f%n", contaMaria.getSaldo());
        } else {
            System.out.println("Falha no depósito.");
        }

        // Realizando saque
        if (contaMaria.sacar(200)) {
            System.out.printf("Saque realizado. Novo saldo: R$%.2f%n", contaMaria.getSaldo());
        } else {
            System.out.println("Falha no saque.");
        }

        // Tentando sacar um valor maior que o saldo
        try {
            if (contaMaria.sacar(2000)) {
                System.out.printf("Saque realizado. Novo saldo: R$%.2f%n", contaMaria.getSaldo());
            }
        } catch (SaldoInsuficienteException e) {
            System.out.println("Falha no saque: " + e.getMessage());
        }

        // Tentando modificar o saldo diretamente
        try {
            contaMaria.setSaldo(5000);
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao tentar modificar o saldo: " + e.getMessage());
        }
    }
}

class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        throw new UnsupportedOperationException("Não é possível modificar o saldo diretamente. Use os métodos depositar() ou sacar().");
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) throws SaldoInsuficienteException {
        if (valor > 0) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                return true;
            } else {
                throw new SaldoInsuficienteException(this.saldo, valor);
            }
        }
        return false;
    }
}

class SaldoInsuficienteException extends Exception {
    private double saldoAtual;
    private double valorSaque;

    public SaldoInsuficienteException(double saldoAtual, double valorSaque) {
        super(String.format("Saldo insuficiente. Saldo atual: R$%.2f, Valor do saque: R$%.2f", saldoAtual, valorSaque));
        this.saldoAtual = saldoAtual;
        this.valorSaque = valorSaque;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getValorSaque() {
        return valorSaque;
    }
}
