
public class Missile extends Weapon {
	private Cell targetCell;
	
	public Missile(Cell cell) {
		this.targetCell = cell;
	}

	public Cell getTargetCell() {
		return targetCell;
	}

	public void setTargetCell(Cell targetCell) {
		this.targetCell = targetCell;
	}
	
}
