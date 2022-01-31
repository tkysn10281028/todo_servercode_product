package com.todo.practice.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.practice.form.ToDoDetailsForm;
import com.todo.practice.model.UserTodo;
import com.todo.practice.model.UserTodoDetails;
import com.todo.practice.service.UserService;
import com.todo.practice.service.UserTodoService;
@RestController
public class ToDoReadController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserService userService;
	@Autowired
	UserTodoService userTodoService;

//	API名	TODO読み出し処理
//	API_CODE	TODO_READ
//	更新日	2022/1/18
//	メソッド	GET
//	URI	/todo/read
//	概要	ユーザー情報を読み出してDB内のTODOを取得

	@RequestMapping(value = "/todo/read", method = RequestMethod.GET)
	public ResponseEntity<List<UserTodoDetails>> todoRead(Authentication auth) {
		
		HttpHeaders headers = new HttpHeaders();
		if (auth == null || auth.getName() == null) {
			return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
		}
		String emailaddress = auth.getName();

		int userid = userService.findIdbyemailaddress(emailaddress);
		if (userid == -1) {
			return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
		}
		List<UserTodoDetails> usertododetailslist = userTodoService.findToDosByuserid(userid);
		List<UserTodoDetails> outusertododetailslist = new ArrayList<UserTodoDetails>();

		for (UserTodoDetails usertododetails : usertododetailslist) {
			if (!(usertododetails.isDisableflag())) {
				outusertododetailslist.add(usertododetails);
			}
		}
		return new ResponseEntity<List<UserTodoDetails>>(outusertododetailslist, headers, HttpStatus.OK);

	}

//	API名	TODO登録処理
//	API_CODE	TODO_CREATE
//	更新日	2022/1/17
//	メソッド	POST
//	URI	/todo/create
//	概要	todoの内容を登録する

	@RequestMapping(value = "/todo/create", method = RequestMethod.POST)
	public ResponseEntity<List<UserTodoDetails>> todoCreate(Authentication auth,
			@RequestBody MultiValueMap<String, String> map) {
		HttpHeaders headers = new HttpHeaders();
		
		
		
		
		if (auth == null || auth.getName() == null) {
			return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
		}
		String emailaddress = auth.getName();

		int userid = userService.findIdbyemailaddress(emailaddress);
		if (userid == -1) {
			return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
		}
		System.out.println(map);

		String todoname = map.getFirst("todo");
		ToDoDetailsForm toDoDetailsForm = new ToDoDetailsForm();

		SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timef = new SimpleDateFormat("HH:mm");

		Date date = new Date();

		toDoDetailsForm.setTododetailsid(-1);
		toDoDetailsForm.setName(todoname);
		toDoDetailsForm.setDate(datef.format(date));
		toDoDetailsForm.setTime(timef.format(date));
		UserTodoDetails userTodoDetails = userTodoService.saveTodoDetails(toDoDetailsForm);
		System.out.println(userTodoDetails + "を登録しました。");
		
		int userdetailsid = userTodoDetails.getUsertododetailsid();
		
		UserTodo usertodo = userTodoService.createToDo(userid, userdetailsid);
		System.out.println(usertodo + "を登録しました。");
		
		List<UserTodoDetails> usertododetailslist =userTodoService.findToDosByuserid(userid);
		System.out.println(usertododetailslist);
		
		
		return new ResponseEntity<List<UserTodoDetails>>(usertododetailslist,headers,HttpStatus.OK);
	}

}
