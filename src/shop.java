import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class shop extends stockData{
	
	
	public shop(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity,
			int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
	}

	//puts data in text file in ArrayList
	public static void stockToArrayList(ArrayList<shop> stockList) throws IOException, ParseException{
		stockList.clear();
		FileReader inputFile = new FileReader("Stock.txt");
		BufferedReader br = new BufferedReader(inputFile);
		
		for (String line; (line = br.readLine()) != null;) {
			String[] stockLine = line.split(",");
			int barcode = Integer.parseInt(stockLine[0].trim());
			String deviceName = stockLine[1].trim();
			String deviceType = stockLine[2].trim();
			String brand = stockLine[3].trim();
			String colour = stockLine[4].trim();
			String connectivity = stockLine[5].trim();
			int quantity = Integer.parseInt(stockLine[6].trim());
			float origCost = Float.parseFloat(stockLine[7].trim());
			float retailPrice = Float.parseFloat(stockLine[8].trim());
			String additional = stockLine[9].trim();
			shop itemDet = new shop(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
			stockList.add(itemDet);			
		}				
		br.close();
	}
	
	//gets index of row in ArrayList based on barcode
	public static int getIndexByBarcode(int bcode, ArrayList<shop> stockList) {
		int i = 0;
        for (shop stockItem : stockList) {
            if (stockItem !=null && stockItem.getBarcode() == bcode) {
                return i;
            }
            i += 1;
        }
        return -1;// not there in list
    }
	
	//updates stock table if user is customer
	public static void updateStockTableCustomer(ArrayList<shop> stockList, DefaultTableModel dtmStock) {
		dtmStock.setRowCount(0);
		for (shop stockItem : stockList) {
			Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getRetailPrice(),stockItem.getAdditional()};
			dtmStock.addRow(stockData);
		}

	}
	//updates stock table if user is admin
	public static void updateStockTableAdmin(ArrayList<shop> stockList, DefaultTableModel dtmStock) {
		dtmStock.setRowCount(0);
		for (shop stockItem : stockList) {
			Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getOrigCost(), stockItem.getRetailPrice(),stockItem.getAdditional()};
			dtmStock.addRow(stockData);
		}

	}

	//dictates how the table is sorted if the user is admin
	public static void returnSortedStockAdmin(String brandName, int buttonAmount, ArrayList<shop> stockList, DefaultTableModel dtmStock) throws NumberFormatException {
		//if the brand box is empty and the button box is not
		if (brandName.isEmpty() && buttonAmount != 0) {
			dtmStock.setRowCount(0);
			for (shop stockItem : stockList) {
				int stockButtonAmount = Integer.parseInt(stockItem.getAdditional().replaceAll("[^0-9]","0"));
				if ( buttonAmount == stockButtonAmount) {
					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getOrigCost(), stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}
		//if the button box is empty and the brand box is not
		else if (buttonAmount == 0) {
			dtmStock.setRowCount(0);
			for (shop stockItem : stockList) {
				String stockBrandName = stockItem.getBrand().toLowerCase();

				if (brandName.equals(stockBrandName)) {
					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getOrigCost(), stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}
		else{
			//if both boxes are used
			dtmStock.setRowCount(0);

			for (shop stockItem : stockList) {

				String stockBrandName = stockItem.getBrand().toLowerCase();
				int stockButtonAmount = Integer.parseInt(stockItem.getAdditional().replaceAll("[^0-9]","0"));

				if ( buttonAmount == stockButtonAmount && brandName.equals(stockBrandName)) {

					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getOrigCost(), stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}
	}

	//dictates how the table is sorted if the user is customer
	public static void returnSortedStockCustomer(String brandName, int buttonAmount, ArrayList<shop> stockList, DefaultTableModel dtmStock) throws NumberFormatException{
		if (brandName.isEmpty() && buttonAmount != 0) {
			dtmStock.setRowCount(0);
			for (shop stockItem : stockList) {
				int stockButtonAmount = Integer.parseInt(stockItem.getAdditional().replaceAll("[^0-9]","0"));
				if ( buttonAmount == stockButtonAmount) {
					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(), stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}
		else if (buttonAmount == 0) {
			dtmStock.setRowCount(0);
			for (shop stockItem : stockList) {
				String stockBrandName = stockItem.getBrand().toLowerCase();
				if (brandName.equals(stockBrandName)) {
					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(), stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}
		else {
			dtmStock.setRowCount(0);
			for (shop stockItem : stockList) {
				String stockBrandName = stockItem.getBrand().toLowerCase();
				int stockButtonAmount = Integer.parseInt(stockItem.getAdditional().replaceAll("[^0-9]","0"));
				if ( buttonAmount== stockButtonAmount && brandName.equals(stockBrandName)) {
					Object[] stockData = new Object[] {stockItem.getBarcode(), stockItem.getDeviceName(), stockItem.getDeviceType(), stockItem.getBrand(),stockItem.getColour(),stockItem.getConnectivity(), stockItem.getQuantity(),stockItem.getRetailPrice(),stockItem.getAdditional()};
					dtmStock.addRow(stockData);
				}
			}	
		}		
	}
	
	
}
