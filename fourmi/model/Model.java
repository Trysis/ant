package model;

import java.util.ArrayList;

import model_interfaces.ObservableAntObject;

public class Model implements ObservableAntObject{
	private ArrayList<AntObject> antobject_list=new ArrayList<>();//ArrayList pour maintenir l'ordre d'apparition
	
	@Override
	public void addAntObject(AntObject antobject) {
		antobject_list.add(antobject);
	}

	@Override
	public void removeAntObject(AntObject antobject) {
		antobject_list.remove(antobject);
	}
	@Override
	public void Notify(long t) {
		for(AntObject tmp: antobject_list)tmp.update(t);
		for(AntObject tmp: antobject_list)tmp.updateview();
	}
}
