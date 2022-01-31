package com.todo.practice.controller;

import java.util.ArrayList;
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
import com.todo.practice.model.UserTodoDetails;
import com.todo.practice.service.UserService;
import com.todo.practice.service.UserTodoService;

@RestController
public class ToDoUpdateController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserService userService;
	@Autowired
	UserTodoService userTodoService;

//	API名	TODO削除処理
//	API_CODE	TODO_DELETE
//	更新日	2022/1/18
//	メソッド	POST
//	URI	/todo/delete
//	概要	指定されたtodoのIDだけ削除

	@RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
	public ResponseEntity<List<UserTodoDetails>> todoDelete(@RequestBody MultiValueMap<String, String> map) {
		HttpHeaders headers = new HttpHeaders();
		List<UserTodoDetails> usertododetailslist = new ArrayList<UserTodoDetails>();
		System.out.println(map);

		List<String> todoids = map.get("deleteId");
		List<Integer> inttodoids = new ArrayList<Integer>();
		for (String todoid : todoids) {
			inttodoids.add(Integer.parseInt(todoid));
		}
		
		for (Integer todoid : inttodoids) {
			UserTodoDetails usertododetails = userTodoService.findByusertododetailsid(todoid);
			if (usertododetails == null) {
				return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
			}
			int tododetailsid = usertododetails.getUsertododetailsid();
			boolean isDeleted = userTodoService.deleteToDos(tododetailsid);
			System.out.println(usertododetails);
			if (!isDeleted) {
				return new ResponseEntity<List<UserTodoDetails>>(null, headers, HttpStatus.BAD_REQUEST);
			} else {
				UserTodoDetails tododetails = userTodoService.findByusertododetailsid(tododetailsid);
				usertododetailslist.add(tododetails);

			}
		}

		return new ResponseEntity<List<UserTodoDetails>>(usertododetailslist, headers, HttpStatus.OK);

	}

//	API名	TODO更新処理
//	API_CODE	TODO_UPDATE
//	更新日	2022/1/18
//	メソッド	POST
//	URI	/todo/update
//	概要	１件取得したidの内容を更新
	@RequestMapping(value = "/todo/update", method = RequestMethod.POST)
	public ResponseEntity<List<UserTodoDetails>> todoUpdate(@RequestBody MultiValueMap<String, String> map,
			Authentication auth) {
		int todoid = Integer.parseInt(map.getFirst("todoid"));
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

		String name = map.getFirst("name");
		String date = map.getFirst("date");
		String time = map.getFirst("time");

		ToDoDetailsForm toDoDetailsForm = new ToDoDetailsForm();

		toDoDetailsForm.setTododetailsid(todoid);
		toDoDetailsForm.setName(name);
		toDoDetailsForm.setDate(date);
		toDoDetailsForm.setTime(time);
		UserTodoDetails userTodoDetails = userTodoService.saveTodoDetails(toDoDetailsForm);
		System.out.println(userTodoDetails + "を登録しました。");

		List<UserTodoDetails> usertododetailslist = userTodoService.findToDosByuserid(userid);

		return new ResponseEntity<List<UserTodoDetails>>(usertododetailslist, headers, HttpStatus.OK);

	}

}
