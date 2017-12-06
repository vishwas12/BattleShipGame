import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Ship> ships;
	private Cell[][] cells;
	private ShipFactory shipFactory;
	private int width;
	private int height;
	
	public Board(int width, int height) {
		shipFactory = new ShipFactory();
		ships = new ArrayList<Ship>();
		cells = new Cell[width][height];
		initializeCells(width, height);
		this.width = width;
		this.height = height;
	}
	
	private void initializeCells(int width, int height) {
		char yAxix = 'A';
		int xAxis = 1;
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				cells[i][j] = new Cell(xAxis,yAxix);
				xAxis++;
			}
			yAxix++;
		}
	}
	
	public List<Ship> getpShip() {
		return ships;
	}
	public void setpShip(List<Ship> pShip) {
		this.ships = pShip;
	}
	
	public void createShip(List<ShipRequest> request) {
		for(int i=0;i<request.size(); i++) {
			Ship ship = shipFactory.getShip(request.get(i).getShipType());
			ship.createShip(request.get(i).getWidth(), request.get(i).getHeight(), request.get(i).getDeployedCell());
			ships.add(ship);
		}
	}

	public Cell[][] getCells() {
		return cells;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
