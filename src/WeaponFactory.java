
public class WeaponFactory {
	
	public Weapon getWeaponType(String type, Cell cell) {
		Weapon weapon = null;
		switch (type) {
		case "M":
			weapon = new Missile(cell);
			break;

		default:
			break;
		}
		return weapon;
	}
}
