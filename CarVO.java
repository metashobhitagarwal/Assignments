package model;

/**
 * Car Bean Class
 * containing the getter and
 * setter methods
 * @author shobhit
 */
public class CarVO extends VehicleVO{
	
	private String companyName;
	private String modelNumber;
	private String name;
	private double fuelCapacity;
	private double mileage;
	private double price;
	private double roadTax;
	private String isACPresent;
	private String isPowerSteeringPresent;
	private String isAccessoryKitPresent;
	
	public CarVO(){
		companyName = null;
		modelNumber = null;
		name = null;
		fuelCapacity = 0;
		mileage = 0;
		price = 0;
		roadTax = 0;
		isACPresent = null;
		isPowerSteeringPresent = null;
		isAccessoryKitPresent = null;
	}
	
	//Getter Methods
	public String getCompanyName(){
		return companyName;
	};
	public String getModelNumber(){
		return modelNumber;
	};
	public String getName(){
		return name;
	};
	public double getFuelCapacity(){
		return fuelCapacity;
	};
	public double getMileage(){
		return mileage;
	};
	public double getPrice(){
		return price;
	};
	public double getRoadTax(){
		return roadTax;
	};
	public String isACPresent(){
		return isACPresent;
	}
	public String isPowerSteeringPresent(){
		return isPowerSteeringPresent;
	}
	public String isAccessoryKitPresent(){
		return isAccessoryKitPresent;
	}
		
		//Setter Methods
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	};
	public void setModelNumber(String modelNumber){
		this.modelNumber = modelNumber;
	};
	public void setName(String name){
		this.name = name;
	};
	public void setFuelCapacity(double fuelCapacity){
		this.fuelCapacity = fuelCapacity;
	};
	public void setMileage(double mileage){
		this.mileage = mileage;
	};
	public void setPrice(double price){
		this.price = price;
	};
	public void setRoadTax(double roadTax){
		this.roadTax = roadTax;
	};
	public void setACPresent(String isACPresent){
		this.isACPresent = isACPresent;
	}
	public void setPowerSteeringPresent(String isPowerSteeringPresent){
		this.isPowerSteeringPresent = isPowerSteeringPresent;
	}
	public void setAccessoryKitPresent(String isAccessoryKitPresent){
		this.isAccessoryKitPresent = isAccessoryKitPresent;
	}
	
	public double calculateOnRoadPrice(double roadTax, double carPrice){
		return (roadTax + carPrice);
	}
}
