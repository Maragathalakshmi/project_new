


package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class Usermodel {
	@Id
	private int userid;
	private String name;
	private String address;
	private String emailid;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fruitid")
    private Fruitmodel f;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="vegid")
	private List<Vegetablemodel> v;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Fruitmodel getF() {
		return f;
	}
	public void setF(Fruitmodel f) {
		this.f = f;
	}
	public List<Vegetablemodel> getV() {
		return v;
	}
	public void setV(List<Vegetablemodel> v) {
		this.v = v;
	}
	public Usermodel(int userid, String name, String address, String emailid, Fruitmodel f, List<Vegetablemodel> v) {
		super();
		this.userid = userid;
		this.name = name;
		this.address = address;
		this.emailid = emailid;
		this.f = f;
		this.v = v;
	}
	public Usermodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}