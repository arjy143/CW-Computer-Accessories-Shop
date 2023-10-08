import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class payment extends stockData{

	public payment(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity,
			int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
	}
	//returns total cost of all items in basket to 2 decimal places
	public static String returnTotalAmount(JTable tblBasket) {
		float sum = 0;
		float retailPrice = 0;
		for (int i = 0; i < tblBasket.getModel().getRowCount(); i++) {
			retailPrice = Float.parseFloat(tblBasket.getValueAt(i, 6).toString());
			sum += retailPrice;
		}
		String sumString = String.format("%.2f", sum);
		return sumString;
	}
	
	//updates stock text file with new ArrayList
	public static void updateStock(ArrayList<shop> stockList) throws IOException {
		File file = new File("stock.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
		FileWriter outputFile = new FileWriter("stock.txt", true);
		BufferedWriter bw = new BufferedWriter(outputFile);
		PrintWriter out = new PrintWriter(bw);	
		for (shop stockItem : stockList) {	
		out.print(stockItem.getBarcode()+","+ stockItem.getDeviceName()+","+ stockItem.getDeviceType()+","+stockItem.getBrand()+","+stockItem.getColour()+","+stockItem.getConnectivity()+","+stockItem.getQuantity()+","+stockItem.getOrigCost()+","+stockItem.getRetailPrice()+","+stockItem.getAdditional());
		bw.newLine();
		
		}
		out.close();
		bw.close();
		
	}
}
