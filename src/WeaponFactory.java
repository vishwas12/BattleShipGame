
public class WeaponFactory {
	
	public Weapon getWeaponType(String type, Cell cell) {
		Weapon weapon = null;
		switch (type) {
		case "M":
			int damage = 2;
			weapon = new Missile(cell, damage);
			break;

		default:
			break;
		}
		return weapon;
	}
}
