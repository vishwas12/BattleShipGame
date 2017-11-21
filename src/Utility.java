import java.util.ArrayList;
import java.util.List;

public class Utility {
	
	ShipFactory shipFactory;
	WeaponFactory weaponFactory;
	
	public Utility(ShipFactory shipFactory, WeaponFactory weaponFactory) {
		this.shipFactory = shipFactory;
		this.weaponFactory = weaponFactory;
	}
	
	private void createShipRequest(String player[], ShipRequest request1, ShipRequest request2) {
		request1.setWidth(Integer.parseInt(player[1]));
		request1.setHeight(Integer.parseInt(player[2]));
		request2.setWidth(Integer.parseInt(player[1]));
		request2.setHeight(Integer.parseInt(player[2]));
		char a_o[] =  player[3].toCharArray();
		char a_t[] =  player[4].toCharArray();
		Cell cell1 = new Cell(a_o[1]-'0', a_o[0]);
		Cell cell2 = new Cell(a_t[1]-'0', a_t[0]);
		request1.setDeployedCell(cell1);
		request1.setShipType(shipFactory.getShipType(player[0]));
		request2.setDeployedCell(cell2);
		request2.setShipType(shipFactory.getShipType(player[0]));
	}
	
	public void createRequestObject(String []req, List<ShipRequest> shipRequest1, List<ShipRequest> shipRequest2) {
			ShipRequest request1 = new ShipRequest();
			ShipRequest request2 = new ShipRequest();
			createShipRequest(req, request1, request2);
			shipRequest1.add(request1);
			shipRequest2.add(request2);
	}
	
	
	public List<Weapon> getWeaponsForPlayer(String[] missile) {
		List<Weapon> weapons = new ArrayList<>();
		for(int j=0;j<missile.length;j++) {
			char m[] = missile[j].toCharArray();
			Cell m_cell = new Cell(m[1]-'0', m[0]);
			Weapon weapon = weaponFactory.getWeaponType("M", m_cell);
			weapons.add(weapon);
		}
		return weapons;
	}
}
