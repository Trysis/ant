package controleur;

import gameloop.GameLoop;
import gui.Vue;
import gui_intefarces.Gui_Ant;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import model.Ant;
import model.Model;

public class Controleur {
	private GameLoop gameloop=new GameLoop();
	private Vue vue;
	private Model model;
	public Controleur(Vue vue,Model model) {
		this.vue=vue;
		this.model=model;
		
		gameloop.addObservableObject(model);
		gameloop.setRenderer(vue).start();
		addEventOnCanvas(MouseEvent.MOUSE_CLICKED);
	}
	public void addEventOnCanvas(EventType<MouseEvent> event) {
		vue.getCanvas().addEventHandler(event, e ->{
			Gui_Ant tmp=(Gui_Ant) new Gui_Ant().setRayon(2).setXCenter(e.getSceneX()).setYCenter(e.getSceneY());
			Ant tmp_2 = new Ant(tmp);
			model.addAntObject(tmp_2);
			vue.addGuiObject(tmp);
		});
	}
}
