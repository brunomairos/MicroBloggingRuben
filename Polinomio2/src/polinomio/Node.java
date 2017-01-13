/*
 * Programa : Opera??es com polin?mios
 * Ficheiro : Node.java
 * Descri??o: Classe que define um n? de uma lista ligada
 * jsimoes
 */

package polinomio;

// classe que define um n? de uma lista ligada simples
public class Node {
    
    // apontador para o objecto a armazenar em cada n? da lista
    private Object dados;
    // apontador para o pr?ximo n?
    private Node proximo;
    
    // construtor sem argumentos
    Node(){}
    
    // construtor com argumentos
    Node( Object d ){
        dados = d;
        proximo = Main.primeiro;
        Main.primeiro = this;
    }
    
    public Node getProximo(){
        return proximo;
    }
    
    public Object getDados(){
        return dados;
    }
     
    public void setDados( Object d ){
        dados = d;
    }
     
    public void setProximo( Node p ){
        proximo = p;
    }
}
