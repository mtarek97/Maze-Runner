package mazeRunner.themes.theme1;


import mazeRunner.model.mapElement.DirectionContract;
import mazeRunner.model.mapElement.IElementsGenerator;
import mazeRunner.model.mapElement.IMapCell;
import mazeRunner.model.mapElement.Obstacle;

public class HugeBomb extends Obstacle implements IElementsGenerator {
	private IMapCell afterUpdate = null;
	private final String standardImageLink ="";
	private  String currentImageLink = this.standardImageLink;

	/* from index 0 to 8 - Links to the images suitable for his direction*/
	private final String[] ashesImagesLink ={"","","","","","","","",""};

	private final String destroySound = "";
	private final String hittingSound = "";
	private  int health = 1;
	private int damage = 3 ;
	

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
	public void setAshes(int Direction) {
		this.currentImageLink = this.ashesImagesLink[Direction];
	}

	@Override
	public boolean update(int direction, int fullDamage) {
		this.health -= fullDamage;
		
		if(this.getHealth()<=0){
			IMapCell way ;
			switch(direction){
			case DirectionContract.NON : 
				way = new Way1();
				break;
			default :
				way = new Way1();
				way.setAshes(direction);
				break;
			}
			this.afterUpdate = way;
			return true ;
	
		}else{
			this.setAshes(direction);
		}


return false;
	}

	@Override
	public IMapCell getUpdateResult() {
		return this.afterUpdate;
	}

	@Override
	public String getImageLink() {
		return this.currentImageLink;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}


	@Override
	public void generate(IMapCell[][] maze, int[][] booleanMaze) {
		// TODO Auto-generated method stub

	}
}
