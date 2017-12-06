import java.util.List;

public abstract class Ship {
	
	protected List<Cell> activeCells;
	protected List<Cell> inactiveCells;
	
	public abstract void createShip(int width, int height, Cell cell);
	
	public abstract boolean damage(int damage, List<Cell> effectingCells);
	
	public final char getNextYCell(char x, int index) {
		return (char)(x+index);
	}
	
	public final int getNextXCell(int x, int index) {
		return x+index;
	}
	
	public final boolean isCellAlreadyMarked(Cell c_cell, List<Cell> cells) {
		for(Cell cell: cells){
			if(cell.getX() == c_cell.getX() && cell.getY() == c_cell.getY()){
				return true;
			}
		}
		return false;
	}

}
