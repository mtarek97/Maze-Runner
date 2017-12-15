package mazeRunner.model.weapons;

public class A4 implements Weapon{
	private int ammo;
	private int bulletsCount;
	private String imageLink = "";

	public A4(int ammo){
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
