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
public class Utilitarios {
    public static void carregaUtilizadores(){
        
    }
    
    public static void carregaListaSeguidores(){
        
    }
    
    public static void carregaPosts(){
        
    }
    
    public static NodeUtilizador inserirUtilizador( NodeUtilizador nUtilizador, Utilizador utilizador ){
        //Validar nickname
        NodeUtilizador n2 = Utilitarios.pesquisarUtilizadorNickName(utilizador.getNickname());
        
        //Se existe um utilizador com esse nickname retornamos novamente o 1º,
        //não é acrescentado um novo utilizador.
        if( n2 != null ) {
            return MicroBloggingRuben.primeiroUtilizador;
        }
        // Senão eexiste é inserido um novo utilizador na lista
        else{
            nUtilizador.setUtilizador(utilizador);
            nUtilizador.setProximo(MicroBloggingRuben.primeiroUtilizador);
            return nUtilizador;
        }
    }
    
    public static NodeUtilizador pesquisarUtilizadorNickName(String nickName){
        NodeUtilizador no = MicroBloggingRuben.primeiroUtilizador;
        Utilizador utilizador;
        while(no != null){
            utilizador = (Utilizador) no.getUtilizador();
            if(utilizador.getNickname().equalsIgnoreCase(nickName)){
                break;
            } else{
                no = no.getProximoUtilizador();
            }
        }
        
        if(no != null){
            //Mensagem de nickname inválido
        }
        return no;
    }
    
     // listagem de todos os termos do polin?mio
    public static void listarUtilizadores(){
        NodeUtilizador no = MicroBloggingRuben.primeiroUtilizador;
        Utilizador utilizador;
        while( no != null ){
            utilizador = (Utilizador)no.getUtilizador();
            System.out.println(utilizador.getNickname());
            no = no.getProximoUtilizador();
            if( no != null ){
                System.out.print( " + " );
            }
            else{
                System.out.println();
            }
        }
    }
}
