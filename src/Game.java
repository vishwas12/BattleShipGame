import java.util.List;

public class Game implements MyObserver {
	
	private Player player1;
	private Player player2;
	List<Subject> subjects;
	
	private boolean player1chance = true;
	private boolean player2chance = false;
	
	private boolean gameEnded;
	
	public Game(List<Subject> subjects) {
		this.subjects = subjects;
		for(Subject o : subjects){
			o.addObserver(this);
		}
	}
	

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}

	public void start() {
		if(!isGameEnded()){
			boolean bothWin = (player1.isWon() && player1.isWon()) ? true : false;
			if((player1.isWon() || player2.isWon()) && !bothWin){
				setGameEnded(true);
				System.out.println((player1.isWon() ? player1.getName() : player2.getName()) + " has won the game");
			}else if(bothWin) {
				setGameEnded(true);
				System.out.println("There is peace now");
			}else {
				if(player1chance){
					player1.attack();
				}else if(player2chance){
					player2.attack();
				}
			}
		}
	}

	@Override
	public void update(Player arg) {
			Player passedObj = arg;
			if(player1.equals(passedObj)){
				List<Ship> ships = player2.getBoard().getpShip();
				if((player1.getWeaponCount()+1) < 1){
					System.out.println(player1.getName()+" has no more missiles left to launch");
					giveChanceToOtherPlayer(false,true);
				}
				if(!isGameEnded()){
					if(updateShipHealthAndNotify(ships, player1.getWeapon().get(player1.missileNumber-1),player2)){
						player1chance = true;
						Weapon missile = player1.getWeapon().get(player1.missileNumber-1);
						System.out.println(player1.getName()+" fires a missile with target "+missile.targetCell.getY()+missile.targetCell.getX()+" which got hit.");
						if(checkIfGameEnded(player2)){
							player1.setWon(true);
						}
						start();
					}else {
						player1chance = false;
						player2chance = true;
						Weapon missile = player1.getWeapon().get(player1.missileNumber-1);
						System.out.println(player1.getName()+" fires a missile with target "+missile.targetCell.getY()+missile.targetCell.getX()+" which got miss.");
						if(checkIfGameEnded(player2)){
							player1.setWon(true);
						}
						start();
					}
				}
			}else if(player2.equals(passedObj)) {
				List<Ship> ships = player1.getBoard().getpShip();
				if((player2.getWeaponCount()+1) < 1){
					System.out.println(player2.getName()+" has no more missiles left to launch");
					giveChanceToOtherPlayer(true,false);
				}
				if(!isGameEnded()) {
					if(updateShipHealthAndNotify(ships, player2.getWeapon().get(player2.missileNumber-1),player1)){
						player2chance = true;
						Weapon missile = player2.getWeapon().get(player2.missileNumber-1);
						System.out.println(player2.getName()+" fires a missile with target "+missile.targetCell.getY()+missile.targetCell.getX()+" which got hit.");
						if(checkIfGameEnded(player1)){
							player2.setWon(true);
						}
						start();
					}else {
						player2chance = false;
						player1chance = true;
						Weapon missile = player2.getWeapon().get(player2.missileNumber-1);
						System.out.println(player2.getName()+" fires a missile with target "+missile.targetCell.getY()+missile.targetCell.getX()+" which got miss.");
						if(checkIfGameEnded(player1)){
							player2.setWon(true);
						}
						start();
					}
				}
			}
		
	}
	
	private boolean updateShipHealthAndNotify(List<Ship> ships, Weapon missile, Player player) {
		boolean isHit = false;
		for(Ship ship: ships) {
			Cell cell = missile.targetCell;
			List<Cell> effectingCells = missile.getEffectingCells(cell, player.getBoard());
			if(ship.damage(missile.damage, effectingCells))
				return true;
		}
		return isHit;
	}
	
	private void giveChanceToOtherPlayer(boolean firstFlag, boolean secondFlag) {
		player1chance = firstFlag;
		player2chance = secondFlag;
		if((player1.getWeaponCount()+1) < 1 && (player2.getWeaponCount()+1) < 1){
			player1.setWon(true);
			player2.setWon(true);
			player1chance = false;
			player2chance = false;
		}
		start();
	}
	
	private boolean checkIfGameEnded(Player player) {
		List<Ship> ships = player.getBoard().getpShip();
		boolean allDestroyed = true;
		for(Ship ship: ships){
			if(ship.activeCells.size()>0){
				allDestroyed = false;
				break;
			}
		}
		return allDestroyed;
	}
}
