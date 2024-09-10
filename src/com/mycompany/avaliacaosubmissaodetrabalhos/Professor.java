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
    private List<Trabalho> trabalhosOrientados = new ArrayList<>();
    private List<Trabalho> trabalhosAvaliados = new ArrayList<>();
    private Avaliacao avaliacao;

    //construtores
    public Professor(String nome,String cpf, String email,String senha, String siape) {
        this.setUsuario(new Usuario(nome,cpf, email, senha));
        this.setSiape(siape);
        this.avaliador = false;
        this.orientador = false;
    }
    
    public Professor(Usuario usuario, String siape) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        setUsuario(usuario);
        setSiape(siape);
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

    public boolean getOrientador(){
        return orientador;
    }
   
    //Metodos
    //metodo para um professor se tornar um orientador
    public void serOrientador(){
        if(this.orientador == false){
            this.orientador = true;
        }
    }

    //metodo para um professor deixar de ser orientador
    public void naoSerOrientador(){
        if(this.orientador == true){
            this.orientador = false;
        }
    }

    //metodo para um professor se tornar um orientador
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
            this.trabalhosOrientados.add(aluno.getTrabalho());
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

    public List<Trabalho> getTrabalhosAvaliados() {
        if(avaliador){
            return new ArrayList<>(trabalhosAvaliados);
        }
        throw new IllegalArgumentException();
        
    }

    public List<Trabalho> getTrabalhosOrientados(){
        return trabalhosOrientados;
    }

    public void addTrabalhosOrientados(Trabalho trabalho){
        trabalhosOrientados.add(trabalho);
    }
    
    //metodos para o papel de avaliador

    //metodo para adicionar um trabalho para ser avaliado na lista de trabalhos que o avaliador deve avaliar.
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

    //remove um trabalho da lista de trabalho para serem avaliados.
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
   
    //metodo para o avaliador avaliar um trabalho.
    public void avaliarTrabalho(Trabalho trabalho) throws SemTrabalhoDefinidoException{
        Avaliacao avaliacao = new Avaliacao(trabalho);
        this.avaliacao = avaliacao;
    }

    //metodo para avaliar um critério
    public void avaliarCriterio(CriterioAvaliacao criterio, float nota) throws NotaInvalidaException{
        avaliacao.avaliarCriterio(criterio, nota);
    }

    //metodo para adicionar a nota em um trabalho, junto com um comentario.
    //nesse metodo tambem remove o trabalho da lista de trabalho para serem avaliados
    //para nao correr o risco de ser avaliado novamente;
    public Avaliacao adicionarNota(Trabalho trabalho, float nota, String comentario) throws SemTrabalhoDefinidoException{
        if(avaliador){
            if(trabalhosAvaliados.contains(trabalho)){
                if(trabalho.getAvaliacoes().size()<2){
                    Avaliacao avaliar = new Avaliacao(trabalho, nota, comentario);
                    trabalhosAvaliados.remove(trabalho);
                    if(trabalho.getAvaliacoes().size()<2){
                        trabalho.adicionarAvaliacao(this, avaliacao);
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
