package br.dev.marcelo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.marcelo.tarefas.dao.FuncionarioDAO;
import br.dev.marcelo.tarefas.model.Funcionario;
import br.dev.marcelo.tarefas.model.Tarefa;
import br.dev.marcelo.tarefas.ui.FrameFuncionario;
import br.dev.marcelo.tarefas.ui.FrameInicial;
import br.dev.marcelo.tarefas.ui.FrameListaFuncionario;
import br.dev.marcelo.tarefas.utils.Utils;

public class Main {
	
	//determinando caminho do arquivo que será lido
	
//	UTILIZAR ESSE NO PC DO SENAI
//	private static String path = "C:\\Users\\25132416\\tarefa\\tarefas.csv"; 
	
//	UTILIZAR ESSE NO PC DE CASA
	private static String path = "C:\\Users\\vieir\\Desktop\\tarefas.csv"; 
	
	
	public static void main(String[] args) {
		
		new FrameInicial();
		
//		new FrameFuncionario();
		
	}
	
	private static void gravarArquivo() {
		
		FileWriter arquivo = null;
		BufferedWriter escritor = null;
		
		try {
			
			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);
			
			escritor.write("Ultima linha por enquanto\n");
			escritor.flush();
			
		} catch (Exception erro) {
			System.out.println(erro);
		}
		
	}

	private static void lerArquivo() {
		

		//abrir arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico!");
			System.out.println(erro.getMessage());
		}
		
		
		
	}

}
