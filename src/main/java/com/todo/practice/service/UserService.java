package com.todo.practice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.practice.model.Usertable;
import com.todo.practice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

//	repository取得dataのnullチェック
	public Usertable findUserbyemailaddress(String emailaddress) {
		Optional<Usertable> optuser = userRepository.findByemailaddress(emailaddress);
		if (optuser.isEmpty()) {
			return null;
		}
		return optuser.get();

	}

	// repository取得dataのnullチェックOKならuserのidを返す
	public int findIdbyemailaddress(String emailaddress) {
		Optional<Usertable> optuser = userRepository.findByemailaddress(emailaddress);
		if (optuser.isEmpty()) {
			return -1;
		}
		return optuser.get().getUserid();
	}
}
