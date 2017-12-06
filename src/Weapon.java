import java.util.List;

public abstract class Weapon {
	CellType weaponType;
	Cell targetCell;
	int damage;
	
	public abstract List<Cell> getEffectingCells(Cell cell, Board board);
}
