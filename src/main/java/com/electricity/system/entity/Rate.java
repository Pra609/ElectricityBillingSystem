package com.electricity.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	private String board;
	private String conntype;
	private double price;
	private String metertype;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	
	public String getConntype() {
		return conntype;
	}
	public void setConntype(String conntype) {
		this.conntype = conntype;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMetertype() {
		return metertype;
	}
	public void setMetertype(String metertype) {
		this.metertype = metertype;
	}
	

}
