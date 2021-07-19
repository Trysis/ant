package controleur;

import gameloop.GameLoop;
import gui.Vue;
import model.Model;

public class Controleur {
	private GameLoop gameloop=new GameLoop();
	private Vue vue;
	private Model model;
	public Controleur(Vue vue,Model model) {
		this.vue=vue;
		this.model=model;
		
		gameloop.setRenderer(vue).start();
	}
}
