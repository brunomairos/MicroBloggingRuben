/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microbloggingruben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rcunha
 */
public class Ficheiro {
    private BufferedReader fr;
    private BufferedWriter fw;
    
    /**
     * Método de instancia que averigua se existe um ficheiro com uma 
     * certa designacao.
     * @param nomeFicheiro
     * @return
     * @throws IOException 
     */
    public boolean existeFicheiro(String nomeFicheiro) throws IOException{ 
        boolean existe=false; 
            if(new File(nomeFicheiro).isFile()==false){
                 System.out.println("O ficheiro não existe!");
                 existe = false;    
            }else{
                System.out.println("O ficheiro existe!");
                existe = true; 
            }
            return(existe); 
        }
    /**
     * Metodo de instancia de abertura de um ficheiro para leitura.
     * @param nomeFicheiro
     * @throws IOException 
     */
    public void abreLeitura( String nomeFicheiro ) throws IOException {
        fr = new BufferedReader( new FileReader( nomeFicheiro));
    }
    /**
     * Metodo de instancia de abertura de um ficheiro para escrita.
     * @param nomeFicheiro
     * @throws IOException 
     */
    public void abreEscrita( String nomeFicheiro, boolean notNewFile ) throws IOException {
        fw = new BufferedWriter( new FileWriter(nomeFicheiro, notNewFile));
    }
    
    /**
     * Metodo de instancia de fecha o processo de escrita num ficheiro.
     * @throws IOException 
     */
    public void fechaEscrita() throws IOException {
        fw.close();
    }
    
    /**
     * Metodo de instancia que permite ler a informacao de uma linha do ficheiro.
     * @return
     * @throws IOException 
     */
    public String leLinha() throws IOException{
        return fr.readLine();
    }
    
    /**
     * Metodo de instancia que permite escrever informacao numa linha 
     * de um ficheiro.
     * @param linha
     * @throws IOException 
     */
     public void escreveLinha( String linha ) throws IOException{
        fw.write( linha, 0, linha.length());
        fw.newLine();
    }
}
