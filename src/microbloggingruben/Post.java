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
    private String hashtags="";
    
    public Post(String dataHora, String post){
        setMsg(post);
        setDataHora(dataHora);
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        //Guardar as hashtgs
        String[] palavrasMsg = msg.split(" ");
        int nPalavras = palavrasMsg.length;
        for (int i = 0; i < nPalavras; i++) {
            //Verifica se a palavra começa por #
            if(palavrasMsg[i].charAt(0)=='#'){
                hashtags = hashtags + palavrasMsg[i].substring(1).replaceAll("[^0-9a-zA-Z]", "") + ";";
            }
        }
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
}
