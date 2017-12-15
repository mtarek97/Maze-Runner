package mazeRunner.model.movingObjects.runners;

import java.awt.Point;
import java.util.List;

import mazeRunner.model.weapons.Weapon;

public  class RunnerDecorator implements IRunner{

	protected final IRunner decoratedRunner;
	
	public RunnerDecorator(IRunner runner){
		this.decoratedRunner = runner;
	}
	
	@Override
	public void setSpeed(int speed) {
		decoratedRunner.setSpeed(speed);
		
	}

	@Override
	public int getSpeed() {
		return decoratedRunner.getSpeed();
	}

	@Override
	public void moveUp() {
		decoratedRunner.moveUp();
	}

	@Override
	public void moveDown() {
		decoratedRunner.moveDown();
		
	}

	@Override
	public void moveRight() {
		decoratedRunner.moveDown();
		
	}

	@Override
	public void moveLeft() {
		decoratedRunner.moveLeft();
		
	}

	@Override
	public void setDirection(int direction) {
		decoratedRunner.setDirection(direction);
		
	}

	@Override
	public int getDirection() {
		return decoratedRunner.getDirection();
	}

	@Override
	public void SetPosition(Point position) {
		decoratedRunner.SetPosition(position);
		
	}

	@Override
	public Point getPosition() {
		return decoratedRunner.getPosition();
	}

	@Override
	public void setImageLinks(String[] imageLinks) {
		decoratedRunner.setImageLinks(imageLinks);
		
	}

	@Override
	public String getImageLink() {
		return decoratedRunner.getImageLink();
	}

	@Override
	public void setMappedPosition(Point mappedPosition) {
		decoratedRunner.setMappedPosition(mappedPosition);
		
	}

	@Override
	public Point getMappedPosition() {
		return decoratedRunner.getMappedPosition();
	}

	@Override
	public void setHealth(int health) {
		decoratedRunner.setHealth(health);
		
	}

	@Override
	public int getHealth() {
		return decoratedRunner.getHealth();
	}

	@Override
	public List<Weapon> getSupportedWeapons() {
		return decoratedRunner.getSupportedWeapons();
	}

	@Override
	public void setSupportedWeapons(List<Weapon> supportedWeapons) {
		decoratedRunner.setSupportedWeapons(supportedWeapons);
		
	}
	
}
