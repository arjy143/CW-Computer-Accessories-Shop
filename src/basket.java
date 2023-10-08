import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class basket extends stockData{

	public basket(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity,
			int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
		// TODO Auto-generated constructor stub
	}

	public static void addToBasket(JTable tblStock, DefaultTableModel dtmBasket, ArrayList<shop> stockList,
			JTable tblStock2, DefaultTableModel dtmStock, JLabel lblOutOfStock) {
		//gets all relevant details from the table row selected
		int barcode = Integer.parseInt(tblStock.getValueAt(tblStock.getSelectedRow(), 0).toString());
		String deviceName = tblStock.getValueAt(tblStock.getSelectedRow(), 1).toString();
		String deviceType = tblStock.getValueAt(tblStock.getSelectedRow(), 2).toString();
		String brand = tblStock.getValueAt(tblStock.getSelectedRow(), 3).toString();
		String colour = tblStock.getValueAt(tblStock.getSelectedRow(), 4).toString();
		String connectivity = tblStock.getValueAt(tblStock.getSelectedRow(), 5).toString();
		int quantity = Integer.parseInt(tblStock.getValueAt(tblStock.getSelectedRow(), 6).toString());
		float retailPrice = Float.parseFloat(tblStock.getValueAt(tblStock.getSelectedRow(), 7).toString());
		String additional = tblStock.getValueAt(tblStock.getSelectedRow(), 8).toString().trim();
		if (quantity >= 1) {//if quantity>1, decrease by -1 and display new table
			Object[] basketData = new Object[] {barcode, deviceName, deviceType, brand,colour,connectivity,retailPrice,additional};
			dtmBasket.addRow(basketData);
			int index = shop.getIndexByBarcode(barcode, stockList);
			stockList.get(index).setQuantity(quantity-1);
			dtmStock.setRowCount(0);
			tblStock.setModel(dtmStock);
			lblOutOfStock.setText("Item added");
			shop.updateStockTableCustomer(stockList, dtmStock);
		}
		else if (quantity == 0) {//else tell user that it is out of stock
			lblOutOfStock.setText("Out of Stock");
		}		
	}

}
