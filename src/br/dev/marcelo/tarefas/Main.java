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

	public static void main(String[] args) {

		new FrameInicial();

//		Para o App funcionar corretamente é necessario informar o local dos arquivos "tarefas" e "funcionarios" nas classes do package "dao"
//		Caso o arquivo não exista o app cria automaticamente no local informado
//		E se o arquivo for criado automaticamente, lembrar que a primeira linha foi programada para ser ignorada, pois o correto é ela ser o cabeçalho.

	}

}

//	UTILIZAR COMO DOCUMENTAÇÃO PARA LEITURA E ESCRITA DE ARQUIVOS:

//	private static void gravarArquivo() {
//		
//		FileWriter arquivo = null;
//		BufferedWriter escritor = null;
//		
//		try {
//			
//			arquivo = new FileWriter(path, true);
//			escritor = new BufferedWriter(arquivo);
//			
//			escritor.write("Ultima linha por enquanto\n");
//			escritor.flush();
//			
//		} catch (Exception erro) {
//			System.out.println(erro);
//		}
//		
//	}
//
//	private static void lerArquivo() {
//		
//
//		//abrir arquivo para leitura
//		FileReader file = null;
//		BufferedReader buffer = null;
//		try {
//			file = new FileReader(path);
//			buffer = new BufferedReader(file);
//			
//			String linha = buffer.readLine();
//			
//			while (linha != null) {
//				System.out.println(linha);
//				linha = buffer.readLine();
//			}
//			
//		} catch (FileNotFoundException erro) {
//			System.out.println("Arquivo não achado!");
//			System.out.println(erro.getMessage());
//		} catch (IOException erro) {
//			System.out.println("Você não pode ler o arquivo!");
//			System.out.println(erro.getMessage());
//		} catch (Exception erro) {
//			System.out.println("Erro genérico!");
//			System.out.println(erro.getMessage());
//		}
//		
//		
//		
//	}
