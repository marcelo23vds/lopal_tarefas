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
import br.dev.marcelo.tarefas.gui.TelaCadastroFuncionario;
import br.dev.marcelo.tarefas.model.Funcionario;
import br.dev.marcelo.tarefas.model.Tarefa;

public class Main {
	
	
	
	//determinando caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132416\\tarefa\\tarefas.txt";
	
	public static void main(String[] args) {
	
	TelaCadastroFuncionario tela = new TelaCadastroFuncionario();
	tela.criarTela();
//		
//		List<Funcionario> funcionarios = new ArrayList<>();
//		
//		Funcionario funcionario = new Funcionario();
//		funcionario.setCodigo(4);
//		funcionario.setNome("Tiago");
//		funcionario.setMatricula("2516090");
//		funcionario.setEmail("tiago@gmail.com");
//		
//		Funcionario funcionario2 = new Funcionario();
//		funcionario2.setCodigo(5);
//		funcionario2.setNome("Marcos");
//		funcionario2.setMatricula("2518090");
//		funcionario2.setEmail("marcos@gmail.com");
//		
//		funcionarios.addAll(List.of(funcionario, funcionario2));
//		
//		for (Funcionario f : funcionarios) {
//			System.out.println(f.getMatricula() + "   -   " + f.getNome() + "   -   " + f.getEmail());
//		}
//		
//		System.out.println(funcionarios.toString()); 
		
////		
////		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
////		dao.gravar();
//		
	}
//	
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
		
		
//		
	}

}
