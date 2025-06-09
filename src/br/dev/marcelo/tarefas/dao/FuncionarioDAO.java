package br.dev.marcelo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.marcelo.tarefas.factory.FileFactory;
import br.dev.marcelo.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private FileFactory ff = new FileFactory();

	// Método construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {

		try {

			//MEU PC: "C:\\Users\\vieir\\Desktop\\funcionarios.csv"
			//SENAI: "C:\\Users\\25132416\\tarefa\\funcionarios.csv"
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\25132416\\tarefa\\funcionarios.csv", true);

			bw.write(funcionario.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Funcionario> showEmployees() {

		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			
			//MEU PC: "C:\\Users\\vieir\\Desktop\\funcionarios.csv"
			//SENAI: "C:\\Users\\25132416\\tarefa\\funcionarios.csv"
			BufferedReader br = ff.getBufferedReader("C:\\Users\\25132416\\tarefa\\funcionarios.csv");

			String linha = br.readLine();

			do {
				linha = br.readLine();

				Funcionario f = new Funcionario();
				String[] funcionario = linha != null ? linha.split(",") : null;

				if (funcionario != null) {
					f.setCodigo(funcionario[0]);
					f.setNome(funcionario[1]);
					f.setTelefone(funcionario[2]);
					f.setEmail(funcionario[3]);

					funcionarios.add(f);
				}

			} while (linha != null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return funcionarios;
	}

}
