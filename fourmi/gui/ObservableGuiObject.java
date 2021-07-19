package gui;

import gameloop.Renderer;

public interface ObservableGuiObject extends Renderer{
	public void addGuiObject(Integer hashkey,GuiObject guiobject);
	public void removeGuiObject(Integer hashkey);
}
