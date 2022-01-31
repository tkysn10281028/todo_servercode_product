package com.todo.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.practice.model.UserTodo;

@Repository
public interface UserTodoRepository extends JpaRepository<UserTodo, Integer>{
//	useridからusertodoを取得
	public List<UserTodo> findByuserid(int userid);
}
