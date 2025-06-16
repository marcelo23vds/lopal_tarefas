package br.dev.marcelo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import br.dev.marcelo.tarefas.factory.FileFactory;
import br.dev.marcelo.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	private FileFactory ff = new FileFactory();

	// Método construtor
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void gravar() {

		try {

			//MEU PC: "C:\\Users\\vieir\\Desktop\\tarefas.csv"
			//SENAI: "C:\\Users\\25132416\\tarefa\\tarefas.csv"
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\vieir\\Desktop\\tarefas.csv", true);

			bw.write(tarefa.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Tarefa> showTarefas() {

		List<Tarefa> tarefas = new ArrayList<>();

		try {

			//MEU PC: "C:\\Users\\vieir\\Desktop\\tarefas.csv"
			//SENAI: "C:\\Users\\25132416\\tarefa\\tarefas.csv"
			BufferedReader br = ff.getBufferedReader("C:\\Users\\vieir\\Desktop\\tarefas.csv");

			String linha = br.readLine();

			do {
				linha = br.readLine();

				Tarefa t = new Tarefa();
				String[] tarefa = linha != null ? linha.split(",") : null;

				if (tarefa != null) {
					t.setCodigo(tarefa[0]);
					t.setTitulo(tarefa[1]);
					t.setResponsavel(tarefa[7]);				

					tarefas.add(t);
				}

			} while (linha != null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return tarefas;
	}
	
}
