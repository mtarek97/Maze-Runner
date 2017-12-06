package mazeRunner.model.runner;

public class Gun implements IGun{

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
