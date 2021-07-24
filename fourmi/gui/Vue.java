package gui;

import java.util.HashMap;
import java.util.Map;

import gui_intefarces.GuiObject;
import gui_intefarces.ObservableGuiObject;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Vue extends Pane implements ObservableGuiObject{
	private Color couleur_fond;
	private Canvas canvas;
	private GraphicsContext context;
	private HashMap<Integer,GuiObject> guiobject_list = new HashMap<>();
	
	private EventType<MouseEvent> mouse_event=MouseEvent.ANY;
	
	{//Initialisation
		canvas=new Canvas();
		context=canvas.getGraphicsContext2D();
		couleur_fond=Color.FLORALWHITE;
	}
	{//Children et Properties
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		
		getChildren().add(canvas);
	}
	public Canvas getCanvas() {
		return canvas;
	}
	@Override
	public void addGuiObject(GuiObject guiobject) {
		guiobject_list.put(guiobject.hashCode(), guiobject);
	}
	@Override
	public void removeGuiObject(Integer hashkey) {
		guiobject_list.remove(hashkey);
	}
	@Override
	public void render() {
		context.save();
		context.setFill(couleur_fond);
		context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(Map.Entry<Integer, GuiObject> tmp: guiobject_list.entrySet()) {
			context.drawImage(tmp.getValue().getImage(), tmp.getValue().getX(), tmp.getValue().getY());
		}
		context.restore();
	}

}
