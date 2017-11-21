import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameSimulator {
	
	public static List<ShipRequest> shipRequest1 = new ArrayList<ShipRequest>();
	public static List<ShipRequest> shipRequest2 = new ArrayList<ShipRequest>();

	public static void main(String[] args)throws IOException {
		
		ShipFactory shipFactory = new ShipFactory();
		WeaponFactory weaponFactory = new WeaponFactory();
		
		Utility utility = new Utility(shipFactory, weaponFactory);
		
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
				//if(isValidInput(req, width, height)){
					utility.createRequestObject(req, shipRequest1, shipRequest2);
					break;
				//}
				//else
					//System.out.println("Invalid input");
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
		player1.setWeapon(utility.getWeaponsForPlayer(playerOneMissile));
		player2.setWeapon(utility.getWeaponsForPlayer(playerTwoMissile));
		List<Subject> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		Game game = new Game(list);
		
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		
		game.start();
	}
}
