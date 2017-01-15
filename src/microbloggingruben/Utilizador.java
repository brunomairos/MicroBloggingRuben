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
    //private (lista ligada) utSeguir;
    //private (lista de posts) posts;
    
    public Utilizador(String nome, String nickname, String password){
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static int getNutilizadores() {
        return nUtilizadores;
    }
}
