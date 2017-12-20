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
		System.out.println("mapped position : " + bulletMappedPositionX + " " + bulletMappedPositionY);
		System.out.println("position : " + bullet.getPosition().x + " " + bullet.getPosition().y);
		bulletCell = map.getCellsLayer()[bulletMappedPositionX][bulletMappedPositionY];
		if (isThereAnAction()) {
			performAction(getAction());
		}
	}

	private boolean isThereAnAction() {
		// get current bullet mapped position and see if there is any thing in
		// that position
		return bulletCell.isObstacle() || bulletCell.isNonObstacle()
				|| (bulletCell.isWall() && bulletCell.isDestroyable());
	}

	private void bulletGiftInteraction() {
		// bullet gift interaction logic will be here
		
	}

	private void bulletBombInteraction() {
		// bullet bomb interaction will be here
		
	}

	public void bulletDestroyableWallInteraction() {
		// bullet destroyableWall interaction will be here

	}

	private void performAction(String action) {
		// perform specific action based on its name
		if (action == "BombAction") {
			bulletBombInteraction();
		} else if (action == "GiftAction") {
			bulletGiftInteraction();
		} else if (action == "DestroyableWallAction") {
			bulletDestroyableWallInteraction();
		}

	}

	private String getAction() {
		// return the name of action
		if (bulletCell.isObstacle()) {
			return "BombAction";
		} else if (bulletCell.isNonObstacle()) {
			return "GiftAction";
		}else if(bulletCell.isWall() && bulletCell.isDestroyable()){
			return "DestroyableWallAction";
		}
		return null;
	}

}
