package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas {

    //ATRIBUTOS
    private GabineteProfessor gabinete;
    private LinkedList<Horario> horariosAtendimento;

    //CONSTRUTORES
    public Professor(String nome, long numero, GabineteProfessor gabinete){
        super(nome, numero);    //constrói estas variáveis na superclasse onde se encontram
        setGabinete(gabinete);
        horariosAtendimento = new LinkedList<>();
    }

    //MÉTODOS

    @Override
    public void associar(Aula aula) {
        //atribuir este professor à aula
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    @Override
    protected void escreverSumario(Aula aula){
        //preencher os dados da aula (nome e número)
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));

        //colocar a assinatura do professor
        super.assinarSumario(aula);

        //percorrer os alunos da aula e colocar cada aluno a preencher o sumário (através da sua assinatura)
        //usar um foreach
        for (Aluno aluno: aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    public GabineteProfessor getGabinete() {
        return gabinete;
    }

    public void setGabinete(GabineteProfessor gabinete) {
        if(gabinete == null || this.gabinete == gabinete){
            return;
        }

        if (this.gabinete != null){
            this.gabinete.remover(this);
        }

        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarGabinete() {
        if (this.gabinete==null){
            return;
        }

        GabineteProfessor gabineteProfessor = gabinete;
        this.gabinete = null;
        gabineteProfessor.remover(this);
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return new LinkedList<>(horariosAtendimento);
    }

    public void adicionar(Horario horario) {
        if (horario == null || horariosAtendimento.contains(horario)){
            return;
        }
        horariosAtendimento.add(horario);
    }

    public void remover(Horario horario) {
        if (horario == null || !horariosAtendimento.contains(horario)){
            return;
        }
        horariosAtendimento.remove(horario);
    }

    public void abrir(Sala sala) {
        if (sala.isAberta()){
            return;
        }
        sala.abrir();
    }

    public void fechar(Sala sala) {
        if (!sala.isAberta()){
            return;
        }
        sala.fechar();
    }

    public void abrirGabinete() {
        if(gabinete == null || gabinete.isAberta()){
            return;
        }
        gabinete.abrir();
    }

    public void fecharGabinete() {
        if(gabinete == null || !gabinete.isAberta()){
            return;
        }
        gabinete.fechar();
    }
}
