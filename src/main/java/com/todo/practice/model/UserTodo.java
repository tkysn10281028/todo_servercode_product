package com.todo.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

//Usertodoテーブル UserテーブルとUserTodoDetailsテーブルの中間テーブル
public class UserTodo {
//	usertodoid	usertodoテーブルのID(PK)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usertodoid;
	
//	userid	ユーザーID（PK）
	private int userid;
	
//	usertododetailsid	todo詳細のID
	private int usertododetailsid;
	
}
