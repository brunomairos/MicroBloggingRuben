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
public class Node {
//     private Object dados;
//    // apontador para o pr?ximo n?
//    private Node proximo;
//    
//    // construtor sem argumentos
//    Node(){}
//    
//    // construtor com argumentos
//    Node( Object d ){
//        dados = d;
//        proximo = Main.primeiro;
//        Main.primeiro = this;
//    }
//    
//    public Node getProximo(){
//        return proximo;
//    }
//    
//    public Object getDados(){
//        return dados;
//    }
//     
//    public void setDados( Object d ){
//        dados = d;
//    }
//     
//    public void setProximo( Node p ){
//        proximo = p;
//    }
//    
//     public static Node inserirTermo( Node n, Termo t ){
//        Node n2 = pesquisarTermo( t.getGrau() );
//        // se j? existir um termo com o mesmo grau, adiciona coeficientes
//        if( n2 != null ) {
//            Termo t2 = (Termo)n2.getDados();
//            t2.setCoeficiente( t.getCoeficiente() + t2.getCoeficiente() );
//            return primeiro;
//        }
//        // sen?o insere um novo n? na lista
//        else{
//            n.setDados( t );
//            n.setProximo( primeiro );
//            return n;
//        }
//    }
//    
//    // listagem de todos os termos do polin?mio
//    public static void listar(){
//        Node n = primeiro;
//        Termo t;
//        while( n != null ){
//            t = (Termo)n.getDados();
//            t.print();
//            n = n.getProximo();
//            if( n != null ){
//                System.out.print( " + " );
//            }
//            else{
//                System.out.println();
//            }
//        }
//    }
//    
//    // pesquisa e imprime um termo sendo dado o grau respectivo
//    public static Node pesquisarTermo( int n ){
//        Node no = primeiro;
//        Termo t;
//        while( no != null){
//            t = (Termo)no.getDados();
//            if( t.getGrau() == n ){
//                System.out.print( "Encontrado: " );
//                t.print();
//                System.out.println();
//                break;
//            }
//            else{
//                no = no.getProximo();
//            }
//        }
//        if( no == null ){
//            System.out.println( "Termo n?o encontrado!" );
//        }
//        return no;
//    }
//    
//    // retorna o n?mero de termos do polin?mio
//    public static int contaTermos(){
//        Node no = primeiro;
//        int n = 0;
//        while( no != null ){
//            n++;
//            no = no.getProximo();
//        }
//        return n;
//    }
}
    

