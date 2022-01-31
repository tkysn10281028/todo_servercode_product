package com.todo.practice.form;

import lombok.Data;

@Data
public class ToDoDetailsForm {
//	tododetailsid,name,date,timeを格納
	public int tododetailsid;
	public String name;
	public String date;
	public String time;
}
