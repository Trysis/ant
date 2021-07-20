package gui_intefarces;

import javafx.scene.image.Image;

public interface GuiObject {
	public Image getImage();
	public double getX();
	public double getY();
	public double getXCenter();
	public double getYCenter();
	public double getAngle();
	
	public GuiObject setXCenter(double x);
	public GuiObject setYCenter(double y);
	public GuiObject setAngle(double angle);
}
