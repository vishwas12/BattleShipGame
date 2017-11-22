
public class Missile extends Weapon {
	private Cell targetCell;
	private int damage;
	
	public Missile(Cell cell, int damage) {
		this.targetCell = cell;
		this.damage = damage;
	}

	public Cell getTargetCell() {
		return targetCell;
	}

	public void setTargetCell(Cell targetCell) {
		this.targetCell = targetCell;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
