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
public class Post {
    private String msg;
    private String dataHora;
    //Para facilitar pesquisa por hastags
        //private (lista de hastags)
    
    public Post(String dataHora, String post){
        setMsg(post);
        setDataHora(dataHora);
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
}
