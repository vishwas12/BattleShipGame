import java.util.ArrayList;
import java.util.List;

public class Player implements Subject{
	
	private boolean won;
	private List<Weapon> weapon;
	private String name;
	private Board board;
	private int weaponCount = 0;
	public int missileNumber = 0;
	private List<MyObserver> observers; 
	
	public Player() {
		observers = new ArrayList<MyObserver>();
	}

	public int getWeaponCount() {
		return weaponCount;
	}
	
	public void setWeaponCount(int weaponCount) {
		this.weaponCount = weaponCount;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public List<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(List<Weapon> weapon) {
		this.weapon = weapon;
		this.weaponCount = weapon.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void attack() {
			if(!isWon()) {
				missileNumber++;
				this.weaponCount--;
				notifyAllObservers();
			}
	}
	
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Player.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Player other = (Player) obj;
	    if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
	        return false;
	    }
	    
	    return true;
	}

	@Override
	public void addObserver(MyObserver o) {
		observers.add(o);
	}

	@Override
	public void notifyAllObservers() {
		for(MyObserver observer : observers){
			observer.update(this);
		}
	}

}
