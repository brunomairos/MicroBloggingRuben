/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microbloggingruben;

/**
 *
 * @author rcunha
 */
public class Utilizador {

    private static int nUtilizadores;
    private String nome;
    private String nickname;
    private String password;
    private NodeUtilizador primeiroUtSeguido;
    private NodePost primeiroPost;
    private int nSeguindo, nPosts;

    public Utilizador(String nome, String nickname, String password) {
        setNome(nome);
        setNickname(nickname);
        setPassword(password);
        nUtilizadores++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }
    
    public int getnSeguindo() {
        return nSeguindo;
    }
    
    public void setnSeguindo(int numero) {
        nSeguindo = numero;
    }
    
    public int getnPosts() {
        return nPosts;
    }
    
    public void setnPosts(int numero) {
        nPosts = numero;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        String userInfo = this.getNome() + " " + this.getNickname() + " " + this.getPassword() + " - ";
        NodeUtilizador no = this.primeiroUtSeguido;
        Utilizador utilizador;
        String seguidores = "";
        while (no != null) {
            utilizador = (Utilizador) no.getUtilizador();
            userInfo = userInfo + utilizador.getNickname();
            no = no.getProximoUtilizador();
            if (no != null) {
                userInfo = userInfo + "; ";
            } else {
                userInfo = userInfo + ";";
            }
        }
        return userInfo;
    }

    public static int getNutilizadores() {
        return nUtilizadores;
    }

    public NodeUtilizador getPrimeiroUtilizadorSeguido() {
        return primeiroUtSeguido;
    }

    public void setPrimeiroUtilizadorSeguido(NodeUtilizador utSeguido) {
        primeiroUtSeguido = utSeguido;
    }
    
    public NodePost getPrimeiroPost() {
        return primeiroPost;
    }

    public void setPrimeiroPost(NodePost npost) {
        primeiroPost = npost;
    }

}
