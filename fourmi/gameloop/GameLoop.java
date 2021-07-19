package gameloop;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.AnimationTimer;
import model.ObservableObject;

public class GameLoop extends AnimationTimer implements ObservableObservableObject{
	private Renderer renderer;//Utile pour mettre a jour l'affichage
	
	private long TempsTotal=0;//Temps total d'animation
	private long lastFrameTime = System.nanoTime();//Temps d'animation
	private boolean enPause=false;//Specifie si l'animation est en pause ou non
	private boolean changed=true;//Specifie si des donnees ont ete mis a jour et doivent etre actualises visuellement 
	
	private HashMap<Integer,ObservableObject> observableObject_list = new HashMap<>();
	//Start - Handle - Stop
	@Override
	public void start() {
		enPause=false;
		changed=true;
		super.start();
	}
	@Override
	public void handle(long now) {
		if(!enPause)Notify(call(now));
		else lastFrameTime=call(now);
		if(changed) {
			renderer.render();
			if(enPause)changed=false;
		}
	}
	//Permet de calculer le temps d'animation (entre l'animation précedente et celle qui arrive)
	private long call(long now) {
		long secondsSinceLastFrame = (now-lastFrameTime);
		lastFrameTime = now;
		TempsTotal+=secondsSinceLastFrame;
		return secondsSinceLastFrame;
	}
	@Override
	public void stop() {
		enPause=true;
		changed=false;
	}
	//Interface ObservableObject - Methodes 
	@Override
	public void addObservableObject(Integer key,ObservableObject observableAntobject) {
		observableObject_list.put(key,observableAntobject);
		changed=true;
	}
	@Override
	public void removeObservableObject(Integer key) {
		observableObject_list.remove(key);
		changed=true;
	}
	@Override
	public void Notify(long t) {
		for(Map.Entry<Integer, ObservableObject> tmp: observableObject_list.entrySet())tmp.getValue().Notify(t);
	}
	//Event
	public void setChanged(boolean b) {
		changed=b;
	}
	//Renderer
	public GameLoop setRenderer(Renderer renderer) {
		this.renderer=renderer;
		return this;
	}
}
