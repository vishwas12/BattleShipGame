import java.util.ArrayList;
import java.util.List;

public class QShip extends Ship {
	
	public QShip() {
		activeCells = new ArrayList<Cell>();
		inactiveCells = new ArrayList<Cell>();
	}
	
	@Override
	public void createShip(int width, int height, Cell deployedCell) {
		for(int i=0;i<width;i++){
			int xCell = getNextXCell(deployedCell.getX(), i);
			Cell cell = new Cell(xCell, deployedCell.getY());
			if(!isCellAlreadyMarked(cell, activeCells)){
				cell.setHealth(2);
				activeCells.add(cell);
			}
		}
		for(int i=0;i<height;i++){
			char ycell = getNextYCell(deployedCell.getY(), i);
			Cell cell = new Cell(deployedCell.getX(), ycell);
			if(!isCellAlreadyMarked(cell, activeCells)){
				cell.setHealth(2);
				activeCells.add(cell);
			}
		}
	}
	
	@Override
	public boolean damage(int damage, List<Cell> effectingCells) {
		boolean isHit = false;
		/*for(int i=0;i<activeCells.size();i++) {
			Cell cell = activeCells.get(i);
			if(x == cell.x && y == cell.y && cell.getHealth()>0){
				cell.setHealth(cell.getHealth()-damage);
				activeCells.remove(i);
				inactiveCells.add(cell);
				return true;
			}
		}*/
		for(int i=0;i<effectingCells.size();i++) {
			for(int j=0;j<activeCells.size();j++) {
				if(effectingCells.get(i).getX() == activeCells.get(j).getX()
						&& effectingCells.get(i).getY() == activeCells.get(j).getY() && activeCells.get(j).health > 0) {
					activeCells.get(j).setHealth(activeCells.get(j).getHealth() - damage);
					inactiveCells.add(activeCells.get(j));
					activeCells.remove(j);
					isHit = true;
				}
			}
		}
		return isHit;
	}
}
