
public class Cell {
	int x;
	char y;
	int health;
	
	public Cell(int x, char y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public char getY() {
		return y;
	}

	public void setY(char y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
