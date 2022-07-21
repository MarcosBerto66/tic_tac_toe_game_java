package tic_tac_toe_game_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame implements ActionListener{
	
	//Cores
	private Color light_green = new Color(173, 223, 173);
	private Color green = new Color(0, 154, 117);
	private Color white = new Color(248, 248, 248);
	
	//Elementos
	private JButton buttons[] = new JButton[9];
	private int player = 0;
	private String players[] = {"X", "O"};
	
	public Game() {
		//Definindo as características da JFrame/tela inicial.
		setSize(590, 613);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(white);
		init();
		setVisible(true);
	}

	private void init() {
		
		int width = 170, height = 170; //Tamanho dos botões
		int margin = 16;
		int x = margin, y = margin; //Posição inicial dos botões
		int i = 0;
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++, i++) {
				//Criando uma instância de JButton e definindo suas características
				JButton button = new JButton();
				button.setSize(width, height);
				button.setLocation(x, y);
				button.setFont(new Font("Arial Rounded MT Bold", 0, 180));
				button.setForeground(green);
				button.addActionListener(this);
				button.setOpaque(true);
				button.setBackground(light_green);
				button.setFocusPainted(false);
				button.setBorder(null);
				buttons[i] = button;
				add(buttons[i]);
				x += width + margin; 
			}
			x = margin;
			y += height + margin;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource(); //Ao clicar em um JButton este método é executado
		if(button.getText().isEmpty()) {
			if(player == 0) {//Alternando entre os jogadores
				button.setText(players[player]);
				player = 1;
			}else {
				button.setText(players[player]);
				player = 0;
			}
			if(gameover()) {
				int r = JOptionPane.showConfirmDialog(null,   "Deseja jogar novamente?");
				if(r == JOptionPane.YES_OPTION) {
					play();
				}else {
					this.dispose();
				}
			}
		}
	}
	
	private boolean allAreFull() {
		for(JButton i: buttons) {
			if(i.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private void play() {
		for(JButton i: buttons) {
			i.setText("");
		}
		player = 0;
	}

	private boolean gameover() {
		int i = 0;
		for (int l = 0; l < 3; l++) {//Verificando as linhas
			String p = "";
			for (int c = 0; c < 3; c++, i++) {
				p += buttons[i].getText();
			}
			if(p.equals("XXX") || p.equals("OOO")) {
				return true;
			}
		}
		for (int c = 0; c < 3; c++) {//Verificando as colunas
			String p = "";
			i = c;
			for (int l = 0; l < 3; l++, i+=3) {
				p += buttons[i].getText();
			}
			if(p.equals("XXX") || p.equals("OOO")) {
				return true;
			}
		}
		String v = buttons[0].getText() + buttons[4].getText() + buttons[8].getText();//Verificando a primeira diagonal
		if(v.equals("XXX") || v.equals("OOO")) {
			return true;
		}
		v = buttons[2].getText() + buttons[4].getText() + buttons[6].getText();//Verificando a segunda diagonal
		if(v.equals("XXX") || v.equals("OOO")) {
			return true;
		}
		return allAreFull(); //Verificando se todos os botões possuem conteúdo
	}
}
