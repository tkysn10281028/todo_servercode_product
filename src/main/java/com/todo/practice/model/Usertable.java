package com.todo.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

//Userテーブル
public class Usertable {

//	userid	ユーザーID（PK）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

//	username	ユーザー名
	private String username;

//	emailaddress	メールアドレス
	private String emailaddress;

//	password	パスワード
	private String password;

//	activateCode	2段階認証用コード
	private String activatecode;

//	role	権限
	private String role;

}
