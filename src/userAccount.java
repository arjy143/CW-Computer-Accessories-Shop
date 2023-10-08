
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class userAccount {
	public final int id;
	public String username;
	private String name;
	private int houseNum;
	private String postcode;
	private String city;
	private String access;
	
	public userAccount(int id, String username, String name,int houseNum,String postcode,String city,String access) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.houseNum = houseNum;
		this.postcode = postcode;
		this.city = city;
		this.access = access;
	}
	public userAccount(int id, String username) {
		this.id = id;
		this.username = username;		
	}
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getCity() {
		return city;
	}
	public String getAccess() {
		return access;
	}
	
	//takes text file data and puts it in ArrayList
	public static void userAccountToArrayList(ArrayList<userAccount> accountList) throws IOException, ParseException {
		FileReader inputFile = new FileReader("UserAccounts.txt");
		BufferedReader br = new BufferedReader(inputFile);
		String line = null;
		while((line = br.readLine()) != null) {
			String[] accountLine = line.split(",");
			int id = Integer.parseInt(accountLine[0].trim());
			String username = accountLine[1].trim();
			String name = accountLine[2].trim();
			int houseNum = Integer.parseInt(accountLine[3].trim());
			String postcode = accountLine[4].trim();
			String city = accountLine[5].trim();
			String access = accountLine[6].trim();
			userAccount userDet = new userAccount(id, username, name, houseNum, postcode, city, access);
			accountList.add(userDet);			
		}				
		br.close();
	}
	
	//gives address line based on username (used in payment screens)
	public static String returnAddress(ArrayList<userAccount> accountList, String username) {
		String address = "";
		for (userAccount account : accountList) {
			if (account.getUsername().trim() == username) {
				address += account.getHouseNum()+", "+account.getCity()+", "+account.getPostcode();
				return address;
			}
		}
		
		return address;
		
	}
}
