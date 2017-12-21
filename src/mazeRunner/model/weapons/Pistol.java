package mazeRunner.model.weapons;

public class Pistol implements Weapon{

	private int ammo;
	private int bulletsCount;
	private int oneBulletDamage;
	private String imageLink = "images/pistol.jpg";

	public Pistol(int ammo, int oneBulletDamage){
		this.ammo = ammo;
		this.bulletsCount = ammo;
		this.oneBulletDamage = oneBulletDamage;
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
	
	@Override
	public int getOneBulletDamage() {
		return oneBulletDamage;
	}


	@Override
	public void setFullAmmo() {
		bulletsCount = ammo;
	}	
	
}
