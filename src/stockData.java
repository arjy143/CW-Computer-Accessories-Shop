
public abstract class stockData {
	public int barcode;
	public String deviceName;
	public String deviceType;
	public String brand;
	public String colour;
	public String connectivity;
	public int quantity;
	private float origCost;
	public float retailPrice;
	public String additional;
	
	public stockData(int barcode,String deviceName,String deviceType,String brand,String colour,String connectivity,int quantity,float origCost,float retailPrice,String additional) {
		this.barcode = barcode;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.quantity = quantity;
		this.origCost = origCost;
		this.retailPrice = retailPrice;
		this.additional = additional;
	}
	
	public int getBarcode() {
		return barcode;
	}	
	public String getDeviceName() {
		return deviceName;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public String getBrand() {
		return brand;
	}
	public String getColour() {
		return colour;
	}
	public String getConnectivity() {
		return connectivity;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getOrigCost() {
		return origCost;
	}
	public float getRetailPrice() {
		return retailPrice;
	}
	public String getAdditional() {
		return additional;
	}
	
	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}
}
