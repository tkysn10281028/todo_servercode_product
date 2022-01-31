package com.todo.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.practice.model.Usertable;
@Repository
public interface UserRepository extends JpaRepository<Usertable, Integer> {

//	emailaddressからDBから情報を取得
	Optional<Usertable> findByemailaddress(String emailaddress);

}
