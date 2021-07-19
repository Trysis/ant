package gameloop;

import model.ObservableObject;

public interface ObservableObservableObject {
	public void addObservableObject(Integer key,ObservableObject gameobject);
	public void removeObservableObject(Integer key);
	public void Notify(long t);
}
