package mazeRunner.model.movingObjects;

public class Gun implements Weapon{

	private int ammo;
	private int bulletsCount;
	

	public Gun(int ammo){
		this.ammo = ammo;
		this.bulletsCount = ammo;
	}

	@Override
	public int getAmmo() {
		return ammo;
	}

	@Override
	public int getBulletsCount() {
		return bulletsCount;
	}

	@Override
	public void shoot() {
		bulletsCount--;
	}
	
	



}
