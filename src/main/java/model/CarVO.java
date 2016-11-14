/**
 * 
 */
package model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import model.VehicleVO;

/**
 * @author admin
 *
 */
@Component
@Scope("prototype")
public class CarVO extends VehicleVO {
	
	private String companyName;
	private String modelNumber;
	private String name;
	private Double fuelCapacity;
	private Double milege;
	private Double price;
	private Double roadTax;
	private String isACPresent;
	private String isPowerSteeringPresent;
	private String isAccessoryKitPresent;
	
	public CarVO(){
		
		companyName = null;
		modelNumber = null;
		name = null;
		fuelCapacity = null;
		milege = null;
		price = null;
		roadTax = null;
		isACPresent = null;
		isPowerSteeringPresent = null;
		isAccessoryKitPresent = null;
	}
	
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}


	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Override
	/**
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}
	
	@Override
	/**
	 * @param modelNumber the modelNumber to set
	 */
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	
	@Override
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	/**
	 * @return the fuelCapacity
	 */
	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	
	/**
	 * @param fuelCapacity the fuelCapacity to set
	 */
	public void setFuelCapacity(Double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * @return the milege
	 */
	public Double getMilege() {
		return milege;
	}

	/**
	 * @param milege the milege to set
	 */
	public void setMilege(Double milege) {
		this.milege = milege;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the roadTax
	 */
	public Double getRoadTax() {
		return roadTax;
	}

	/**
	 * @param roadTax the roadTax to set
	 */
	public void setRoadTax(Double roadTax) {
		this.roadTax = roadTax;
	}
	
	/**
	 * @return the isACPresent
	 */
	public String getIsACPresent() {
		return isACPresent;
	}


	/**
	 * @param isACPresent the isACPresent to set
	 */
	public void setIsACPresent(String isACPresent) {
		this.isACPresent = isACPresent;
	}


	/**
	 * @return the isPowerSteeringPresent
	 */
	public String getIsPowerSteeringPresent() {
		return isPowerSteeringPresent;
	}


	/**
	 * @param isPowerSteeringPresent the isPowerSteeringPresent to set
	 */
	public void setIsPowerSteeringPresent(String isPowerSteeringPresent) {
		this.isPowerSteeringPresent = isPowerSteeringPresent;
	}


	/**
	 * @return the isAccessoryKitPresent
	 */
	public String getIsAccessoryKitPresent() {
		return isAccessoryKitPresent;
	}


	/**
	 * @param isAccessoryKitPresent the isAccessoryKitPresent to set
	 */
	public void setIsAccessoryKitPresent(String isAccessoryKitPresent) {
		this.isAccessoryKitPresent = isAccessoryKitPresent;
	}


	@Override
	public double calculateOnRoadPrice(Double roadTax, Double carPrice) {
		return (roadTax + carPrice);
	}
}