package com.metacube.dsp2.vo;

public class CarVO extends VehicleVO {

	private int id;
	private String ac;
	private String powerSteering;
	private String accessoryKit;
	private String createdBy;
	private String createdTime;
	private String updatedBy;
	private String updatedTime;
	
	public CarVO() {
		
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getPowerSteering() {
		return powerSteering;
	}

	public CarVO(int id, String ac, String powerSteering, String accessoryKit) {
		this.id = id;
		this.ac = ac;
		this.powerSteering = powerSteering;
		this.accessoryKit = accessoryKit;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	public String getAc() {
		return ac;
	}
	
	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}
	
	public String getpowerSteering() {
		return powerSteering;
	}
	
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
	
	public String getAccessoryKit() {
		return accessoryKit;
	}
}
