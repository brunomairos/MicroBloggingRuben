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
public class NodePost {
    private Post post;
    private NodePost proximoPost;
    
    public NodePost(){
        
    }
    
    public NodePost(Utilizador utilizador, Post post){
        this.post = post;
        proximoPost = utilizador.getPrimeiroPost();
        utilizador.setPrimeiroPost(this);
    }
    
    public Post getPost(){
        return post;
    }
    
    public void setPost(Post post){
        this.post = post;
    }
    
    public NodePost getProximoPost(){
        return proximoPost;
    }
    
}
