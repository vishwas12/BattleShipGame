
public class ShipFactory {
	
	public Ship getShip(CellType type) {
		Ship ship = null;
		
		switch (type) {
		case P_Type:
			ship = new PShip();
			break;
			
		case Q_Type:
			ship = new QShip();
			break;

		default:
			break;
		}
		
		return ship;
	}
	
	public CellType getShipType(String type) {
		CellType cellType = null;
		switch(type) {
		case "P":
			cellType =  CellType.P_Type;
			break;
		case "Q":
			cellType = CellType.Q_Type;
			break;
		}
		return cellType;
	}
}
