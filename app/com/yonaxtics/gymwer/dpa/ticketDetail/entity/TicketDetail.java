package com.yonaxtics.gymwer.dpa.ticketDetail.entity;

import java.time.LocalDateTime;

import com.yonaxtics.gymwer.util.base.entity.Entity;
/**
 * 
 * @author yonatan quintero
 * @version 0.1 (7/16/2014)
 *
 */
public class TicketDetail extends Entity {


	private int item;
	private LocalDateTime finished;
	
	public TicketDetail(int id) {
		
		super(id);
		
	}



	public int getItem() {
		return item;
	}

	public LocalDateTime getFinished() {
		return finished;
	}



	public void setItem(int item) {
		this.item = item;
	}

	public void setFinished(LocalDateTime finished) {
		this.finished = finished;
	}

}
