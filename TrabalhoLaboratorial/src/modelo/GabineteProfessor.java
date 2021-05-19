package modelo;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao{
    //ATRIBUTOS
    private LinkedList<Professor> professores;

    //CONSTRUTOR
    public GabineteProfessor(String nome, boolean aberta) {
        super(nome, aberta);
        this.professores = new LinkedList<>();
    }

    //MÉTODOS
    public LinkedList<Professor> getProfessores() {
        return new LinkedList<>(professores);
    }

    public void adicionar(Professor professor) {
        if (professor == null || professores.contains(professor)){
            return;
        }
        professores.add(professor);
        professor.setGabinete(this);
    }

    public void remover(Professor professor) {
        if (!professores.contains(professor)){
            return;
        }
        professores.remove(professor);
        professor.desassociarGabinete();
    }
}
