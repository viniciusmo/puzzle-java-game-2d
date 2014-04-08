package com.game.dare;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayerMusic  {
	private String caminhoMusica;
	private Player player;

	public PlayerMusic(String caminhoMusica) {
		this.caminhoMusica = caminhoMusica;
	}

	public void play() {

		try {
			FileInputStream fis = new FileInputStream(caminhoMusica);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {

		}

		new Thread() {
			public void run() {
				try {
					player.play();

				} catch (Exception e) {
				}
			}
		}.start();

	}



}
