package modelo;

import java.util.LinkedList;

public class Aula extends Identificador{

    //ATRIBUTOS
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;

    //CONSTRUTORES
    //construtor mais específico
    public Aula(String nome, long numero, Horario horario, Sala sala){
        //deve invocar o construtor mais geral
        this(nome, numero, horario, sala, null, new LinkedList<>());
    }

    //construtor mais geral //deve inicializar todos os atributos
    public Aula(String nome, long numero, Horario horario, Sala sala, Professor professor, LinkedList<Aluno> alunos){
        super(nome, numero);
        sumario = new StringBuilder();
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno: alunos) {
            adicionar(aluno);
        }
        this.horario = horario;
        this.sala = sala;
    }

    //MÉTODOS
    public void atribuir(Professor professor){
        this.professor = professor;
    }

    public String getSumario() {
        return sumario.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) { //Adicionar esta aula ao professor
        //não posso atribuir a aula se a referência que entra for nula
        //ou se este professor já estiver atribuído
        if (professor == null || this.professor == professor){
            return;
        }

        //verificar se este professor já tinha sido atribuído
        if(this.professor!=null){
            //remover a aula do professor a que estava atribuído à aula
            this.professor.remover(this);
        }

        //adiciona esta aula ao professor
        this.professor = professor;
        professor.adicionar(this);
    }

    public void desassociarProfessor(){
        if (professor == null){
            return;
        }

        Professor professorARemover = this.professor; //variável auxiliar para apontar para o professor que queremos desassociar

        //colocar o professor da aula a null
        this.professor = null;

        //remover a aula do professor
        professorARemover.remover(this);

    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);  //devolver a referência para a lista de alunos
    }

    public void adicionar(Aluno aluno){
        if(aluno == null || alunos.contains(aluno)){
            return;
        }

        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno){
        if(!alunos.contains(aluno)){
            return;
        }

        Aluno alunoARemover = aluno;

        alunos.remove(aluno);

        alunoARemover.remover(this);
    }

    public void adicionarLinhaSumario(String linhaSumario){
        sumario.append(linhaSumario).append("\n");
    }

    public Horario getHorario() {
        return horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        if (sala == null || this.sala == sala){
            return;
        }

        if (this.sala != null){
            this.sala.remover(this);
        }

        this.sala = sala;
        sala.adicionar(this);
    }

    public void desassociarSala() {
        if(sala == null) {
            return;
        }

        Sala salaAux = sala;
        this.sala = null;
        salaAux.remover(this);
    }
}