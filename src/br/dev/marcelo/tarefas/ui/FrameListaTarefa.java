package br.dev.marcelo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.marcelo.tarefas.dao.TarefaDAO;
import br.dev.marcelo.tarefas.model.Tarefa;

public class FrameListaTarefa {

	private JLabel labelTitulo;
	private JTable tableTarefas;
	private JScrollPane scrollTarefas;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnVoltar;

	private Font fontTitulo = new Font("Arial", Font.BOLD, 18);

	public FrameListaTarefa() {
		criarTela();
	}

	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		labelTitulo = new JLabel("Lista de Tarefas");
		labelTitulo.setBounds(10, 20, 500, 30);
		labelTitulo.setFont(fontTitulo);

		btnNovo = new JButton("Cadastrar");
		btnVoltar = new JButton("Voltar");

		// Criação de tabela
		String[] colunas = new String[3];
		colunas[0] = "Código da tarefa";
		colunas[1] = "Titulo";
		colunas[2] = "Código do responsavel";

//		obter lista de tarefas
		TarefaDAO dao = new TarefaDAO(null);

		List<Tarefa> tarefas = dao.showTasks();

		Object[][] dados = new Object[tarefas.size()][3];

		int linha = 0;

		for (Tarefa t : tarefas) {

			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][2] = t.getResponsavel();

			linha++;
		}

		tableTarefas = new JTable(dados, colunas);

		scrollTarefas = new JScrollPane(tableTarefas);
		scrollTarefas.setBounds(10, 70, 500, 300);

		btnNovo.setBounds(10, 380, 150, 40);
		btnVoltar.setBounds(170, 380, 150, 40);

		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnNovo);
		painel.add(btnVoltar);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa(tela);
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tela.dispose();
			}
		});

		tela.setVisible(true);

	}

}
