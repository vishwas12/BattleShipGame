import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Ship> ships;
	
	private ShipFactory shipFactory;
	
	public Board() {
		shipFactory = new ShipFactory();
		ships = new ArrayList<Ship>();
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
}
