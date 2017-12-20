package mazeRunner.controller;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.*;
import mazeRunner.model.movingObjects.runners.*;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
	// TODO : implement interactions methods (connect view with model)
	// all data that you will need to perform the task must be in map i sent that map from MovingController
	Map map;
	IRunner runner;
	MapCell runnerCell;
	int runnerMappedPositionX;
	int runnerMappedPositionY;
	BuildingController buildingController;
	public RunnerInteractions(BuildingController buildingController, Map map){
		this.buildingController = buildingController;
		this.map = map;
		this.runner = map.getRunner();

	}

	public void update() throws IllegalAccessException, InstantiationException {
		runnerMappedPositionX = runner.getMappedPosition().x;
		runnerMappedPositionY = runner.getMappedPosition().y;
		System.out.println("mapped position : " + runnerMappedPositionX + " "+ runnerMappedPositionY);
		System.out.println("position : " + runner.getPosition().x +" "+  runner.getPosition().y);
		runnerCell = map.getCellsLayer()[runnerMappedPositionX][runnerMappedPositionY];
		if(isThereAnAction()){
			performAction(getAction());
		}
	}

	private boolean isThereAnAction(){
		//get current runner mapped position and see if there is any thing in that position
		return runnerCell.isObstacle() || runnerCell.isNonObstacle() || runner instanceof CheckPoint;
	}

	private void runnerGiftInteraction(){
		//runner gift interaction logic will be here
		IGift gift = (IGift) runnerCell;
		int giftType = gift.getGiftType();
		System.out.println("hit with" + gift);
		if(giftType == GameContract.GiftsTypes.HEALTH && runner.getHealth() < 100 ){
			runner.setHealth(runner.getHealth() + gift.getGivenHealth());
			System.out.println(runner.getHealth());
		}else if(giftType == GameContract.GiftsTypes.COIN){
			PlayingController.score += gift.getScore();
			System.out.println(PlayingController.score);
		}else if(giftType == GameContract.GiftsTypes.WEAPON){
			String weaponName = gift.getWeaponClass().getSimpleName();
			System.out.println(weaponName);
			Weapon weapon;
			if((weapon = runner.hasWeapon(weaponName)) == null) {
				if(weaponName.equals("Pistol")){
					runner = new WithPistol(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with Pistol");
				}else if(weaponName.equals("AK")){
					runner = new WithAK(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with AK");
				}else if(weaponName.equals("A4")){
					runner = new WithA4(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with A4");
				}
			}else{
				weapon.setFullAmmo();
			}
			System.out.println(runner.getSupportedWeapons());

		}else if(giftType == GameContract.GiftsTypes.BULLETS){
			// TODO : add bullets to runner current weapon
		}
		map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
		buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
		System.out.println(runnerCell);
	}

	private void runnerBombInteraction(){
		//runner bomb interaction will be here
		System.out.println("hit with" + runnerCell);
		runner.setHealth(runner.getHealth() - runnerCell.getDamage());
		System.out.println(runner.getHealth());
	}


	private void performAction(String action) throws InstantiationException, IllegalAccessException {
		//perform specific action based on its name
		if(action.equals( "BombAction") ){
			runnerBombInteraction();
		}else if(action.equals( "GiftAction") ){
			runnerGiftInteraction();
		}
		else if(action.equals("CheckPointAction")) {
			checkPointAction();
		}

	}

	public void checkPointAction() throws IllegalAccessException, InstantiationException {
		((CheckPoint)runnerCell).takeSnapShot(map, (Runner) runner);
	}

	private String getAction(){
		// return the name of action
		if(runnerCell.isObstacle()){
			return "BombAction";
		}else if(runnerCell.isNonObstacle()){
			return "GiftAction";
		}
		else if(runnerCell instanceof CheckPoint) {
			return "CheckPointAction";
		}
		return null;
	}

}
