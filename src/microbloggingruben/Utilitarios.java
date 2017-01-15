/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microbloggingruben;

import java.io.IOException;

/**
 *
 * @author rcunha
 */
public class Utilitarios {
    public static void carregaUtilizadores() throws IOException{
        String nomeFicheiro = "utilizadores.txt";
        Ficheiro f1 = new Ficheiro();
        if(f1.existeFicheiro(nomeFicheiro)){
            String linha = new String();
            f1.abreLeitura(nomeFicheiro);
            do{
                linha = f1.leLinha();
                if(linha != null){
                    String[] conteudoLinha = linha.split("§");
                    //conteudoLinha = nome§nickname,password
                    new NodeUtilizador(new Utilizador(conteudoLinha[0], conteudoLinha[1], conteudoLinha[2]));
                }
            } while(linha != null);
            
            new AutenticacaoUtilizadorUI();
        } else{
            new RegNovoUtilizadorUI();
        }
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
        return no;
    }
    
     // listagem de todos os termos do polin?mio
    public static void listarUtilizadores(){
        NodeUtilizador no = MicroBloggingRuben.primeiroUtilizador;
        Utilizador utilizador;
        while( no != null ){
            utilizador = (Utilizador)no.getUtilizador();
            System.out.println(utilizador.toString());
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
