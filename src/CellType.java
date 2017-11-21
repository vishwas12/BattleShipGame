
public enum CellType {
	P_Type (1),
	Q_Type (2),
	EMPTY (0),
	DESTROYED (-1);
	
	private final int shipType;
	
	CellType(int shipType) {
		this.shipType = shipType;
	}
	
	public int getShipType() {
		return this.shipType;
	}
	
}
