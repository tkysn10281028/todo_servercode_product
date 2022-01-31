package com.todo.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.practice.form.ToDoDetailsForm;
import com.todo.practice.model.UserTodo;
import com.todo.practice.model.UserTodoDetails;
import com.todo.practice.repository.UserTodoDetailsRepository;
import com.todo.practice.repository.UserTodoRepository;

@Service
public class UserTodoService {
	@Autowired
	UserTodoDetailsRepository userTodoDetailsRepository;

	@Autowired
	UserTodoRepository userTodoRepository;

//	tododetailsformの中身を取得、usertodoをnewして内容を登録してrepository.saveする
	public UserTodoDetails saveTodoDetails(ToDoDetailsForm toDoDetailsForm) {
		UserTodoDetails userTodoDetails = new UserTodoDetails();
		userTodoDetails.setName(toDoDetailsForm.getName());
		userTodoDetails.setDate(toDoDetailsForm.getDate());
		userTodoDetails.setTime(toDoDetailsForm.getTime());
		userTodoDetails.setDisableflag(false);

//	新規登録時はidが-1になりformが持っているidは登録されない
		if (toDoDetailsForm.getTododetailsid() != -1) {
			userTodoDetails.setUsertododetailsid(toDoDetailsForm.getTododetailsid());
		}
		UserTodoDetails newUserTodoDetails = userTodoDetailsRepository.save(userTodoDetails);
		return newUserTodoDetails;
	}

//	usertodoをnewしてrepository.saveする
	public UserTodo createToDo(int userid, int todoid) {
		UserTodo userTodo = new UserTodo();
		userTodo.setUserid(userid);
		userTodo.setUsertododetailsid(todoid);
		UserTodo newusertodo = userTodoRepository.save(userTodo);
		return newusertodo;
	}

//	UseridからDB検索してlist取得、usertododetailsidのリストに詰め替えて再度DBを検索して詳細情報を返す
	public List<UserTodoDetails> findToDosByuserid(int userid) {

		List<Integer> usertododetailsidlist = new ArrayList<Integer>();
		List<UserTodoDetails> usertododetailsList = new ArrayList<UserTodoDetails>();

		List<UserTodo> todolist = userTodoRepository.findByuserid(userid);
		for (UserTodo todo : todolist) {
			usertododetailsidlist.add(todo.getUsertododetailsid());
		}

		for (Integer userTodoDetailsid : usertododetailsidlist) {
			Optional<UserTodoDetails> details = userTodoDetailsRepository.findByusertododetailsid(userTodoDetailsid);
			if (details.isPresent()) {
				usertododetailsList.add(details.get());
			}
		}

		return usertododetailsList;

	}

//	取得したidからdbを検索して、nullチェック
//	OKだったらそのidのdisableflagをtrueにする。
//	NGだったらfalseを返す

	public boolean deleteToDos(int tododetailsid) {
		Optional<UserTodoDetails> userTodoDetails = userTodoDetailsRepository.findByusertododetailsid(tododetailsid);
		if (userTodoDetails.isPresent()) {
			userTodoDetails.get().setDisableflag(true);
			userTodoDetailsRepository.save(userTodoDetails.get());
			return true;
		} else {
			return false;
		}

	}

	public UserTodoDetails findByusertododetailsid(int usertododetailsid) {
		Optional<UserTodoDetails> optuserdetails = userTodoDetailsRepository.findByusertododetailsid(usertododetailsid);
		if (optuserdetails.isEmpty()) {
			return null;
		} else {
			return optuserdetails.get();
		}

	}

}
