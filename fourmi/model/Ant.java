package model;

import gui_intefarces.Gui_Ant;

public class Ant extends AntObject {
	private Gui_Ant guiobject;
	private double rayon;
	{
		vitesse.setCap(1);
	}
	public Ant(Gui_Ant guiobject) {
		super(guiobject);
		this.guiobject=guiobject;
		this.rayon=guiobject.getRayon();
	}

	@Override
	public void update(long t) {
		vitesse.addVecteur(Math.random()*2-1, Math.random()*2-1);
		position.addVecteur(vitesse);
	}

	@Override
	public void updateview() {
		guiobject.setXCenter(position.getX());
		guiobject.setYCenter(position.getY());
	}

}
