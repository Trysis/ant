package model;

import gui_intefarces.GuiObject;

public abstract class AntObject {
	protected Vecteur position;
	protected Vecteur vitesse;
	protected Vecteur acceleration;
	
	protected GuiObject guiobject;
	
	protected double angle;
	
	public AntObject(GuiObject guiobject) {
		this.guiobject=guiobject;
		angle=guiobject.getAngle();
		
		position=new Vecteur(guiobject.getXCenter(),guiobject.getYCenter());
		vitesse=new Vecteur();
		acceleration=new Vecteur();
	}
	
	public abstract void update(long t);
	public abstract void updateview();
	
	public void setPosition(double x,double y) {
		position.setVecteur(x,y);
	}
	public void setX(double x) {
		position.setX(x);
	}
	public void setY(double y) {
		position.setY(y);
	}
	public void setXVitesse(double x) {
		vitesse.setX(x);
	}
	public void setYVitesse(double y) {
		vitesse.setY(y);
	}
	public void setXAcceleration(double x) {
		acceleration.setX(x);
	}
	public void setYAcceleration(double y) {
		acceleration.setY(y);
	}
	public boolean isMovable() {
		return true;
	}
}
