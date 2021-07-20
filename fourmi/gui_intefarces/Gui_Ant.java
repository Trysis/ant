package gui_intefarces;

import gameloop.Renderer;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Gui_Ant extends Canvas implements GuiObject,Renderer{
	private GraphicsContext context=this.getGraphicsContext2D();
	private Color object_color=Color.SANDYBROWN;
	
	private double x,y;
	private double rayon;
	private double angle;
	
	{
		setRayon(1);
		render();
	}
	
	@Override
	public Image getImage() {
		SnapshotParameters parametres = new SnapshotParameters();
		parametres.setFill(Color.TRANSPARENT);
		return this.snapshot(parametres, null);
	}
	@Override
	public double getX() {
		return x;
	}
	@Override
	public double getY() {
		return y;
	}
	@Override
	public double getXCenter() {
		return x+rayon;
	}
	@Override
	public double getYCenter() {
		return y+rayon;
	}
	@Override
	public double getAngle() {
		return angle;
	}
	public double getRayon() {
		return rayon;
	}

	@Override
	public GuiObject setXCenter(double x) {
		this.x=x-rayon;
		return this;
	}

	@Override
	public GuiObject setYCenter(double y) {
		this.y=y-rayon;
		return this;
	}
	@Override
	public GuiObject setAngle(double angle) {
		this.angle=angle;
		return this;
	}
	public GuiObject setRayon(double rayon) {
		this.rayon=rayon;
		setWidth(rayon*2);
		setHeight(rayon*2);
		return this;
	}

	@Override
	public void render() {
		context.save();
		context.setFill(object_color);
		context.clearRect(0, 0, getWidth(), getHeight());
		context.fillOval(0, 0, getWidth(), getHeight());
		context.restore();
	}
}
