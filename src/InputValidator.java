
public class InputValidator {
	
	public boolean isValidInput(String arr[], int width, int height) {
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
	
	public boolean validateCoordinates(char[] arr, int width, int height) {
		if(arr[0]>height || arr[1]>width)
			return false;
		return true;
	}
}
