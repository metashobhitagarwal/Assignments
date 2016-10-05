package model;

/**
 * Vehicle Bean Class
 * containing the getter and
 * setter methods
 * @author shobhit
 */
public abstract class VehicleVO {
	/*private String companyName;
	private String modelNumber;
	private String name;
	private double fuelCapacity;
	private double mileage;
	private double price;
	private double roadTax;
	*/
	/*public VehicleVO(){
		companyName = null;
		modelNumber = null;
		name = null;
		fuelCapacity = 0;
		mileage = 0;
		price = 0;
		roadTax = 0;
	}*/
	
	//Getter Methods
	public abstract String getCompanyName();
	public abstract String getModelNumber();
	public abstract String getName();
	public abstract double getFuelCapacity();
	public abstract double getMileage();
	public abstract double getPrice();
	public abstract double getRoadTax();
	
	//Setter Methods
	public abstract void setCompanyName(String companyName);
	public abstract void setModelNumber(String modelNumber);
	public abstract void setName(String name);
	public abstract void setFuelCapacity(double fuelCapacity);
	public abstract void setMileage(double milege);
	public abstract void setPrice(double price);
	public abstract void setRoadTax(double roadTax);
	
	public abstract double calculateOnRoadPrice(double roadTax, double carPrice);
}
