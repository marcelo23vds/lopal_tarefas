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
	private JButton btnSair;
//	private JButton btnVoltar; criar esse botao depois

	private Font fontTitulo = new Font("Arial", Font.BOLD, 18);

	public FrameListaTarefa() {
		criarTela();
	}

	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(1250, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		Container painel = tela.getContentPane();

		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setBounds(10, 20, 500, 30);
		labelTitulo.setFont(fontTitulo);

		btnNovo = new JButton("Cadastrar");

		// Criação de tabela
		String[] colunas = new String[8];
		colunas[0] = "Código da tarefa";
		colunas[1] = "Titulo";
		colunas[2] = "Descrição";
		colunas[3] = "Data Inicial";
		colunas[4] = "Prazo";
		colunas[5] = "Data de conclusão";
		colunas[6] = "Status";
		colunas[7] = "Código do responsavel";

//		obter lista de tarefas
		TarefaDAO dao = new TarefaDAO(null);

		List<Tarefa> tarefas = dao.showTasks();

		Object[][] dados = new Object[tarefas.size()][8];

		int linha = 0;

		for (Tarefa t : tarefas) {

			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][2] = t.getDescricao();
			dados[linha][3] = t.getDataInicial();
			dados[linha][4] = t.getPrazo();
			dados[linha][5] = t.getDataConclusao();
			dados[linha][6] = t.getStatus();
			dados[linha][7] = t.getResponsavel();

			linha++;
		}

		tableTarefas = new JTable(dados, colunas);

		scrollTarefas = new JScrollPane(tableTarefas);
		scrollTarefas.setBounds(10, 70, 1200, 300);

		btnNovo.setBounds(10, 380, 150, 40);

		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnNovo);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				new FrameTarefa(tela);
				// descobrir como atualizar a JTable apos sair da tela de dialogo
			}
		});

		tela.setVisible(true);

	}

}
