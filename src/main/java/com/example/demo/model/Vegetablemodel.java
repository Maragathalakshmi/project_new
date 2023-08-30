package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vegetables")
public class Vegetablemodel
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int vid;
	
	@Column(name="Vegetable name")
	private String vname;
	@Column(name="Price")
	private long vprice;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public long getVprice() {
		return vprice;
	}
	public void setVprice(long vprice) {
		this.vprice = vprice;
	}
	public Vegetablemodel(int vid, String vname, long vprice) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vprice = vprice;
	}
	public Vegetablemodel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
