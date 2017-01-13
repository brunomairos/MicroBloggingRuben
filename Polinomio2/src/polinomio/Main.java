/*
 * Programa : Opera??es com polin?mios
 * Ficheiro : Main.java
 * Descri??o: Classe com m?todos para gest?o da lista de termos e menu da aplica??o
 * jsimoes
 */

package polinomio;

// classe para gest?o do polin?mio
public class Main {
    
    // apontador global para o primeiro n? da lista
    public static Node primeiro;
    
    // insere um novo n? na lista ou, se j? existir um termo do mesmo grau,
    // adiciona os coeficientes
    public static Node inserirTermo( Node n, Termo t ){
        Node n2 = pesquisarTermo( t.getGrau() );
        // se j? existir um termo com o mesmo grau, adiciona coeficientes
        if( n2 != null ) {
            Termo t2 = (Termo)n2.getDados();
            t2.setCoeficiente( t.getCoeficiente() + t2.getCoeficiente() );
            return primeiro;
        }
        // sen?o insere um novo n? na lista
        else{
            n.setDados( t );
            n.setProximo( primeiro );
            return n;
        }
    }
    
    // listagem de todos os termos do polin?mio
    public static void listar(){
        Node n = primeiro;
        Termo t;
        while( n != null ){
            t = (Termo)n.getDados();
            t.print();
            n = n.getProximo();
            if( n != null ){
                System.out.print( " + " );
            }
            else{
                System.out.println();
            }
        }
    }
    
    // pesquisa e imprime um termo sendo dado o grau respectivo
    public static Node pesquisarTermo( int n ){
        Node no = primeiro;
        Termo t;
        while( no != null){
            t = (Termo)no.getDados();
            if( t.getGrau() == n ){
                System.out.print( "Encontrado: " );
                t.print();
                System.out.println();
                break;
            }
            else{
                no = no.getProximo();
            }
        }
        if( no == null ){
            System.out.println( "Termo n?o encontrado!" );
        }
        return no;
    }
    
    // retorna o n?mero de termos do polin?mio
    public static int contaTermos(){
        Node no = primeiro;
        int n = 0;
        while( no != null ){
            n++;
            no = no.getProximo();
        }
        return n;
    }
     
    // retorna o valor do polin?mio para um valor de x dado
    public static double calculaPolinomio( double x ){
        Node n = primeiro;
        Termo t;
        double valor = 0.0;
        while( n != null ){
            t = (Termo)n.getDados();
            valor += t.getCoeficiente() * Math.pow( x, t.getGrau() );
            n = n.getProximo();
        }
        return valor;
    }
   
    // programa principal com menu de gest?o do polin?mio
    public static void main(String[] args) {
        int c;
        do{
            System.out.println();
            System.out.println( "1 - Inserir termo" );
            System.out.println( "2 - Listar polinomio" );
            System.out.println( "3 - Pesquisar termo" );
            System.out.println( "4 - Numero de termos" );
            System.out.println( "5 - Calcular polinomio" );
            System.out.println( "6 - Sair" );
            System.out.println();
            
            c = Le.umInt();
            
            switch( c ){
                case 1:     
                    Node novo = new Node();
                    System.out.println( "Novo termo" );
                    System.out.println( "Inserir Coeficiente:" );
                    double d = Le.umDouble();
                    System.out.println( "Inserir Expoente:" );
                    int i = Le.umInt();
                    Termo novoTermo = new Termo( d, i);
                    primeiro = inserirTermo( novo, novoTermo );
                    break;
                case 2:
                    System.out.println( "Termos do polinomio:" );
                    listar();
                    break;
                case 3:
                    System.out.println( "Pesquisar termo" );
                    System.out.println( "Grau do termo a pesquisar: " );
                    int num = Le.umInt();
                    pesquisarTermo( num );
                    break;
                case 4:
                    System.out.println( "N?mero de termos = " + contaTermos() );
                    break;
                case 5:
                    System.out.println( "Valor do polinomio para x = " );
                    double x = Le.umDouble();
                    System.out.println( "Polinomio = " + calculaPolinomio( x ) );
                    break;
                case 6:
                    break;
                default:
                    System.out.println( "Op??o inv?lida!" );
            }
        } while( c >= 1 && c <= 6 );  
    }
}
