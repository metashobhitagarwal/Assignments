/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author admin
 *
 */
@Entity
@Table(name="CAR")
public class CarVO {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="CompanyName")
	private String companyName;

	@Column(name="ModelNumber")
	private String modelNumber;

	@Column(name="Name")
	private String name;

	@Column(name="FuelCapacity")
	private Double fuelCapacity;

	@Column(name="Milege")
	private Double milege;

	@Column(name="Price")
	private Double price;

	@Column(name="RoadTax")
	private Double roadTax;

	@Column(name="AC")
	private String isACPresent;

	@Column(name="PowerSteering")
	private String isPowerSteeringPresent;

	@Column(name="AccessoryKit")
	private String isAccessoryKitPresent;


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber the modelNumber to set
	 */
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
}