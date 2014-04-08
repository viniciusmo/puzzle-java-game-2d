package com.viniciusmo.classicpuzzle;

import java.awt.Color;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public Main() {
		add(new Game());
		setBackground(new Color(238, 238, 238));
		setSize(150, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle(":D");
	}

	public static void main(String[] args) {

		new Main();
	}

}
