/*
 * Programa : Opera??es com polin?mios
 * Ficheiro : Termo.java
 * Descri??o: Classe que define um termo do polin?mio
 * jsimoes
 */

package polinomio;

// classe que define um termo do polin?mio
public class Termo {
    
    // coeficiente do termo
    private double coeficiente;
    // grau do termo
    private int    grau;
    
    // construtor sem argumentos
    public Termo(){}
    
    // construtor com argumentos
    public Termo( double c, int g ) {
        coeficiente = c;
        grau = g;
    }
    
    public void setCoeficiente( double c ){
        coeficiente = c;
    }
    
    public void setGrau( int g ){
        grau = g;
    }
    
    public double getCoeficiente(){
        return coeficiente;
    }
    
    public int getGrau(){
        return grau;
    }
    
    public void print(){
        System.out.print( coeficiente + "x^" + grau );
    }
}
