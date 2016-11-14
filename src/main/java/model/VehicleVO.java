/**
 * 
 */
package model;

import org.springframework.stereotype.Component;

/**
 * @author admin
 *
 */
@Component
public abstract class VehicleVO {
	
	/*private String companyName;
	private String modelNumber;
	private String name;
	private double fuelCapacity;
	private double milege;
	private double price;
	private double roadTax;*/
	
	/*public VehicleVO(){
		
		companyName = null;
		modelNumber = null;
		name = null;
		fuelCapacity = 0;
		milege = 0;
		price = 0;
		roadTax = 0;
	}*/
	
	/**
	 * @return the company name
	 */
	public abstract String getCompanyName();
	
	/**
	 * @param companyName the companyName to set
	 */
	public abstract void setCompanyName(String companyName);

	/**
	 * @return the modelNumber
	 */
	public abstract String getModelNumber();

	/**
	 * @param modelNumber the modelNumber to set
	 */
	public abstract void setModelNumber(String modelNumber);

	/**
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @param name the name to set
	 */
	public abstract void setName(String name);

	/**
	 * @return the fuelCapacity
	 */
	public abstract Double getFuelCapacity();

	/**
	 * @param fuelCapacity the fuelCapacity to set
	 */
	public abstract void setFuelCapacity(Double fuelCapacity);

	/**
	 * @return the milege
	 */
	public abstract Double getMilege();

	/**
	 * @param milege the milege to set
	 */
	public abstract void setMilege(Double milege);

	/**
	 * @return the price
	 */
	public abstract Double getPrice();

	/**
	 * @param price the price to set
	 */
	public abstract void setPrice(Double price);

	/**
	 * @return the roadTax
	 */
	public abstract Double getRoadTax();

	/**
	 * @param roadTax the roadTax to set
	 */
	public abstract void setRoadTax(Double roadTax);
	
	public abstract double calculateOnRoadPrice(Double roadTax,Double carPrice);
	
}