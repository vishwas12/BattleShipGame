import java.util.ArrayList;
import java.util.List;

public class Missile extends Weapon {
	//private Cell targetCell;
	//private int damage;
	
	public Missile(Cell cell, int damage) {
		targetCell = cell;
		damage = damage;
		weaponType = CellType.N_MISSILE;
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
	
	@Override
	public List<Cell> getEffectingCells(Cell cell, Board board) {
		List<Cell> cells = new ArrayList<Cell>();
		cells.add(targetCell);
		return cells;
	}
	
}
