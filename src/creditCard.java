import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class creditCard extends payment{
	
	public creditCard(int barcode, String deviceName, String deviceType, String brand, String colour,
			String connectivity, int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
		// TODO Auto-generated constructor stub
	}
	
	public static void updateScreenCreditCard(JLabel lblTotalAmountCC, JLabel lblCreditCardDesc, JTable tblUser,
			JTable tblBasket, JButton btnCreditCardPay, DefaultTableModel dtmBasket,
			ArrayList<userAccount> accountList) {
		//changes labels to show that item has been paid
		lblTotalAmountCC.setText("");
		lblCreditCardDesc.setText("Amount paid by user");
		//hides pay button 
		btnCreditCardPay.setVisible(false);
		//gives confirmation message
		String username = tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString();
		lblCreditCardDesc.setText(creditCard.returnTotalAmount(tblBasket)+" paid using Credit Card, and the delivery address is "+userAccount.returnAddress(accountList, username) +".");
		while(dtmBasket.getRowCount() > 0)
		{
		    dtmBasket.removeRow(0);
		}		
	}

}
