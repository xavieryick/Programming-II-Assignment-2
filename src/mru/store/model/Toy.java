package mru.store.model;

public abstract class Toy {
	
	public String serialNumber;
	public String toyName;
	public String toyBrand;
	public double toyPrice;
	public int availableCount;
	public int appropriateAge;
	
	public Toy(String serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge) {
		this.serialNumber = serialNumber;
		this.toyName = toyName;
		this.toyBrand = toyBrand;
		this.toyPrice = toyPrice;
		this.availableCount = availableCount;
		this.appropriateAge = appropriateAge;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyBrand(String toyBrand) {
		this.toyBrand = toyBrand;
	}
	public String getToyBrand() {
		return toyBrand;
	}
	public void setToyPrice(double toyPrice) {
		this.toyPrice = toyPrice;
	}
	public double getToyPrice() {
		return toyPrice;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAppropriateAge(int appropriateAge) {
		this.appropriateAge = appropriateAge;
	}
	public int getAppropriateAge() {
		return appropriateAge;
	}
	
	public String toString() {
		return "Serial Number: " + serialNumber +
			   "\nToy Name: " + toyName + 
			   "\nToy Brand: " + toyBrand +
			   "\nPrice: " + toyPrice + 
			   "\nAvailable Count: " + availableCount +
			   "\nAppropriate Age: " + appropriateAge;
	}

	public String format() {
		return serialNumber + ";" 
			 + toyName + ";" 
			 + toyBrand + ";" 
			 + toyPrice + ";" 
			 + availableCount + ";" 
			 + appropriateAge;
	}
	
}
