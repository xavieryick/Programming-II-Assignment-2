package mru.store.model;

public class Animals extends Toy{

	private String animalSize;
	private String animalMaterial;
	
	public Animals(long serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, String animalMaterial, String animalSize) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
		this.animalMaterial = animalMaterial;
		this.animalSize = animalSize;
	}
	
	public void setAnimalMaterial(String animalMaterial) {
		this.animalMaterial = animalMaterial;
	}
	public String getAnimalMaterial() {
		return animalMaterial;
	}
	
	public void setAnimalSize(String animalSize) {
		this.animalSize= animalSize;
	}
	public String getAnimalSize() {
		return animalSize;
	}
	
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber +
			   "\nToy Name: " + toyName + 
			   "\nToy Brand: " + toyBrand +
			   "\nPrice: " + toyPrice + 
			   "\nAvailable Count: " + availableCount +
			   "\nAppropriate Age: " + appropriateAge + 
			   "\nAnimal Material: " + animalMaterial +
			   "\nAnimal Size: " + animalSize;
	}
	
	@Override
	public String format() {
		return serialNumber + ";" 
			 + toyName + ";" 
			 + toyBrand + ";" 
			 + toyPrice + ";" 
			 + availableCount + ";" 
			 + appropriateAge + ";"
			 + animalMaterial + ";"
			 + animalSize;
	}
}
