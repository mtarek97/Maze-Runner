package mazeRunner.controller;

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
import mazeRunner.view.mapCellsView.Recources;

import javax.swing.text.html.ImageView;
import java.awt.*;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
	// TODO : implement interactions methods (connect view with model)
	// all data that you will need to perform the task must be in map i sent
	// that map from MovingController
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
		}
		else {
			runnerMappedPositionX = runner.getMappedPosition().x;
			runnerMappedPositionY = runner.getMappedPosition().y;
			System.out.println("mapped position : " + runnerMappedPositionX + " " + runnerMappedPositionY);
			System.out.println("position : " + runner.getPosition().x + " " + runner.getPosition().y);
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
		PlayingController.collectedGift++;
		IGift gift = (IGift) runnerCell;
		int giftType = gift.getGiftType();
		System.out.println("hit with" + gift);
		if (giftType == GameContract.GiftsTypes.HEALTH) {
			if (runner.getHealth() + gift.getGivenHealth() <= 100) {
				runner.setHealth(runner.getHealth() + gift.getGivenHealth());
			} else {
				runner.setHealth(100);
			}
			System.out.println(runner.getHealth());
		} else if (giftType == GameContract.GiftsTypes.COIN) {
			PlayingController.score += gift.getScore();
			System.out.println(PlayingController.score);
		} else if (giftType == GameContract.GiftsTypes.WEAPON) {
			String weaponName = gift.getWeaponClass().getSimpleName();
			System.out.println(weaponName);
			Weapon weapon;
			if ((weapon = runner.hasWeapon(weaponName)) == null) {
				addWeaponToRunner(weaponName, gift.getBulletsNumber(), gift.getOneBulletDamage());
			} else {
				weapon.setFullAmmo();
			}
			System.out.println(runner.getSupportedWeapons());

		} else if (giftType == GameContract.GiftsTypes.BULLETS) {
			// TODO : add bullets to runner current weapon
		}
		map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
		buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
		System.out.println(runnerCell);
	}

	private void runnerBombInteraction() {
		// runner bomb interaction will be here
		System.out.println("hit with" + runnerCell);
		IBombs bomb = (IBombs) runnerCell;
		int bombType = bomb.getBombType();
		if (bombType == GameContract.BombsTypes.DECREASES_HEALTH) {
			runner.setHealth(runner.getHealth() - bomb.getBombDamage());
			System.out.println(runner.getHealth());
		} else if (bombType == GameContract.BombsTypes.DECREASES_SCORE) {
			PlayingController.score -= bomb.getBombScore();
			System.out.println(PlayingController.score);
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
			System.out.println("decorator with Pistol");
		} else if (weaponName.equals("AK")) {
			runner = new WithAK(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with AK");
		} else if (weaponName.equals("A4")) {
			runner = new WithA4(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with A4");
		} else if (weaponName.equals("spaceGun1")) {
			runner = new WithSpaceGun1(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with spaceGun1");
		} else if (weaponName.equals("spaceGun2")) {
			runner = new WithSpaceGun2(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with spaceGun2");
		} else if (weaponName.equals("spaceGun3")) {
			runner = new WithSpaceGun3(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with spaceGun3");
		} /*else if (weaponName.equals("CHGun1")) {
			runner = new WithCHGun1(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with CHGun1");
		} else if (weaponName.equals("CHGun2")) {
			runner = new WithCHGun2(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with CHGun2");
		} else if (weaponName.equals("CHGun3")) {
			runner = new WithCHGun3(runner, bulletsNumber, oneBulletDamage);
			System.out.println("decorator with CHGun3");
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