package com.electricity.system.entity;

import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Bill {
	
	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", meter=" + meter + ", energy=" + energy + 
				", bconntype=" + bconntype + ", price=" + price + ", status=" + status + ", board=" + board + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billid;
    private String name;
	
	private int meter;
	private int energy;
	private String metertype;
	public String getMetertype() {
		return metertype;
	}
	public void setMetertype(String metertype) {
		this.metertype = metertype;
	}
	private Date date;
	private String bconntype;
	private double price;
	private String status;
	private String board;
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getMeter() {
		return meter;
	}
	public void setMeter(int meter) {
		this.meter = meter;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBconntype() {
		return bconntype;
	}
	public void setBconntype(String bconntype) {
		this.bconntype = bconntype;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
