package mazeRunner.controller;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

import mazeRunner.StartGame;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.CheckPoint;
import mazeRunner.model.mapCells.IBombs;
import mazeRunner.model.mapCells.IGift;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner;
import mazeRunner.model.movingObjects.runners.WithA4;
import mazeRunner.model.movingObjects.runners.WithAK;
//import mazeRunner.model.movingObjects.runners.WithCHGun1;
//import mazeRunner.model.movingObjects.runners.WithCHGun2;
//import mazeRunner.model.movingObjects.runners.WithCHGun3;
import mazeRunner.model.movingObjects.runners.WithPistol;
import mazeRunner.model.movingObjects.runners.WithSpaceGun1;
import mazeRunner.model.movingObjects.runners.WithSpaceGun2;
import mazeRunner.model.movingObjects.runners.WithSpaceGun3;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;
import mazeRunner.view.ViewBuilder;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
	private final static Logger LOGGER = Logger.getLogger(RunnerInteractions.class.getName());
	Map map;
	IRunner runner;
	MapCell runnerCell;
	int runnerMappedPositionX;
	int runnerMappedPositionY;
	BuildingController buildingController;
	ViewBuilder viewBuilder = ViewBuilder.getViewBuilder();
	public RunnerInteractions(BuildingController buildingController, Map map) {
		this.buildingController = buildingController;
		this.map = map;
		this.runner = map.getRunner();

	}

	public void update() throws IllegalAccessException, InstantiationException {
		if(ifWin()){
			StartGame.root.getChildren().setAll(StartGame.startMenuePane);
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Win!");
		}
		else {
			runnerMappedPositionX = runner.getMappedPosition().x;
			runnerMappedPositionY = runner.getMappedPosition().y;
		
			runnerCell = map.getCellsLayer()[runnerMappedPositionX][runnerMappedPositionY];
			if (isThereAnAction()) {
				performAction(getAction());
			}
			viewBuilder.getScoreTextField().setText(PlayingController.score + "");
			viewBuilder.getRemainingLifesTextField().setText(PlayingController.ramainingLifes + "");
			viewBuilder.getHealthBar().setProgress(runner.getHealth() / 100);
		}

	}

	private boolean isThereAnAction() {
		// get current runner mapped position and see if there is any thing in
		// that position
		if(runnerCell == null) {
			return false;
		}
		return runnerCell.isObstacle() || runnerCell.isNonObstacle() || runnerCell instanceof CheckPoint;
	}

	private void runnerGiftInteraction() {
		// runner gift interaction logic will be here
		LOGGER.setLevel(Level.CONFIG);
		LOGGER.info("hitting a gift");
		PlayingController.collectedGift++;
		IGift gift = (IGift) runnerCell;
		int giftType = gift.getGiftType();
	
		if (giftType == GameContract.GiftsTypes.HEALTH) {
			if (runner.getHealth() + gift.getGivenHealth() <= 100) {
				runner.setHealth(runner.getHealth() + gift.getGivenHealth());
			} else {
				runner.setHealth(100);
			}
			
		} else if (giftType == GameContract.GiftsTypes.COIN) {
			PlayingController.score += gift.getScore();
			System.out.println(PlayingController.score);
		} else if (giftType == GameContract.GiftsTypes.WEAPON) {
			String weaponName = gift.getWeaponClass().getSimpleName();
		
			Weapon weapon;
			if ((weapon = runner.hasWeapon(weaponName)) == null) {
				addWeaponToRunner(weaponName, gift.getBulletsNumber(), gift.getOneBulletDamage());
				LOGGER.setLevel(Level.CONFIG);
				LOGGER.info("get new weapon");
			} else {
				weapon.setFullAmmo();
			}
		
		} else if (giftType == GameContract.GiftsTypes.BULLETS) {
			runner.getCurrentWeapon().setFullAmmo();
		}
		map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
		buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
		
	}

	private void runnerBombInteraction() {
		// runner bomb interaction will be here
		LOGGER.setLevel(Level.CONFIG);
		LOGGER.info("hitting a bomb");
		IBombs bomb = (IBombs) runnerCell;
		int bombType = bomb.getBombType();
		if (bombType == GameContract.BombsTypes.DECREASES_HEALTH) {
			runner.setHealth(runner.getHealth() - bomb.getBombDamage());
		
		} else if (bombType == GameContract.BombsTypes.DECREASES_SCORE) {
			PlayingController.score -= bomb.getBombScore();
		
		}
		map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
		buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
	}

	private void performAction(String action) throws InstantiationException, IllegalAccessException {
		// perform specific action based on its name
		if (action.equals("BombAction")) {
			runnerBombInteraction();
		} else if (action.equals("GiftAction")) {
			runnerGiftInteraction();
		} else if (action.equals("CheckPointAction")) {
			checkPointAction();
		}
	}

	public void checkPointAction() throws IllegalAccessException, InstantiationException {
		((CheckPoint) runnerCell).takeSnapShot(map, (Runner) runner);
	}

	private String getAction() {
		// return the name of action
		if (runnerCell.isObstacle()) {
			return "BombAction";
		} else if (runnerCell.isNonObstacle()) {
			return "GiftAction";
		} else if (runnerCell instanceof CheckPoint) {
			return "CheckPointAction";
		}
		return null;
	}

	private void addWeaponToRunner(String weaponName, int bulletsNumber, int oneBulletDamage) {
		if (weaponName.equals("Pistol")) {
			runner = new WithPistol(runner, bulletsNumber, oneBulletDamage);
			
		} else if (weaponName.equals("AK")) {
			runner = new WithAK(runner, bulletsNumber, oneBulletDamage);
		
		} else if (weaponName.equals("A4")) {
			runner = new WithA4(runner, bulletsNumber, oneBulletDamage);
			
		} else if (weaponName.equals("spaceGun1")) {
			runner = new WithSpaceGun1(runner, bulletsNumber, oneBulletDamage);
		
		} else if (weaponName.equals("spaceGun2")) {
			runner = new WithSpaceGun2(runner, bulletsNumber, oneBulletDamage);
			
		} else if (weaponName.equals("spaceGun3")) {
			runner = new WithSpaceGun3(runner, bulletsNumber, oneBulletDamage);
		
		} /*else if (weaponName.equals("CHGun1")) {
			runner = new WithCHGun1(runner, bulletsNumber, oneBulletDamage);
			
		} else if (weaponName.equals("CHGun2")) {
			runner = new WithCHGun2(runner, bulletsNumber, oneBulletDamage);
		
		} else if (weaponName.equals("CHGun3")) {
			runner = new WithCHGun3(runner, bulletsNumber, oneBulletDamage);

		}*/
	}
	private boolean ifWin(){
		Point runnerPosition = runner.getMappedPosition();
		Point endPoint = map.getEndPoint();
		if(runnerPosition.x == endPoint.x && runnerPosition.y == endPoint.y){
			return true;
		}
		return false;
	}

}