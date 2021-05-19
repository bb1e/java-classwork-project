package modelo;

import java.util.LinkedList;

public class GestorAulas {
    protected AssociavelAulas associavelAulas;
    protected LinkedList<Aula> aulas;

    public GestorAulas(AssociavelAulas associavelAulas) {
        this.associavelAulas = associavelAulas;
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for (Aula aula : this.aulas) {
            if(aula.getHorario().isSobre(horario)){
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
    }

    public void adicionar(Aula aula){
        if(aula == null || aulas.contains(aula)){
            return;
        }

        aulas.add(aula);

        associavelAulas.associar(aula);
    }

    public void remover(Aula aula){
        if(!aulas.contains(aula)){
            return;
        }

        aulas.remove(aula);

        associavelAulas.desassociar(aula);
    }

    public boolean contem(Aula aula){
        return aulas.contains(aula);
    }
}
