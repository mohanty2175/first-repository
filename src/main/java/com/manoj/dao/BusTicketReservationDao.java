package com.manoj.dao;

import java.util.List;

import com.manoj.bo.PassangerBusDetailebo;

public interface BusTicketReservationDao {

	
	public int[] batchInsert(List<PassangerBusDetailebo> listbo);
	
}
