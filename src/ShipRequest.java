public class ShipRequest {
	private CellType shipType;
	private int height;
	private int width;
	private Cell deployedCell;
	
	public CellType getShipType() {
		return shipType;
	}
	public void setShipType(CellType shipType) {
		this.shipType = shipType;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Cell getDeployedCell() {
		return deployedCell;
	}
	public void setDeployedCell(Cell deployedCell) {
		this.deployedCell = deployedCell;
	}
	
}
