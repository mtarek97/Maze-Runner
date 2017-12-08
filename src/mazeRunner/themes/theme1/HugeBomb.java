package mazeRunner.themes.theme1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import mazeRunner.model.mapElement.DirectionContract;
import mazeRunner.model.mapElement.IObserver;
import mazeRunner.model.mapElement.MapCell;
import mazeRunner.model.mapElement.Obstacle;

public class HugeBomb extends Obstacle {
private final String DestroySound = "";
private final String HittingSound = "";
private final int Damage = 8;
private  int health = 5;
private HashMap<Integer,IObserver> observers = new HashMap<Integer,IObserver>();

	@Override
	public MapCell Destroy() {
		MapCell w1=new Way1();
		w1.addBombVisualEffects(DirectionContract.THIS_CELL, this.Damage);
		CellFactory cf = new CellFactory();
		return cf.getFullObject(w1);
		
	}

	@Override
	public String getDestroyingSound() {
		return DestroySound;
	}

	@Override
	public String getHittingSound() {
		return HittingSound;
	}

	@Override
	public int getDamage() {
		return this.Damage;
	}
	
	@Override
	public boolean addObserver(IObserver observer, int ObservingDirection) {
		this.observers.put(ObservingDirection, observer);
		return true;
	}

	public boolean removeObserver(IObserver observer) {
		for(Entry<Integer,IObserver> e : this.observers.entrySet()){
			if(e.getValue()==observer){
				this.observers.remove(e.getKey(), e.getValue());
				return true;
			}
	}
		return false;
	}

	public boolean notifyChanges() {
		for(Entry<Integer,IObserver> e : this.observers.entrySet()){
				e.getValue().update(e.getKey(), this.Damage);
		}
		return true ;
	}

	public void update(int damage) {
		if(damage>=this.health){
		this.Destroy();
		}else{
			this.health-=damage;
		}
		
	}

	
	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(int health) {
		this.health=health;		
	}

	@Override
	public void update(int direction, int fullDamage) {
		this.addBombVisualEffects(direction, fullDamage);
	}





}
