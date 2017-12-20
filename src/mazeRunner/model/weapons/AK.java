package mazeRunner.model.weapons;

public class AK implements Weapon{
	private int ammo;
	private int bulletsCount;
	private int oneBulletDamage;
	private String imageLink = "";

	public AK(int ammo, int oneBulletDamage){
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
