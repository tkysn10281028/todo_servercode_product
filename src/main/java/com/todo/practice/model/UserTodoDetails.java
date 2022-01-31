package com.todo.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

//Usertododetailsテーブル	
public class UserTodoDetails {

//	usertododetailsid	todo詳細のID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usertododetailsid;

//	name	todo内容
	private String name;

//	date	作成日付
	private String date;

//	time	作成時間
	private String time;
//	disableflag	削除しているかflag
	private boolean disableflag;
	
	
}
