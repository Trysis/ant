package model;

import java.util.LinkedList;

public class Model implements ObservableAntObject{
	private LinkedList<AntObject> antobject_list=new LinkedList<>();//LinkedList pour maintenir l'ordre d'apparition

	@Override
	public void addAntObject(AntObject antobject) {
		antobject_list.add(antobject.hashCode(), antobject);
	}

	@Override
	public void removeAntObject(AntObject antobject) {
		antobject_list.remove(antobject.hashCode());
	}
	@Override
	public void Notify(long t) {
		for(AntObject tmp: antobject_list)tmp.update(t);
	}
}
