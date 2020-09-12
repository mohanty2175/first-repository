package com.manoj.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manoj.bo.PassangerBusDetailebo;

@Repository("busDAO")
public class BusTicketreservationimpl implements BusTicketReservationDao {

	private static final String bus_insert_reservation="INSERT INTO TICKETBUS VALUES(?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	
	
	public int[] batchInsert(final List<PassangerBusDetailebo> listbo) {
		int result[]=null;
		result=jt.batchUpdate(bus_insert_reservation, 
				new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				System.out.println(
						"BusTicketreservationimpl.batchInsert(...).new BatchPreparedStatementSetter() {...}.setValues()");
				ps.setInt(1,listbo.get(i).getTicketid());
				ps.setString(2,listbo.get(i).getPassangername());
				ps.setString(3,listbo.get(i).getPassangerfrom());
				ps.setString(4,listbo.get(i).getPassangerto());
				ps.setInt(5,listbo.get(i).getPassangerage());
				ps.setFloat(6,listbo.get(i).getTicketprice());
			}
			
			public int getBatchSize() {
				System.out.println(
						"BusTicketreservationimpl.batchInsert(...).new BatchPreparedStatementSetter() {...}.getBatchSize()");
				return listbo.size();
			}
		});
		
		return result;
	}

}
