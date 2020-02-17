package pattern.strategy;

public class GameCharacter {
	private WeaponInterface weapon;

	public void setWeapon(WeaponInterface weapon) {
		this.weapon = weapon;
	}

	public void attack() {
		if (weapon == null) {
			System.out.println("맨손 공격");
			return;
		}
		weapon.doAttack();
	}
}
