package mazeRunner.themes.spaceTheme;

import java.util.Observable;

import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;

public class SpaceBomb extends Obstacle{

		private MapCell afterUpdate = null;
		private final String standardImageLink ="file:mazeRunner.themes.spaceTheme.media.images.bomb1.png";


		private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
		private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
		private  int health = 2;
		private int damage = 3;
		

		@Override
		public String getDestroyingSound() {
			return this.destroySound;
		}

		@Override
		public String getHittingSound() {
			return this.hittingSound;
		}

		@Override
		public int getHealth() {
			return this.health;
		}




		@Override
		public boolean update(int fullDamage) {
			this.health -= fullDamage;
			if(this.getHealth()<=0){
				//this.afterUpdate = new ashes(); TODO
				return true;
			}
			return false;
		}

		@Override
		public MapCell getUpdateResult() {
			return this.afterUpdate;
		}

		@Override
		public String getImageLink() {
			return this.standardImageLink;
		}

		@Override
		public int getDamage() {
			return this.damage;
		}



	
}
