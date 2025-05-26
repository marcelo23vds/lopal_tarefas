package br.dev.marcelo.tarefas.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import br.dev.marcelo.tarefas.model.Funcionario;

public class TelaCadastroFuncionario {

	private JLabel lblTitulo;
	private JList listFuncionarios;
	private JButton buttonExcluir;
	private JButton buttonNovo;

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("FUNCIONARIOS CADASTRADOS");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);

		lblTitulo = new JLabel();
		lblTitulo.setText("Funcionarios Cadastrados");
		lblTitulo.setBounds(170, 30, 200, 10);

		listFuncionarios = new JList();
		listFuncionarios.setBounds(40, 90, 400, 250);

		buttonExcluir = new JButton();
		buttonExcluir.setText("EXCLUIR");
		buttonExcluir.setBounds(80, 370, 150, 40);

		buttonNovo = new JButton();
		buttonNovo.setText("NOVO");
		buttonNovo.setBounds(250, 370, 150, 40);

		tela.getContentPane().add(lblTitulo);
		tela.getContentPane().add(listFuncionarios);
		tela.getContentPane().add(buttonExcluir);
		tela.getContentPane().add(buttonNovo);
		
		tela.setVisible(true);

	}

}
