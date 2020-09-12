package com.manoj.test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.manoj.dto.Passangerbusdetailsdto;
import com.manoj.service.BusticketManagementService;

public class BatchinsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Scanner sc=null;
		float price=0.0f;
		String fromplace=null;
		int ticketid=0;
		String toplace=null;
		String name=null;
		int groupSize=0;
		int age=0;
		BusticketManagementService service=null;
		String result=null;
		List<Passangerbusdetailsdto> listdto=new ArrayList<>();
		Passangerbusdetailsdto dto=null;
		sc=new Scanner(System.in);
		try {
			System.out.println("enter group size::");
			name=sc.next();
			if(groupSize>0) {
			System.out.println("enter to place::");
			toplace=sc.next();
			System.out.println("enter from place::");
			fromplace=sc.next();
			System.out.println("enter ticketid::");
			ticketid=sc.nextInt();
			System.out.println("enter ticket price::");
			price=sc.nextFloat();
			
		    
		    for (int i=1;i<=groupSize;++i) {
		    	System.out.println("enter"+i+"paassanger details::");
		    	
		    	System.out.println("enter passanger name::");
				name=sc.next();
				System.out.println("enter passanger age::");
			    age=sc.nextInt();
		   //add each passanger into dto
			    dto=new Passangerbusdetailsdto();
			    dto.setPassangerage(age);
			    dto.setTicketid(ticketid);
			    dto.setPassangerfrom(fromplace);
			    dto.setPassangerto(toplace);
			    dto.setPassangername(name);
			    dto.setTicketprice(price);
			    //add each dtoto listdto
			    listdto.add(dto);    
		    }
			}
			else {
				System.out.println("invalidate group");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/manoj/cfgs/applicationcontext.xml");
		//gwt service class obj
		service=ctx.getBean("busticketservice",BusticketManagementService.class);
	try {
		
		result=service.groupReservation(listdto);
		System.out.println(result);
	}
	catch (DataAccessException e) {
		e.printStackTrace();
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	((AbstractApplicationContext) ctx).close();
	}
	
}
			
		