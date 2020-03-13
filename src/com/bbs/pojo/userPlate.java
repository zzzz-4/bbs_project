package com.bbs.pojo;

public class userPlate {
	private Integer plateId;
	
	private  String	palteTitle;
	private  String  plateMessage;
	public Integer getPlateId() {
		return plateId;
	}
	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}
	public String getPalteTitle() {
		return palteTitle;
	}
	public void setPalteTitle(String palteTitle) {
		this.palteTitle = palteTitle;
	}
	public String getPlateMessage() {
		return plateMessage;
	}
	public void setPlateMessage(String plateMessage) {
		this.plateMessage = plateMessage;
	}
	public userPlate(Integer plateId, String palteTitle) {
		super();
		this.plateId = plateId;
		this.palteTitle = palteTitle;
		
	}
	
	public userPlate(Integer plateId, String palteTitle, String plateMessage) {
		super();
		this.plateId = plateId;
		this.palteTitle = palteTitle;
		this.plateMessage = plateMessage;
	}
	public userPlate() {
	
	}
	
	
	
}
