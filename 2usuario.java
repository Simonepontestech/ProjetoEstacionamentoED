usuario.java

package projetoJava;

public class Usuario {
    private String nome;
    private String funcao;
    private long CPF;


    public Usuario(String nome, String funcao, long CPF) {
        this.nome = nome;
        this.funcao = funcao;
        this.CPF = CPF;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public long getCPF() {
        return this.CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }


    @Override
    public String toString() {
        return "Nome - "+getNome()+", Função - "+getFuncao()+", CPF - "+getCPF();
    }

}