package mazeRunner.model.weapons;

public class AK implements Weapon{
	private int ammo;
	private int bulletsCount;
	private String imageLink ="";

	public AK(int ammo){
		this.ammo = ammo;
		this.bulletsCount = ammo;
	}


	public int getAmmo() {
		return ammo;
	}

	public int getBulletsCount() {
		return bulletsCount;
	}

	@Override
	public void shoot() {
		bulletsCount--;
	}


	@Override
	public String getImageLink() {
		return imageLink;
	}
	
	
}
