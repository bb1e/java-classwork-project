package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas, AssociavelAulas{
    //ATRIBUTOS
    //protected LinkedList<Aula> aulas;
    protected GestorAulas gestorAulas;

    //CONSTRUTORES
    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        //this.aulas = new LinkedList<>();
        gestorAulas = new GestorAulas(this);
    }

    //MÉTODOS
    @Override
    public LinkedList<Aula> getAulas() {
        //return new LinkedList<>(aulas);
        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas(horario);
    }

    @Override
    public void adicionar(Aula aula){
        gestorAulas.adicionar(aula);
    }

    @Override
    public void remover(Aula aula){
        gestorAulas.remover(aula);
    }

    @Override
    public boolean contem(Aula aula) {
        return gestorAulas.contem(aula);
    }

    public void preencherSumario(Aula aula) {
        //verificar se o aluno pode preencher o sumário
        if (!contem(aula)) {
            return;
        }

        //escrever o sumário
        escreverSumario(aula);
    }

    protected void assinarSumario(Aula aula){
        //colocar a sua assinatura
        aula.adicionarLinhaSumario(nome);
    }
    protected abstract void escreverSumario(Aula aula);
}
