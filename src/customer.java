import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class customer extends userAccount{

	public customer(int id, String username, String name, int houseNum, String postcode, String city, String access) {
		super(id, username, name, houseNum, postcode, city, access);
		// TODO Auto-generated constructor stub
	}

	//changes the enabled status of the tabs based on the admin access level
	public static void returnCustomerAccess(JTabbedPane tabbedPane, JButton btnAddToBasket, DefaultTableModel dtmStock,
			JTable tblStock) {
		tabbedPane.setEnabledAt(0,false);
		tabbedPane.setEnabledAt(1,true);
		tabbedPane.setEnabledAt(2,true);
		btnAddToBasket.setVisible(true);
		dtmStock.setColumnIdentifiers(new Object[] {"Barcode","Device Name", "Device Type", "Brand", "Colour", "Connectivity", "Quantity", "Price", "Additional Info"});
		dtmStock.setRowCount(0);
		tblStock.setModel(dtmStock);		
	}
	
	//changes the label to give a personalised greeting
	public static void returnCustomerGreeting(String username, ArrayList<userAccount> accountList, JLabel lblShop) {
		String name = null;
		for (userAccount account : accountList) {
			if (account.getUsername() == username) {
				name = account.getName();
			}
		
		}
		lblShop.setText("Welcome to the Computer Accessories Store, "+name+"(Customer)");
	}


}
