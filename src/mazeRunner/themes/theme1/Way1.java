package mazeRunner.themes.theme1;

import mazeRunner.model.mapElement.IObserver;
import mazeRunner.model.mapElement.MapCell;
import mazeRunner.model.mapElement.Way;

public class Way1 extends Way{

	@Override
	public boolean isDestroyable() {
		return false;
	}

	@Override
	public MapCell Destroy() {
		return this;
	}

	

	@Override
	public String getDestroyingSound() {
		return null;
	}





	public boolean removeObserver(IObserver observer) {
		return false;
	}

	public boolean notifyChanges() {
		return false;
	}



	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public void addBombVisualEffects(int direction, int fullDamage) {
		
	}


	@Override
	public boolean addObserver(IObserver observer, int ObservingDirection) {
		return false;
	}

	@Override
	public void update(int direction, int fullDamage) {
		this.addBombVisualEffects(direction, fullDamage);		
	}



}
