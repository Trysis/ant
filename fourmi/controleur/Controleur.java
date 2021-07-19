package controleur;

import gui.Vue;
import model.Model;

public class Controleur {
private Vue vue;
private Model model;
public Controleur(Vue vue,Model model) {
	this.vue=vue;
	this.model=model;
}
}
