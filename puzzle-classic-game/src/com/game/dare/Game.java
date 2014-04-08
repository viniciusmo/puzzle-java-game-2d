package com.game.dare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.game.dare.utils.Generate;

public class Game extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private Square[][] squares;
	private Square selected;

	public Game() {
		setSize(400, 400);
		squares = new Square[6][6];
		addMouseListener(this);
		initSquares();

	}

	private void initSquares() {
		Queue<Integer> generate = Generate.randomSequence(9);
		int pos = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Square s = new Square();
				pos = generate.remove();
				ImageIcon ii = new ImageIcon(this.getClass().getResource(
						"images/" + pos + ".png"));
				s.setImage(ii.getImage());
				s.setPos(pos);
				s.setX(j * 50);
				s.setY(i * 50);
				s.setMyX(i);
				s.setMyY(j);
				squares[i][j] = s;
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 0, 0));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Square s = squares[i][j];
				g2.drawImage(s.getImage(), s.getX(), s.getY(), this);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = e.getY() / 50;
		int j = e.getX() / 50;

		PlayerMusic playerMusic;
		if (selected == null) {
			playerMusic = new PlayerMusic("sounds/1.mp3");
			playerMusic.play();
			selected = squares[i][j];
			customCursor();
		} else {
			try {
				setCursor(null);
				if (validaTroca(i, j)
						&& (squares[i][j].getPos() == 9 || selected.getPos() == 9)) {
					Square aux = (Square) squares[i][j].clone();
					squares[i][j].setPos(selected.getPos());
					squares[i][j].setImage(selected.getImage());
					selected.setImage(aux.getImage());
					selected.setPos(aux.getPos());
				} else {
					playerMusic = new PlayerMusic("sounds/3.mp3");
					playerMusic.play();
				}
				selected = null;
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}

		}
		if (validaPuzzle()) {
			JOptionPane.showMessageDialog(this, "Ganhou!");
		}
		repaint();

	}

	public boolean validaPuzzle() {
		int cont = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(squares[i][j].getPos() == cont))
					return false;
				cont++;
			}

		}
		return true;
	}

	private void customCursor() {
		try {
			Toolkit tk = Toolkit.getDefaultToolkit();
			setCursor(tk.createCustomCursor(
					ImageIO.read(this.getClass().getResourceAsStream(
							"images/" + selected.getPos() + ".png")),
					new Point(15, 15), "MyCursor"));
		} catch (HeadlessException e2) {
			e2.printStackTrace();
		} catch (IndexOutOfBoundsException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	private boolean validaTroca(int i, int j) {
		System.out.println(i + "  " + j);
		System.out.println(selected.getMyX() + "  " + selected.getMyY());
		if (i == selected.getMyX() + 1 && j == selected.getMyY())
			return true;
		else if (i == selected.getMyX() - 1 && j == selected.getMyY())
			return true;
		else if (j == selected.getMyY() + 1 && i == selected.getMyX())
			return true;
		else if (j == selected.getMyY() - 1 && i == selected.getMyX())
			return true;

		return false;
	}

}
