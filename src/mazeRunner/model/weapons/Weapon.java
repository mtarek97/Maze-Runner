package mazeRunner.model.weapons;

public interface Weapon {

	public String getImageLink();
	
	public void shoot();
	
	public int getOneBulletDamage();	
	
	public void setFullAmmo();
	
	public int getBulletsCount();
}
