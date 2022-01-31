package com.todo.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.practice.model.UserTodoDetails;

public interface UserTodoDetailsRepository extends JpaRepository<UserTodoDetails, Integer>{
//	usertododetailsidからusertododetailsを取得
	public Optional<UserTodoDetails> findByusertododetailsid(int usertododetailsid);
}
