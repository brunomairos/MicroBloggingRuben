/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microbloggingruben;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcunha
 */
public class Utilitarios {

    public static void carregaUtilizadores() throws IOException {
        String nomeFicheiro = "utilizadores.txt";
        Ficheiro f1 = new Ficheiro();
        if (f1.existeFicheiro(nomeFicheiro)) {
            String linha = new String();
            f1.abreLeitura(nomeFicheiro);
            do {
                linha = f1.leLinha();
                if (linha != null) {
                    String[] conteudoLinha = linha.split("§");
                    //conteudoLinha = nome§nickname,password
                    Utilizador utilizador = new Utilizador(conteudoLinha[0], conteudoLinha[1], conteudoLinha[2]);
                    NodeUtilizador nUtilizador = new NodeUtilizador(utilizador);
                    carregaPosts(utilizador);
                }
            } while (linha != null);
            carregaListaSeguidores();
            new UIAutenticacaoUtilizador();
        } else {
            new UIRegNovoUtilizador();
        }
    }

    public static void carregaListaSeguidores() throws IOException {
        String nomeFicheiro = "seguidores.txt";
        Ficheiro f1 = new Ficheiro();
        if (f1.existeFicheiro(nomeFicheiro)) {
            String linha = new String();
            f1.abreLeitura(nomeFicheiro);
            do {
                linha = f1.leLinha();
                if (linha != null) {
                    String[] conteudoLinha = linha.split("§");
                    //conteudoLinha = nome§nickname,password
                    String nickName = conteudoLinha[0];
                    int nSeguidos = conteudoLinha.length;
                    NodeUtilizador nUtilizador = Utilitarios.pesquisarUtilizadorNickName(nickName);
                    Utilizador utilizador = nUtilizador.getUtilizador();
                    utilizador.setnSeguindo(nSeguidos-1);
                    for (int i = 1; i < nSeguidos; i++) {
                        NodeUtilizador utSeguir = Utilitarios.pesquisarUtilizadorNickName(conteudoLinha[i]);
                        NodeUtilizador nUtilizadorSeguido = new NodeUtilizador(utilizador, utSeguir.getUtilizador());
                    }
                }
            } while (linha != null);
        } else {

        }
    }

    public static void carregaPosts(Utilizador utilizador) throws IOException {
        String nomeFicheiro = utilizador.getNickname()+".txt";
        Ficheiro f1 = new Ficheiro();
        if (f1.existeFicheiro(nomeFicheiro)) {
            String linha = new String();
            f1.abreLeitura(nomeFicheiro);
            do {
                linha = f1.leLinha();
                if (linha != null) {
                    String[] conteudoLinha = linha.split("§");
                    //conteudoLinha = data - hora§Post
                    String dataHora = conteudoLinha[0];
                    String msg = conteudoLinha[1];
                    Post post = new Post(dataHora, msg);
                    utilizador.setnPosts(utilizador.getnPosts()+1);
                    new NodePost(utilizador, post);
                    //TO DO: gravar post e gravar hastags                    
                }
            } while (linha != null);
        } else {

        }
    }

    public static NodeUtilizador pesquisarUtilizadorNickName(String nickName) {
        NodeUtilizador no = MicroBloggingRuben.primeiroUtilizador;
        Utilizador utilizador;
        while (no != null) {
            utilizador = (Utilizador) no.getUtilizador();
            if (utilizador.getNickname().equalsIgnoreCase(nickName)) {
                break;
            } else {
                no = no.getProximoUtilizador();
            }
        }
        return no;
    }

    // listagem de todos os termos do polinomio
    public static void listarUtilizadores() {
        NodeUtilizador no = MicroBloggingRuben.primeiroUtilizador;
        Utilizador utilizador;
        while (no != null) {
            utilizador = (Utilizador) no.getUtilizador();
            System.out.println(utilizador.toString());
            no = no.getProximoUtilizador();
            if (no != null) {
                System.out.print(" + ");
            } else {
                System.out.println();
            }
        }
    }

    public static boolean RegistarNovoUtilizador(Utilizador utilizador) {

        Ficheiro f1 = new Ficheiro();
        try {
            f1.abreEscrita("utilizadores.txt", true);
            f1.escreveLinha(utilizador.getNome() + "§" + utilizador.getNickname() + "§" + utilizador.getPassword());
            f1.fechaEscrita();

            //Acrescentado o parâmetro true para permitir acrescentar linhas sem apagar o ficheiro existente.
            f1.abreEscrita("seguidores.txt", true);
            //Ciclo para acrescentar todos os seguidos pelo utilizador.Criar String com todos os nickNames dos
            //utilizadores seguidos
            NodeUtilizador no = utilizador.getPrimeiroUtilizadorSeguido();
            String seguidos = "§";
            while (no != null) {
                seguidos = seguidos + no.getUtilizador().getNickname();
                no = no.getProximoUtilizador();
                if (no != null) {
                    seguidos = seguidos + "§";
                }
            }
            f1.escreveLinha(utilizador.getNickname()+ seguidos);
            f1.fechaEscrita();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
