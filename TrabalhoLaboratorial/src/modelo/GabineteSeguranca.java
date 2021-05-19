package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao{
    //ATRIBUTOS
    private LinkedList<Seguranca> segurancas;

    //CONSTRUTOR
    public GabineteSeguranca(String nome, boolean aberta) {
        super(nome, aberta);
        this.segurancas = new LinkedList<>();
    }

    //MÉTODOS
    public LinkedList<Seguranca> getSegurancas() {
        return new LinkedList<>(segurancas);
    }

    public void adicionar(Seguranca seguranca) {
        if (seguranca == null || segurancas.contains(seguranca)){
            return;
        }
        segurancas.add(seguranca);
        seguranca.setGabinete(this);
    }

    public void remover(Seguranca seguranca) {
        if (!segurancas.contains(seguranca)){
            return;
        }
        segurancas.remove(seguranca);
        seguranca.desassociarGabinete();
    }
}
