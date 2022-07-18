package tic_tac_toe_game_java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame implements ActionListener{
	
	private JButton buttons[] = new JButton[9];
	private int player = 0;
	private String players[] = {"X", "O"};
	
	public Game() {
		//Definindo as características da JFrame/tela inicial.
		setSize(605, 640);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		init();
		setVisible(true);
	}

	private void init() {
		
		int width = (getWidth() / 3) - 5, height = ((getHeight() - 40) / 3); //Tamanho dos botões
		int x = 0, y = 0; //Posição inicial dos botões
		int i = 0;
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				//Criando uma instância de JButton e definindo suas características
				JButton button = new JButton();
				button.setSize(width, height);
				button.setLocation(x, y);
				button.setFont(new Font("Calibri", 0, 104));
				button.addActionListener(this);
				buttons[i] = button;
				add(buttons[i]);
				x += width; 
			}
			x = 0;
			y += height;
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
		}
	}
}
