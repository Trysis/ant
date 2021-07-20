package model;

import gui_intefarces.Gui_Ant;

public class Ant extends AntObject {
	private Gui_Ant guiobject;
	
	private double rayon;
	public Ant(Gui_Ant guiobject) {
		super(guiobject);
		this.rayon=guiobject.getRayon();
	}

	@Override
	public void update(long t) {
		
	}

	@Override
	public void updateview() {
		
	}

}
