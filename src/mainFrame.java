import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JTable tblUser;
	private DefaultTableModel dtmUser;
	private JTable tblStock;
	private DefaultTableModel dtmStock;
	private JTable tblBasket;
	private DefaultTableModel dtmBasket;
	private final JButton btnCreditCard = new JButton("Card");
	private JTextField brandSort;
	private JTextField buttonSort;
	private JTextField txtBarcode;
	private JTextField txtDeviceType;
	private JTextField txtBrand;
	private JTextField txtColour;
	private JTextField txtOrigPrice;
	private JTextField txtRetailPrice;
	private JTextField txtAdditional;
	private JTextField txtQuantity;
	private JTextField txtPayPal;
	private JTextField txtCardNum;
	private JTextField txtCcv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
			
		EventQueue.invokeLater(new Runnable() {			
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainFrame() throws IOException, ParseException{
		
		ArrayList<userAccount> accountList = new ArrayList<userAccount>();
		userAccount.userAccountToArrayList(accountList);
		ArrayList<shop> stockList = new ArrayList<shop>();
		shop.stockToArrayList(stockList);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 558, 423);
		contentPane.add(tabbedPane);

		
		JPanel Login = new JPanel();
		tabbedPane.addTab("Login", null, Login, null);
		tabbedPane.setEnabledAt(0, true);
		Login.setLayout(null);
				
		JPanel Shop = new JPanel();
		tabbedPane.addTab("Shop", null, Shop, null);
		tabbedPane.setEnabledAt(1, false);
		Shop.setLayout(null);
		
		JPanel Basket = new JPanel();
		tabbedPane.addTab("Basket", null, Basket, null);
		Basket.setLayout(null);
		
		JPanel PayPal = new JPanel();
		tabbedPane.addTab("PayPal", null, PayPal, null);
		PayPal.setLayout(null);
		
		JLabel lblpayPalPay = new JLabel("Enter PayPal address:");
		lblpayPalPay.setBounds(15, 16, 236, 20);
		PayPal.add(lblpayPalPay);
		
		txtPayPal = new JTextField();
		txtPayPal.setText("");
		txtPayPal.setBounds(296, 13, 220, 26);
		PayPal.add(txtPayPal);
		txtPayPal.setColumns(10);
		
		JLabel lblTotalAmountPP = new JLabel("Total Amount:");
		lblTotalAmountPP.setBounds(223, 65, 236, 20);
		PayPal.add(lblTotalAmountPP);
		
		JButton btnCancelPayPal = new JButton("Cancel");
		btnCancelPayPal.setBounds(44, 116, 115, 29);
		PayPal.add(btnCancelPayPal);
		btnCancelPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(3,false);
				tabbedPane.setEnabledAt(2,true);
				tabbedPane.setEnabledAt(1,true);
				tabbedPane.setSelectedIndex(2);

			}
		});
		
		JButton btnPayPalPay = new JButton("Pay");
		btnPayPalPay.setBounds(332, 116, 115, 29);
		PayPal.add(btnPayPalPay);
		
		JLabel lblPayPalDesc = new JLabel("");
		lblPayPalDesc.setBounds(27, 323, 489, 20);
		PayPal.add(lblPayPalDesc);
		tabbedPane.setEnabledAt(3, false);
		
		JPanel CreditCard = new JPanel();
		tabbedPane.addTab("Credit Card", null, CreditCard, null);
		CreditCard.setLayout(null);
		
		JLabel lblEnterdigitCard = new JLabel("Enter 6-digit card number:");
		lblEnterdigitCard.setBounds(15, 16, 228, 20);
		CreditCard.add(lblEnterdigitCard);
		
		JLabel lblCcv = new JLabel("Enter 3-digit CCV:");
		lblCcv.setBounds(15, 57, 162, 20);
		CreditCard.add(lblCcv);
		
		txtCardNum = new JTextField();
		txtCardNum.setBounds(311, 13, 146, 26);
		CreditCard.add(txtCardNum);
		txtCardNum.setColumns(10);
		
		txtCcv = new JTextField();
		txtCcv.setText("");
		txtCcv.setBounds(311, 54, 146, 26);
		CreditCard.add(txtCcv);
		txtCcv.setColumns(10);
		
		JLabel lblTotalAmountCC = new JLabel("Total Amount:");
		lblTotalAmountCC.setBounds(187, 106, 187, 20);
		CreditCard.add(lblTotalAmountCC);
		
		//when cancel pressed, taken back to basket
		JButton btnCancelCreditCard = new JButton("Cancel");
		btnCancelCreditCard.setBounds(15, 151, 115, 29);
		CreditCard.add(btnCancelCreditCard);
		btnCancelCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(4,false);
				tabbedPane.setEnabledAt(2,true);
				tabbedPane.setEnabledAt(1,true);
				tabbedPane.setSelectedIndex(2);

			}
		});
		
		JButton btnCreditCardPay = new JButton("Pay");
		btnCreditCardPay.setBounds(336, 151, 115, 29);
		CreditCard.add(btnCreditCardPay);
		
		JLabel lblCreditCardDesc = new JLabel("");
		lblCreditCardDesc.setBounds(15, 353, 523, 20);
		CreditCard.add(lblCreditCardDesc);
		tabbedPane.setEnabledAt(4, false);
		
		//arrays used for the JComboboxes
		String[] deviceNames = new String[] {"keyboard", "mouse"};
		String[] connections = new String[] {"wired", "wireless"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 100, 553, 92);
		Login.add(scrollPane);
		
		//initialises user account table with data
		tblUser = new JTable();
		scrollPane.setViewportView(tblUser);			
		DefaultTableModel dtmUser = new DefaultTableModel();		
		dtmUser.setColumnIdentifiers(new Object[] {"ID","Username", "Access"});		
		tblUser.setModel(dtmUser);
		for (userAccount account : accountList) {
			Object[] rowData = new Object[] {account.getId(), account.getUsername(), account.getAccess()};
			dtmUser.addRow(rowData);
		}
			
		JLabel lblSelectUserAccount = new JLabel("Select user account from table below:");
		lblSelectUserAccount.setBounds(55, 31, 318, 20);
		Login.add(lblSelectUserAccount);
		
		
		JLabel lblShop = new JLabel("Welcome to the Computer Accessories Store");
		lblShop.setBounds(15, 16, 470, 20);
		Shop.add(lblShop);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(15, 123, 386, 250);
		Shop.add(scrollPane_1);
		
		tblStock = new JTable();
		scrollPane_1.setViewportView(tblStock);	
		tblStock.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblStock.setDefaultEditor(Object.class, null);
		DefaultTableModel dtmStock = new DefaultTableModel();		
		
		JButton btnAddToBasket = new JButton("Add ");
		btnAddToBasket.setToolTipText("Add to basket");		
		btnAddToBasket.setBounds(423, 120, 115, 73);
		Shop.add(btnAddToBasket);
		
		JLabel lblOutOfStock = new JLabel("");
		lblOutOfStock.setBounds(423, 266, 107, 20);
		Shop.add(lblOutOfStock);
		
		JLabel lblSortByBrand = new JLabel("Sort by brand:");
		lblSortByBrand.setBounds(15, 52, 129, 20);
		Shop.add(lblSortByBrand);
		
		JLabel lblSortByMouse = new JLabel("Sort by mouse buttons:");
		lblSortByMouse.setBounds(15, 85, 167, 20);
		Shop.add(lblSortByMouse);
		
		brandSort = new JTextField();
		brandSort.setBounds(206, 52, 146, 26);
		Shop.add(brandSort);
		brandSort.setColumns(10);
		
		buttonSort = new JTextField();
		buttonSort.setBounds(206, 82, 146, 26);
		Shop.add(buttonSort);
		buttonSort.setColumns(10);
		
		/*the following dictates how the program sorts the shop table, depending on what is input
		 * and if any text exists inside the boxes.
		 * */
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException {
				String brandName = brandSort.getText().toLowerCase();
				int buttonAmount = 0;
				if (!buttonSort.getText().isEmpty()) {
					buttonAmount = Integer.parseInt(buttonSort.getText().replaceAll("[^0-9]","0"));
				}
				String access = tblUser.getValueAt(tblUser.getSelectedRow(), 2).toString();

				if (brandName.isEmpty() && buttonAmount == 0) {
					if (access.trim().equals("admin")) {
						shop.updateStockTableAdmin(stockList, dtmStock);
					}
					else {
						shop.updateStockTableCustomer(stockList, dtmStock);
					}
				}
				else {
					if (access.trim().equals("admin")) {
						shop.returnSortedStockAdmin(brandName, buttonAmount, stockList, dtmStock);
					}
					else {
						shop.returnSortedStockCustomer(brandName, buttonAmount, stockList, dtmStock);					
					}
				}
				
			}
		});
		btnSort.setBounds(451, 63, 87, 29);
		Shop.add(btnSort);
		

		
		
		
		
		
		JLabel lblBuyWithPaypal = new JLabel("Buy with PayPal or Credit Card below");
		lblBuyWithPaypal.setBounds(15, 16, 294, 20);
		Basket.add(lblBuyWithPaypal);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(25, 62, 397, 311);
		Basket.add(scrollPane_2);
		
		JLabel lblBasketEmpty = new JLabel("");
		lblBasketEmpty.setBounds(437, 245, 116, 20);
		Basket.add(lblBasketEmpty);
		
		tblBasket = new JTable();
		scrollPane_2.setViewportView(tblBasket);
		tblBasket.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblBasket.setDefaultEditor(Object.class, null);
		DefaultTableModel dtmBasket = new DefaultTableModel();		
		dtmBasket.setColumnIdentifiers(new Object[] {"Barcode","Device Name", "Device Type", "Brand", "Colour", "Connectivity", "Price", "Additional Info"});
		tblBasket.setModel(dtmBasket);
		
		//adds the selected row to the basket. if no row is selected, it tells you to select a row.
		btnAddToBasket.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) throws ArrayIndexOutOfBoundsException{//if button pressed, add selected row to basket
				try {
					basket.addToBasket(tblStock, dtmBasket, stockList, tblStock, dtmStock, lblOutOfStock);	
			}
				catch(ArrayIndexOutOfBoundsException e) {
					lblOutOfStock.setText("Select a row");
				}
			}			
		});
		
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.setToolTipText("Pay by PayPal");
		btnPayPal.setBounds(448, 125, 90, 29);
		Basket.add(btnPayPal);
		
		//if the PayPal button is pressed, it takes you to the relevant tab and updates the information.
		btnPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowCount = tblBasket.getModel().getRowCount(); 
				if (rowCount >= 1) {
					lblBasketEmpty.setText("");
					tabbedPane.setEnabledAt(3,true);
					tabbedPane.setEnabledAt(2,false);
					tabbedPane.setEnabledAt(1,false);
					tabbedPane.setSelectedIndex(3);
					lblTotalAmountPP.setText("Total Amount: "+payPal.returnTotalAmount(tblBasket));
					lblPayPalDesc.setText("");
					btnPayPalPay.setVisible(true);

				}
				else {
					lblBasketEmpty.setText("No items.");
				}
			}
		});
		
		btnPayPalPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String payPalAddress = txtPayPal.getText();
				if (payPalAddress.matches("[a-zA-Z0-9@]+")) {
					try {
						payPal.updateStock(stockList);
						payPal.updateScreenPayPal(lblTotalAmountPP, lblPayPalDesc, tblUser, tblBasket, btnPayPalPay, dtmBasket, accountList);
					} catch (IOException | NullPointerException e) {
						lblPayPalDesc.setText("Please enter details in correct format");
						e.printStackTrace();
					}
				}
				else {
					lblPayPalDesc.setText("Enter a email address with the correct format.");
				}
			}
		});
		
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Remove selected item from basket");
		btnRemove.setBounds(448, 62, 90, 29);
		Basket.add(btnRemove);
		
		//if remove button pressed, it returns the quantity to the shop table and removes all rows from basket
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//if button pressed, remove all rows from basket
				int rowCount = dtmBasket.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
					int barcode = Integer.parseInt(tblBasket.getValueAt(i, 0).toString());
				    dtmBasket.removeRow(i);
					//subsequently add 1 to quantity property of shop table
					int index = shop.getIndexByBarcode(barcode, stockList);
					int quantity = stockList.get(index).getQuantity();
					stockList.get(index).setQuantity(quantity+1);
					dtmStock.setRowCount(0);
					tblStock.setModel(dtmStock);
					lblOutOfStock.setText("");
				}
				shop.updateStockTableCustomer(stockList, dtmStock);
			}
		});
		
		
		btnCreditCard.setToolTipText("Pay by credit card");
		btnCreditCard.setBounds(448, 170, 90, 41);
		Basket.add(btnCreditCard);
		tabbedPane.setEnabledAt(2, false);
		
		//dictates what happens when the credit card option is chosen
		btnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowCount = tblBasket.getModel().getRowCount(); 
				if (rowCount >= 1) {
					lblBasketEmpty.setText("");
					tabbedPane.setEnabledAt(4,true);
					tabbedPane.setEnabledAt(2,false);
					tabbedPane.setEnabledAt(1,false);
					tabbedPane.setSelectedIndex(4);
					lblTotalAmountCC.setText("Total Amount: "+creditCard.returnTotalAmount(tblBasket));
					lblCreditCardDesc.setText("");
					btnCreditCardPay.setVisible(true);

				}
				else {
					lblBasketEmpty.setText("No items.");
				}
			}
		});
		
		btnCreditCardPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cardNum = Integer.parseInt(txtCardNum.getText());
				int CCV = Integer.parseInt(txtCcv.getText());
				if (String.valueOf(cardNum).toString().matches("[0-9]{6}") && String.valueOf(CCV).toString().matches("[0-9]{3}")) {
					try {
						creditCard.updateStock(stockList);	
						creditCard.updateScreenCreditCard(lblTotalAmountCC, lblCreditCardDesc, tblUser, tblBasket, btnCreditCardPay, dtmBasket, accountList);
					} catch (IOException | NullPointerException e) {
						lblCreditCardDesc.setText("Please enter correct details");
						e.printStackTrace();
					}
				}
				else {
					lblCreditCardDesc.setText("Enter a email address with the correct format.");
				}
			}
		});
		
		JPanel AddToShop = new JPanel();
		tabbedPane.addTab("Add to Shop", null, AddToShop, null);
		tabbedPane.setEnabledAt(5, false);
		AddToShop.setLayout(null);
		
		JComboBox cbDeviceName = new JComboBox(deviceNames);
		cbDeviceName.setBounds(225, 16, 146, 26);
		AddToShop.add(cbDeviceName);
		
		
		JLabel lblSelectDeviceType = new JLabel("Select device type:");
		lblSelectDeviceType.setBounds(33, 19, 177, 20);
		AddToShop.add(lblSelectDeviceType);
		
		JLabel lblBarcode = new JLabel("Barcode(6 numbers):");
		lblBarcode.setBounds(33, 55, 162, 20);
		AddToShop.add(lblBarcode);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(225, 52, 146, 26);
		AddToShop.add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JLabel lblDeviceType = new JLabel("Device type:");
		lblDeviceType.setBounds(33, 91, 119, 20);
		AddToShop.add(lblDeviceType);
		
		txtDeviceType = new JTextField();
		txtDeviceType.setBounds(225, 88, 146, 26);
		AddToShop.add(txtDeviceType);
		txtDeviceType.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(33, 127, 69, 20);
		AddToShop.add(lblBrand);
		
		txtBrand = new JTextField();
		txtBrand.setBounds(225, 124, 146, 26);
		AddToShop.add(txtBrand);
		txtBrand.setColumns(10);
		
		JLabel lblColour = new JLabel("Colour:");
		lblColour.setBounds(33, 163, 69, 20);
		AddToShop.add(lblColour);
		
		txtColour = new JTextField();
		txtColour.setBounds(225, 160, 146, 26);
		AddToShop.add(txtColour);
		txtColour.setColumns(10);
		
		JLabel lblConnectivity = new JLabel("Connectivity:");
		lblConnectivity.setBounds(33, 199, 108, 20);
		AddToShop.add(lblConnectivity);
		
		JComboBox cbConnectivity = new JComboBox(connections);
		cbConnectivity.setBounds(225, 190, 146, 32);
		AddToShop.add(cbConnectivity);
		
		JLabel lblOriginalPrice = new JLabel("Original price:");
		lblOriginalPrice.setBounds(33, 270, 119, 20);
		AddToShop.add(lblOriginalPrice);
		
		JLabel lblRetailPrice = new JLabel("Retail price:");
		lblRetailPrice.setBounds(33, 302, 119, 20);
		AddToShop.add(lblRetailPrice);
		
		txtOrigPrice = new JTextField();
		txtOrigPrice.setBounds(225, 267, 146, 26);
		AddToShop.add(txtOrigPrice);
		txtOrigPrice.setColumns(10);
		
		txtRetailPrice = new JTextField();
		txtRetailPrice.setBounds(225, 298, 146, 28);
		AddToShop.add(txtRetailPrice);
		txtRetailPrice.setColumns(10);
		
		JLabel lblAdditionalInfo = new JLabel("Keyboard origin:");
		lblAdditionalInfo.setBounds(33, 336, 137, 20);
		AddToShop.add(lblAdditionalInfo);
		
		txtAdditional = new JTextField();
		txtAdditional.setBounds(225, 333, 146, 26);
		AddToShop.add(txtAdditional);
		txtAdditional.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(33, 234, 69, 20);
		AddToShop.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(225, 235, 146, 26);
		AddToShop.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblAddToShop = new JLabel("");
		lblAddToShop.setBounds(124, 363, 293, 26);
		AddToShop.add(lblAddToShop);
		
		//changes "additional" label depending on value of combo box
		cbDeviceName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbDeviceName.getSelectedItem().toString().equals("mouse")) {
					lblAdditionalInfo.setText("Mouse buttons:");
				}
				else {
					lblAdditionalInfo.setText("Keyboard origin:");
				}
			}
		});
		
		JButton btnAddToShop = new JButton("Add");
		btnAddToShop.setBounds(442, 267, 72, 91);
		AddToShop.add(btnAddToShop);
		btnAddToShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//if at least 1 box is empty
				if (txtBarcode.getText().isEmpty() ||txtDeviceType.getText().isEmpty() ||txtBrand.getText().isEmpty() ||txtColour.getText().isEmpty() ||txtOrigPrice.getText().isEmpty() ||txtRetailPrice.getText().isEmpty() ||txtAdditional.getText().isEmpty()) {
					lblAddToShop.setText("Warning: not all fields filled");
				}
				else {
					int barcode = Integer.parseInt(txtBarcode.getText());
					String deviceName = (String) cbDeviceName.getSelectedItem();
					String deviceType = txtDeviceType.getText();
					String brand = txtBrand.getText();
					String colour = txtColour.getText();
					String connectivity = (String) cbConnectivity.getSelectedItem();
					String additional = txtAdditional.getText();
					
					// the following is in a try statement in case a non-numeric value is entered
					try {
						int quantity = Integer.parseInt(txtQuantity.getText());
						float origCost = Float.parseFloat(txtOrigPrice.getText());
						float retailPrice = Float.parseFloat(txtRetailPrice.getText());
						//validates values inside boxes
						if (addToShop.validateAddToShop(stockList, barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional) == false) {
							lblAddToShop.setText("Warning: fields are incorrect");
						}
						else {
							try {
								addToShop.updateStock(barcode, deviceName, deviceType, brand, colour, connectivity, quantity, origCost, retailPrice, additional);
								shop.stockToArrayList(stockList);
								shop.updateStockTableAdmin(stockList, dtmStock);
								lblAddToShop.setText("Item successfully added");
							} catch (IOException | ParseException e) {
								e.printStackTrace();
							}
						}
					}
					catch(NumberFormatException e){
						lblAddToShop.setText("Warning: fields are incorrect");
					}					
				}			
			}
		});
			
		tblUser.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				//when row on table is selected, it will login with the details of that row
				String access = tblUser.getValueAt(tblUser.getSelectedRow(), 2).toString();
				String username = tblUser.getValueAt(tblUser.getSelectedRow(), 1).toString();
				if (access.trim().equals("admin")) {
					admin.returnAdminAccess(tabbedPane, btnAddToBasket, dtmStock, tblStock);
					shop.updateStockTableAdmin(stockList, dtmStock);
					admin.returnAdminGreeting(username, accountList, lblShop);
				}
				else {
					customer.returnCustomerAccess(tabbedPane, btnAddToBasket, dtmStock, tblStock);					
					shop.updateStockTableCustomer(stockList, dtmStock);
					customer.returnCustomerGreeting(username, accountList, lblShop);

				}
				tabbedPane.setSelectedIndex(1);				
	        }
	    });
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(455, 455, 115, 29);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets the labels and text boxes to empty
				brandSort.setText("");
				buttonSort.setText("");
				txtPayPal.setText("");
				txtCardNum.setText("");
				txtCcv.setText("");
				//changes the enabled status of all tabs
				tabbedPane.setEnabledAt(0,true);
				tabbedPane.setEnabledAt(1,false);
				tabbedPane.setEnabledAt(2,false);
				tabbedPane.setEnabledAt(3,false);
				tabbedPane.setEnabledAt(4,false);
				tabbedPane.setEnabledAt(5,false);
				//upon logout, removes all items from basket and returns to shop table
				int rowCount = dtmBasket.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
					int barcode = Integer.parseInt(tblBasket.getValueAt(i, 0).toString());
				    dtmBasket.removeRow(i);
					//subsequently add 1 to quantity property of shop table
					int index = shop.getIndexByBarcode(barcode, stockList);
					int quantity = stockList.get(index).getQuantity();
					stockList.get(index).setQuantity(quantity+1);
					dtmStock.setRowCount(0);
					tblStock.setModel(dtmStock);
					lblOutOfStock.setText("");
				}
				shop.updateStockTableCustomer(stockList, dtmStock);
				
				while(dtmStock.getRowCount() > 0)
				{
				    dtmStock.removeRow(0);
				}
				dtmBasket.setRowCount(0);
				tabbedPane.setSelectedIndex(0);
				
			}
		});	
	}
}
