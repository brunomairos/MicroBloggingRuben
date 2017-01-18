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
public class NodeUtilizador {

    private Utilizador utilizador;
    //apontador para o próximo utilizador
    private NodeUtilizador proximoUtilizador;

    // construtor sem argumentos
    public NodeUtilizador() {
    }

    //construtor com argumentos. O 2º parâmetro é para criar a lista de utilizadores principal
    //ou a lista de utilizadores que cada um dos utilizadores segue.
    public NodeUtilizador(Utilizador user) {
        this.utilizador = user;
        proximoUtilizador = MicroBloggingRuben.primeiroUtilizador;
        MicroBloggingRuben.primeiroUtilizador = this;

    }
    
    public NodeUtilizador(Utilizador user, Utilizador userSeguido) {
        this.utilizador = userSeguido;
        proximoUtilizador = user.getPrimeiroUtilizadorSeguido();
        user.setPrimeiroUtilizadorSeguido(this);

    }

    public NodeUtilizador getProximoUtilizador() {
        return proximoUtilizador;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public void setProximo(NodeUtilizador pUtilizador) {
        proximoUtilizador = pUtilizador;
    }

}
