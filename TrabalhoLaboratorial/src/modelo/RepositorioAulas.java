package modelo;

import java.util.LinkedList;

public interface RepositorioAulas {
    LinkedList<Aula> getAulas();
    LinkedList<Aula> getAulas(Horario horario);
    void adicionar(Aula aula);
    void remover(Aula aula);
    boolean contem(Aula aula);
}
