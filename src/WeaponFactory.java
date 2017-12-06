
public class WeaponFactory {
	
	public Weapon getWeaponType(String type, Cell cell) {
		Weapon weapon = null;
		int damage = 1;
		switch (type) {
		case "M":
			
			weapon = new Missile(cell, damage);
			break;
		case "D":
			weapon = new DiagonalMissile(cell, damage);
			break;
		case "A":
			weapon = new AllNeighbourMissile(cell, damage);
			break;
		default:
			break;
		}
		return weapon;
	}
}
