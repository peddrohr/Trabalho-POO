package com.mycompany.avaliacaosubmissaodetrabalhos;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.AlunoInvalidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;

public class Professor{
    //atributos
    private String siape;
    private Usuario usuario;
    private boolean avaliador;
    private boolean orientador;
    private List<Aluno> alunosOrientados = new ArrayList<>();
    private List<Trabalho> trabalhosAvaliados = new ArrayList<>();
    private Avaliacao avaliacao;

    //construtores
    public Professor(String nome,String cpf, String email,String senha, String siape) {
        this.usuario = new Usuario(nome,cpf, email, senha);
        this.siape = siape != null ? siape : "";
        this.avaliador = false;
        this.orientador = false; 
    }
    
    public Professor(Usuario usuario, String siape) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.siape = siape != null ? siape : ""; 
        this.orientador = false;
        this.avaliador = false;
    }

    public Professor() {
        this.usuario = new Usuario("", "", "", "");
        this.siape = "";
    }

    //setters
    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
    }
    public void setEmail(String email){
        this.usuario.setEmail(email);
    }
    public void setSiape(String siape) {
        if (siape != null && !siape.isEmpty()) {
            this.siape = siape;
        } else {
            throw new ExceptionInInitializerError("O email não pode ser vazio");
        }
    }
    public void setSenha(String senha){
        usuario.setSenha(senha);
    }

    public void setNome(String nome){
        usuario.setNome(nome);
    }

    public void setCpf(String cpf){
        usuario.setCpf(cpf);
    }

    //getters

    public String getEmail() {
        return usuario.getEmail();
    }

    public String getNome() {
        return usuario.getNome();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSiape() {
        return siape;
    }

    public boolean getAvaliador(){ return avaliador; }
   
    //Metodos
    public void serOrientador(){
        if(this.orientador == false){
            this.orientador = true;
        }
    }

    public void naoSerOrientador(){
        if(this.orientador == true){
            this.orientador = false;
        }
    }

    public void serAvaliador(){
        if(this.avaliador == false){
            this.avaliador = true;
        }
    }
    
    public void naoSerAvaliador(){
        if(this.avaliador == true){
            this.avaliador = false;
        }
    }

    //metodos para o papel de orientador
    public void addAlunoOrientado(Aluno aluno) throws AlunoInvalidoException{
        if(orientador){
            if(aluno == null){
                throw new AlunoInvalidoException();
            }
            this.alunosOrientados.add(aluno);
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void removerAlunoOrientado(Aluno alunoOrientado){
        if(orientador){
            this.alunosOrientados.remove(alunoOrientado);
        }else{
            throw new IllegalArgumentException();
        }       
    }

    public List<Aluno> getAlunosOrientados(){
        if(orientador){
            return new ArrayList<>(alunosOrientados);
        }
        throw new IllegalArgumentException();
    }
    
    //metodos para o papel de avaliador
    public void addTrabalhoAvaliado(Trabalho trabalho)throws SemTrabalhoDefinidoException{
        if(avaliador){
            if(trabalho == null){
                throw new SemTrabalhoDefinidoException();
            }
            this.trabalhosAvaliados.add(trabalho);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void removerTrabalhoAvaliado(Trabalho trabalhoAvalido) throws SemTrabalhoDefinidoException{
        if(avaliador){
            if(trabalhoAvalido == null){
                throw new SemTrabalhoDefinidoException();
            }
            this.trabalhosAvaliados.remove(trabalhoAvalido);
        }else{
            throw new IllegalArgumentException();
        }    
    }
    public List<Trabalho> getTrabalhosAvaliados() {
        if(avaliador){
            return new ArrayList<>(trabalhosAvaliados);
        }
        throw new IllegalArgumentException();
        
    }

    public void avaliarTrabalho(Trabalho trabalho){
        Avaliacao avaliacao = new Avaliacao(trabalho);
        this.avaliacao = avaliacao;
    }

    public void avaliarCriterio(CriterioAvaliacao criterio, float nota) throws NotaInvalidaException{
        avaliacao.avaliarCriterio(criterio, nota);
    }

    public Avaliacao adicionarNota(Trabalho trabalho, float nota, String comentario){
        if(avaliador){
            if(trabalhosAvaliados.contains(trabalho)){
                if(trabalho.getAvaliacoes().size()<2){
                    Avaliacao avaliar = new Avaliacao(trabalho, nota, comentario);
                    trabalhosAvaliados.remove(trabalho);
                    if(trabalho.getAvaliacoes().size()<2){
                        trabalho.AdicionarAvaliacao(this, avaliacao);
                    }else{
                        throw new IllegalArgumentException();
                    }
                    return avaliar;
                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }
}
