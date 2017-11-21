import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameSimulator {
	
	private static ShipFactory shipFactory = new ShipFactory();
	private static WeaponFactory weaponFactory = new WeaponFactory();
	public static List<ShipRequest> shipRequest1 = new ArrayList<ShipRequest>();
	public static List<ShipRequest> shipRequest2 = new ArrayList<ShipRequest>();

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int width = 0;
		char height = 0;
		int number;
		String playerOneMissile[];
		String playerTwoMissile[];
		System.out.println("Please enter all the details");
		
		while(true){
			String dimension = br.readLine();
			String dimArr[] = dimension.split(" ");
			width = Integer.valueOf(dimArr[0]);
			height = dimArr[1].charAt(0);
			if((width>0 && width<10) && (height >= 65 && height <= 90))
				break;
			else
				System.out.println("wrong input..Please enter again.");
		}
		
		while(true) {
			number = Integer.parseInt(br.readLine());
			if(number >0 && number <= (width * (height%65 +1)))
				break;
			else
				System.out.println("Too many Ships...");
		}
		
		for(int i=0;i<number;i++){
			String r = "";
			while(true) {
				r = br.readLine();
				String req[] = r.split(" ");
				if(isValidInput(req, width, height)){
					createRequestObject(req);
					break;
				}
				else
					System.out.println("Invalid input");
			}
			
		}
		
		while(true) {
			String p_o_m = br.readLine();
			String p_t_m = br.readLine();
			playerOneMissile = p_o_m.split(" ");
			playerTwoMissile = p_t_m.split(" ");
			break;
		}
		
		Player player1 = new Player();
		Player player2 = new Player();
		Board board1 = new Board();
		Board board2 = new Board();
		board1.createShip(shipRequest1);
		board2.createShip(shipRequest2);
		
		player1.setName("Player-1");
		player2.setName("Player-2");
		player1.setBoard(board1);
		player2.setBoard(board2);
		player1.setWeapon(getWeaponsForPlayer(playerOneMissile));
		player2.setWeapon(getWeaponsForPlayer(playerTwoMissile));
		List<Subject> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		Game game = new Game(list);
		
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		
		game.start();
	}
	
	public static boolean isValidInput(String arr[], int width, int height) {
		if(arr.length!=5)
			return false;
		char []ship1Coordinate = arr[3].toCharArray();
		char []ship2Coordinate = arr[4].toCharArray();
		if((!"P".equals(arr[0]) || !"Q".equals(arr[0])) && Integer.valueOf(arr[1])>width && Integer.valueOf(arr[2])>height) {
			return false;
		}
		if(!validateCoordinates(ship1Coordinate,width,height) && !validateCoordinates(ship2Coordinate,width,height))
			return false;
		
		return true;
	}
	
	public static void createShipRequest(String player[], ShipRequest request1, ShipRequest request2) {
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
	
	public static void createRequestObject(String []req) {
			ShipRequest request1 = new ShipRequest();
			ShipRequest request2 = new ShipRequest();
			createShipRequest(req, request1, request2);
			shipRequest1.add(request1);
			shipRequest2.add(request2);
	}
	
	
	public static List<Weapon> getWeaponsForPlayer(String[] missile) {
		List<Weapon> weapons = new ArrayList<>();
		for(int j=0;j<missile.length;j++) {
			char m[] = missile[j].toCharArray();
			Cell m_cell = new Cell(m[1]-'0', m[0]);
			Weapon weapon = weaponFactory.getWeaponType("M", m_cell);
			weapons.add(weapon);
		}
		return weapons;
	}
	
	public static boolean validateCoordinates(char[] arr, int width, int height) {
		if(arr[0]>height || arr[1]>width)
			return false;
		return true;
	}

}
