package com.todo.practice.form;

import lombok.Data;

@Data
public class SignUpForm {
//	email,name,pass,activatecodeを格納する
	public String emailaddress;
	public String username;
	public String password;
	public String activatecode;

}
