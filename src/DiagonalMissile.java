import java.util.ArrayList;
import java.util.List;

public class DiagonalMissile extends Weapon {
	//private Cell targetCell;
	//private int damage;
	
	public DiagonalMissile(Cell cell, int damage) {
		targetCell = cell;
		damage = damage;
		weaponType = CellType.D_MISSILE;
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
		Cell boardCells[][] = board.getCells();
		int xAxis = cell.getX();
		char yAxis = cell.getY();
		if(boardCells[xAxis-1][(yAxis%65)-1] != null) {
			cells.add(boardCells[xAxis-1][yAxis-1]);
		}
		if(boardCells[xAxis+1][(yAxis%65)-1] != null) {
			cells.add(boardCells[xAxis+1][yAxis-1]);		
		}
		if(boardCells[xAxis+1][(yAxis%65)+1] != null) {
			cells.add(boardCells[xAxis+1][yAxis+1]);
		}
		if(boardCells[xAxis-1][(yAxis%65)+1] != null) {
			cells.add(boardCells[xAxis-1][yAxis+1]);
		}

		return cells;
	}
}
