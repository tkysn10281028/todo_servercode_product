package com.todo.practice.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
//	API名:初アクセス時の処理API
//	API_CODE:FIRSTACCESS
//	更新日:2022/1/19
//	メソッド:GET
//	URI	:/
//	概要	最初のアクセス時の挙動
	public String firstaccess() {
		System.out.println("sended");
		return "index";
	}
	

}
