package model;

import java.util.Date;

//訪客留言版
public class GuestBook {
	private String message;
	private Date date;
	
	public GuestBook(String message) {
		this.message =message;
		this.date = new Date();
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "GuestBook [userName=" + message + ", date=" + date + "]";
	}
	
	
}
