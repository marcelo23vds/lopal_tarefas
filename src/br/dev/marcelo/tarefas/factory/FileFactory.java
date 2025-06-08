package br.dev.marcelo.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

    public BufferedReader getBufferedReader(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }

    public BufferedWriter getBufferedWriter(String path, boolean append) throws IOException {
        FileWriter fw = new FileWriter(path, append);
        BufferedWriter bw = new BufferedWriter(fw);
        return bw;
    }
    
    //para utilizar filefactory, passar o caminho como parametro nos métodos 
    //getBufferedReader e getBufferedWriter para usar essa classe para qualquer arquivo


}