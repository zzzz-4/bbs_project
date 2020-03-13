package com.bbs.service;

import java.util.ArrayList;

import com.bbs.dao.cropsDao;
import com.bbs.pojo.userPlate;


public class plateService {
private  cropsDao cropsDao=new cropsDao();
	public userPlate findTitleByName(String plateTitle) {
		return cropsDao.findTitleByName(plateTitle);
	}
	
	public int addCategory(String plateTitle,String  plateMessage) {
		return cropsDao.addCategory(plateTitle,plateMessage);
	}
	public ArrayList<userPlate> listMessage(){
		return cropsDao.listMessage();
	}
}
