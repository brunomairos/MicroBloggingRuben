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
    private String post;
    private String dataHora;
    //Para facilitar pesquisa por hastags
        //private (lista de hastags)
    
    public Post(String post, String dataHora){
        setPost(post);
        setDataHora(dataHora);
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
}
