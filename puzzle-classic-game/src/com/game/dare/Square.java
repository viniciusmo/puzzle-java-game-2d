package com.game.dare;

import java.awt.Image;

public class Square implements Cloneable {
	private Image image;
	private int pos;
	private int x;
	private int y;
	private int myX;
	private int myY;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMyX() {
		return myX;
	}

	public void setMyX(int myX) {
		this.myX = myX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int myY) {
		this.myY = myY;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
