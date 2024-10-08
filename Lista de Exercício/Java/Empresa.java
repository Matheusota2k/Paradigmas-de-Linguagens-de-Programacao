// Questões 8 e 9

package ListaDeExercicio.Java;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    static class Empregado {
        private String nome;
        private String cargo;
        private double salario;

        public Empregado(String nome, String cargo, double salario) {
            this.nome = nome;
            this.cargo = cargo;
            this.salario = salario;
        }

        @Override
        public String toString() {
            return nome + " - " + cargo + " (Salário: R$" + String.format("%.2f", salario) + ")";
        }
    }

    interface Imprimivel {
        void imprimir();
    }

    static class Relatorio implements Imprimivel {
        private String titulo;

        public Relatorio(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public void imprimir() {
            System.out.println("Imprimindo relatório: " + titulo);
            System.out.println("Conteúdo do relatório...");
        }
    }

    static class Contrato implements Imprimivel {
        private String numero;

        public Contrato(String numero) {
            this.numero = numero;
        }

        @Override
        public void imprimir() {
            System.out.println("Imprimindo contrato número: " + numero);
            System.out.println("Termos e condições do contrato...");
        }
    }

    private String nome;
    private List<Empregado> empregados;

    public Empresa(String nome) {
        this.nome = nome;
        this.empregados = new ArrayList<>();
    }

    public void adicionarEmpregado(Empregado empregado) {
        empregados.add(empregado);
    }

    public void listarEmpregados() {
        System.out.println("Empregados da " + nome + ":");
        for (Empregado empregado : empregados) {
            System.out.println(empregado);
        }
    }

    public static void imprimirDocumento(Imprimivel doc) {
        doc.imprimir();
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Minha Empresa Ltda.");

        Empregado emp1 = new Empregado("João Silva", "Desenvolvedor", 5000);
        Empregado emp2 = new Empregado("Maria Santos", "Gerente de Projetos", 7000);
        Empregado emp3 = new Empregado("Carlos Oliveira", "Analista de Dados", 4500);

        empresa.adicionarEmpregado(emp1);
        empresa.adicionarEmpregado(emp2);
        empresa.adicionarEmpregado(emp3);

        empresa.listarEmpregados();

        System.out.println("\nTestando a interface Imprimivel:");
        Relatorio relatorio = new Relatorio("Relatório Anual");
        Contrato contrato = new Contrato("C-12345");

        imprimirDocumento(relatorio);
        System.out.println();
        imprimirDocumento(contrato);
    }
}
