import java.io.*;
import java.util.ArrayList;


public class addToShop extends stockData{

	public addToShop(int barcode, String deviceName, String deviceType, String brand, String colour,
			String connectivity, int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
	}
	
	//checks if barcode is unique
	public static boolean checkIfBarcodeUnique(int barcode, ArrayList<shop> stockList) {
		for (shop stockItem : stockList) {
			if (stockItem.getBarcode() == barcode) {
				return false;
			}
		}
		return true;		
	}
	//checks if all strings match the format
	public static boolean checkString(String deviceType, String brand, String colour, String connectivity, String additional) {
		if (deviceType.matches("[a-zA-Z]+") && brand.matches("[a-zA-Z]+")&&colour.matches("[a-zA-Z]+")&&connectivity.matches("[a-zA-Z]+")&&additional.matches("[a-zA-Z0-9]+")) {
			return true;
		}
		return false;
	}
	//checks if all numeric values match their formats
	public static boolean checkNumbers(int barcode, int quantity, float origCost, float retailPrice) {
		if(String.valueOf(barcode).toString().matches("[0-9]{6}") && String.valueOf(quantity).toString().matches("[0-9]*") && String.valueOf(origCost).toString().matches("[0-9.]*") && String.valueOf(retailPrice).toString().matches("[0-9.]*")) {
			return true;
		}		
		return false;
		
	}
	//returns true of all of the above is true
	public static boolean validateAddToShop(ArrayList<shop> stockList, int barcode, String deviceName, String deviceType, String brand, String colour,
			String connectivity, int quantity, float origCost, float retailPrice, String additional) {
		
		if (addToShop.checkIfBarcodeUnique(barcode, stockList) && addToShop.checkString(deviceType, brand, colour, connectivity, additional) && checkNumbers(barcode, quantity, origCost, retailPrice)) {
			return true;
		}
		return false;
	}
	//only updates once the validation has succeeded
	public static void updateStock(int barcode, String deviceName, String deviceType, String brand, String colour,
			String connectivity, int quantity, float origCost, float retailPrice, String additional) throws IOException {
		FileWriter outputFile = new FileWriter("Stock.txt", true);
		BufferedWriter bw = new BufferedWriter(outputFile);
		PrintWriter out = new PrintWriter(bw);
		//creates a new line and adds the formatted string to it
		bw.newLine();
		out.print(barcode+","+ deviceName+","+ deviceType+","+brand+","+colour+","+connectivity+","+quantity+","+origCost+","+retailPrice+","+additional);
		out.close();
		bw.close();
		
	}
}
