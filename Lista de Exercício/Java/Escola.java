// Questão 7

package ListaDeExercicio.Java;

import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Professor> professores;

    public Escola(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
            professor.adicionarEscola(this);
        }
    }

    public void removerProfessor(Professor professor) {
        if (professores.contains(professor)) {
            professores.remove(professor);
            professor.removerEscola(this);
        }
    }

    public List<String> listarProfessores() {
        List<String> nomes = new ArrayList<>();
        for (Professor professor : professores) {
            nomes.add(professor.getNome());
        }
        return nomes;
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        Escola escola1 = new Escola("Escola A");
        Escola escola2 = new Escola("Escola B");

        Professor prof1 = new Professor("João");
        Professor prof2 = new Professor("Maria");

        escola1.adicionarProfessor(prof1);
        escola1.adicionarProfessor(prof2);
        escola2.adicionarProfessor(prof1);

        System.out.println("Professores da " + escola1.getNome() + ": " + escola1.listarProfessores());
        System.out.println("Professores da " + escola2.getNome() + ": " + escola2.listarProfessores());
        System.out.println("Escolas onde " + prof1.getNome() + " leciona: " + prof1.listarEscolas());
        System.out.println("Escolas onde " + prof2.getNome() + " leciona: " + prof2.listarEscolas());
    }
}

class Professor {
    private String nome;
    private List<Escola> escolas;

    public Professor(String nome) {
        this.nome = nome;
        this.escolas = new ArrayList<>();
    }

    public void adicionarEscola(Escola escola) {
        if (!escolas.contains(escola)) {
            escolas.add(escola);
        }
    }

    public void removerEscola(Escola escola) {
        if (escolas.contains(escola)) {
            escolas.remove(escola);
        }
    }

    public List<String> listarEscolas() {
        List<String> nomes = new ArrayList<>();
        for (Escola escola : escolas) {
            nomes.add(escola.getNome());
        }
        return nomes;
    }

    public String getNome() {
        return nome;
    }
}
