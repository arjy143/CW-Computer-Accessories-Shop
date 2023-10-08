import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class payPal extends payment{

	public payPal(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity,
			int quantity, float origCost, float retailPrice, String additional) {
		super(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
		// TODO Auto-generated constructor stub
	}

	//updates PayPal pay screen when items are purchased
	public static void updateScreenPayPal(JLabel lblTotalAmountPP, JLabel lblPayPalDesc, JTable tblUser,
			JTable tblBasket, JButton btnPayPalPay, DefaultTableModel dtmBasket, ArrayList<userAccount> accountList) {
		lblTotalAmountPP.setText("");
		String username = tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString();
		lblPayPalDesc.setText(payPal.returnTotalAmount(tblBasket)+" paid using PayPal, and the delivery address is "+userAccount.returnAddress(accountList, username) +".");
		btnPayPalPay.setVisible(false);
		while(dtmBasket.getRowCount() > 0)
		{
		    dtmBasket.removeRow(0);
		}		
	}

}
