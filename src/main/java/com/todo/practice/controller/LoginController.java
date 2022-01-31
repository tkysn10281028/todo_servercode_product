package com.todo.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.practice.model.Usertable;
import com.todo.practice.service.UserService;

//	Userに関わる関連APIをまとめたコントローラ
@RestController
public class LoginController {
	@Autowired
	UserService userService;

//	API名	ユーザーデータ読み込みAPI
//	API_CODE	USER_READ
//	更新日	2022/1/18
//	メソッド	GET
//	URI	/user/read
//	概要	ログイン後のuser情報読み込みAPI
//	@CrossOrigin(origins = { "http://localhost:8081" })
	@RequestMapping(value = "/user/read", method = RequestMethod.GET)
	public ResponseEntity<Usertable> userRead(Authentication auth) {
		HttpHeaders headers = new HttpHeaders();

		if (auth == null) {
			return new ResponseEntity<Usertable>(null, headers, HttpStatus.BAD_REQUEST);
		}
		System.out.println("USER READ APIを読み込みました。");
		System.out.println(auth);
		System.out.println("メールアドレス：" + auth.getName());
		System.out.println("以上ログインのユーザー情報");

		Usertable loginuser = userService.findUserbyemailaddress(auth.getName());
		if (loginuser == null) {
			return new ResponseEntity<Usertable>(loginuser, headers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usertable>(loginuser, headers, HttpStatus.OK);

	}
	
	

}
