package model_interfaces;

import model.AntObject;

public interface ObservableAntObject extends ObservableObject{
	public void addAntObject(AntObject antobject);
	public void removeAntObject(AntObject antobject);
}
