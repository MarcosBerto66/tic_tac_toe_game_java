package tic_tac_toe_game_java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame implements ActionListener{
	
	private JButton buttons[] = new JButton[9];
	
	public Game() {
		setSize(600, 638);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		init();
		setVisible(true);
	}

	private void init() {
		
		int width = (getWidth() / 3), height = ((getHeight() - 38) / 3);
		System.out.println(width);
		System.out.println(height);
		int x = 0, y = 0;
		int i = 0;
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
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
		// TODO Auto-generated method stub
		
	}
}
