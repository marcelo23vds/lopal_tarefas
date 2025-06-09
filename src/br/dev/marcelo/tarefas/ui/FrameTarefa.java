package br.dev.marcelo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.marcelo.tarefas.dao.FuncionarioDAO;
import br.dev.marcelo.tarefas.dao.TarefaDAO;
import br.dev.marcelo.tarefas.model.Funcionario;
import br.dev.marcelo.tarefas.model.Status;
import br.dev.marcelo.tarefas.model.Tarefa;
import br.dev.marcelo.tarefas.utils.Utils;

public class FrameTarefa {

	private JLabel labelTitulo;
	private JLabel labelDescricao;
	private JLabel labelDataInicial;
	private JLabel labelPrazo;
	private JLabel labelDataConclusao;
	private JLabel labelStatus;
	private JLabel labelResponsavel;

	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtDataInicial;
	private JTextField txtPrazo;
	private JTextField txtDataConclusao;
	private JComboBox<Status> boxStatus;
	private JComboBox<Funcionario> boxResponsavel;

	private JButton btnSalvar;
	private JButton btnSair;

	public FrameTarefa(JFrame telaLista) {
		criarTela(telaLista);
	}

	private void criarTela(JFrame telaLista) {

		JDialog tela = new JDialog(telaLista, "Cadastro de tarefas", true);
		tela.setLayout(null);
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaLista);

		labelTitulo = new JLabel("Titulo:");
		labelTitulo.setBounds(20, 20, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 50, 200, 30);

		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(20, 85, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 115, 350, 30);

		labelDataInicial = new JLabel("Data Inicial:");
		labelDataInicial.setBounds(20, 150, 200, 30);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 180, 200, 30);
		//desabilitado por enquanto
		txtDataInicial.setEnabled(false);

		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(20, 215, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 245, 200, 30);
		//desabilitado por enquanto
		txtPrazo.setEnabled(false);

		labelDataConclusao = new JLabel("Data de Conclusão:");
		labelDataConclusao.setBounds(20, 280, 200, 30);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 310, 200, 30);
		//desabilitado por enquanto
		txtDataConclusao.setEnabled(false);

		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(20, 345, 200, 30);
		boxStatus = new JComboBox<Status>(Status.values());
		boxStatus.setBounds(20, 375, 200, 30);

		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(20, 410, 200, 30);
		boxResponsavel = new JComboBox<Funcionario>();
		boxResponsavel.setBounds(20, 440, 200, 30);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 490, 100, 40);

		btnSair = new JButton("Sair");
		btnSair.setBounds(130, 490, 100, 40);

		Container painel = tela.getContentPane();

		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		
		
		painel.add(labelDataInicial);
		painel.add(txtDataInicial);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		
		painel.add(labelStatus);
		painel.add(boxStatus);
		
		painel.add(labelResponsavel);
		painel.add(boxResponsavel);
		
		
		painel.add(btnSalvar);
		painel.add(btnSair);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(Utils.gerarUUID());
				tarefa.setTitulo(txtTitulo.getText());
				tarefa.setDescricao(txtDescricao.getText());
//				tarefa.setDataInicial(txtDataInicial.getText());
//				tarefa.setPrazo(txtPrazo.getText());
//				tarefa.setDataConclusao(txtDataConclusao.getText());
				tarefa.setStatus((Status) boxStatus.getSelectedItem());
				
				TarefaDAO dao = new TarefaDAO(tarefa);
				dao.gravar();
				
				JOptionPane.showMessageDialog(
						tela,
						txtTitulo.getText() + " gravado com sucesso!",
						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
				);
				
				limparFormulario();

			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Confirma a saída do sistema?", "Sair do sistema",
						JOptionPane.YES_NO_OPTION);
				if (resposta == 0) {
					tela.dispose();
				}
			}
		});

		tela.setVisible(true);
	}

	private void limparFormulario() {
		txtTitulo.setText(null);
		txtDescricao.setText(null);
		txtDataInicial.setText(null);
		txtPrazo.setText(null);
		txtDataConclusao.setText(null);
	}
	
}
