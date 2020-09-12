package com.manoj.dto;

import java.io.Serializable;

public class Passangerbusdetailsdto implements Serializable {
	
	private int ticketid;
	private String passangername;
	private String passangerfrom;
	private String passangerto;
	private int    passangerage;
	private float  ticketprice;
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public String getPassangername() {
		return passangername;
	}
	public void setPassangername(String passangername) {
		this.passangername = passangername;
	}
	public String getPassangerfrom() {
		return passangerfrom;
	}
	public void setPassangerfrom(String passangerfrom) {
		this.passangerfrom = passangerfrom;
	}
	public String getPassangerto() {
		return passangerto;
	}
	public void setPassangerto(String passangerto) {
		this.passangerto = passangerto;
	}
	public int getPassangerage() {
		return passangerage;
	}
	public void setPassangerage(int passangerage) {
		this.passangerage = passangerage;
	}
	public float getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(float ticketprice) {
		this.ticketprice = ticketprice;
	}
	public Passangerbusdetailsdto() {
		super();
	}
	@Override
	public String toString() {
		return "Passangerbusdetailsdto [ticketid=" + ticketid + ", passangername=" + passangername + ", passangerfrom="
				+ passangerfrom + ", passangerto=" + passangerto + ", passangerage=" + passangerage + ", ticketprice="
				+ ticketprice + "]";
	}

}
