package com.manoj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.bo.PassangerBusDetailebo;
import com.manoj.dao.BusTicketReservationDao;
import com.manoj.dto.Passangerbusdetailsdto;

@Service("busservice")
public class BusticketManagementServiceimpl implements BusticketManagementService {

	
	@Autowired
	private BusTicketReservationDao dao;
	
	public String groupReservation(List<Passangerbusdetailsdto> listdto) {
		final List<PassangerBusDetailebo> listbo=new ArrayList();
		int result[]=null;
		//convert llistdto to listbo
		listdto.forEach(dto->{
			PassangerBusDetailebo bo=new PassangerBusDetailebo();
			BeanUtils.copyProperties(dto, bo);
			listbo.add(bo);
				
		});
	//use dao
		result=dao.batchInsert(listbo);
		if(result!=null)
			return  "group reservation susseded";
		else {
			return  "group reservation failed";
					
		}
		
	}

}
