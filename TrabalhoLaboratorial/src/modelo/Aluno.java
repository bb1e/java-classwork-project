package modelo;


public class Aluno extends PessoaComAulas {

    //ATRIBUTOS

    //CONSTRUTORES
    public Aluno(String nome, long numero){
        super(nome, numero);
    }

    //MÉTODOS
    @Override
    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    protected void escreverSumario(Aula aula){
        //colocar a sua assinatura
        aula.adicionarLinhaSumario(nome);
    }
}
