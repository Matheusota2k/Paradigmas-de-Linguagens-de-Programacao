import java.util.ArrayList;

class Pessoa {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = null;  // Endereço começa como null
    }

    public void adicionarEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void mostrarInformacoes() {
        if (this.endereco != null) {
            System.out.println("Endereço:");
            this.endereco.mostrarEndereco();
        } else {
            System.out.println("Endereço não disponível");
        }
        System.out.println("Nome: " + this.nome + ", Idade: " + this.idade);
    }

    public String getNome() {
        return this.nome;
    }
}

class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void mostrarEndereco() {
        System.out.println("Rua: " + this.rua + ", Cidade: " + this.cidade + ", Estado: " + this.estado + ", CEP: " + this.cep);
    }
}

class Empresa {
    private String nome;
    private String cnpj;
    private ArrayList<Pessoa> funcionarios;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();  
    }

    public void contratarFuncionario(Pessoa funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        System.out.println("Funcionários da empresa " + this.nome + ":");

        for (Pessoa funcionario : this.funcionarios) {
            funcionario.mostrarInformacoes();
            System.out.println(); 
        }

        System.out.println("Lista de nomes dos funcionários:");
        for (Pessoa funcionario : this.funcionarios) {
            System.out.println("- " + funcionario.getNome());
        }
    }
}

public class agregação {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Av. Principal", "Cidade A", "Estado X", "12345-678");
        Pessoa pessoa1 = new Pessoa("João", 25);
        pessoa1.adicionarEndereco(endereco1);

        Endereco endereco2 = new Endereco("Av. Abecedário", "Cidade B", "Estado Y", "98765-432");
        Pessoa pessoa2 = new Pessoa("Matheus", 20);
        pessoa2.adicionarEndereco(endereco2);

        Empresa empresa = new Empresa("Empresa ABC", "12.345.678/0001-99");
        empresa.contratarFuncionario(pessoa1);
        empresa.contratarFuncionario(pessoa2);

        empresa.listarFuncionarios();
    }
}
