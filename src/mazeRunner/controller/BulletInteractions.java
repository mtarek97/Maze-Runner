package mazeRunner.controller;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.projectiles.Bullet;

public class BulletInteractions {
	Map map;
	Bullet bullet;
	MapCell bulletCell;
	int bulletMappedPositionX;
	int bulletMappedPositionY;
	BuildingController buildingController;

	public BulletInteractions(BuildingController buildingController, Map map, Bullet bullet) {
		this.buildingController = buildingController;
		this.map = map;
		this.bullet = bullet;

	}

	public void update() {
		bulletMappedPositionX = bullet.getMappedPosition().x;
		bulletMappedPositionY = bullet.getMappedPosition().y;
		System.out.println("bullet mapped position : " + bulletMappedPositionX + " " + bulletMappedPositionY);
		System.out.println("bullet position : " + bullet.getPosition().x + " " + bullet.getPosition().y);
		bulletCell = map.getCellsLayer()[bulletMappedPositionX][bulletMappedPositionY];
		if (isThereAnAction()) {
			performBulletInteraction();
		}
	}

	private boolean isThereAnAction() {
		// get current bullet mapped position and see if there is any thing in
		// that position
		return bulletCell.isObstacle() || bulletCell.isNonObstacle()
				|| (bulletCell.isWall() && bulletCell.isDestroyable());
	}

	public void performBulletInteraction() {
		// bullet interaction logic will be here
		if(bulletCell.update(01)){
			map.addCellAtRunTime(bulletCell.getUpdateResult(), bulletMappedPositionX, bulletMappedPositionY);
	    	if(bulletCell.getUpdateResult() != null) {
				//TODO : open thread to view ashes on the screen
			}else{
				buildingController.removeFromCellsLayer(bulletMappedPositionX, bulletMappedPositionY);
			}
		}
	}
}
