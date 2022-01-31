package com.todo.practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.practice.form.SignUpForm;
import com.todo.practice.model.Usertable;
import com.todo.practice.service.SignUpUserService;
import com.todo.practice.service.UserService;

@RestController
public class SignUpController {
	@Autowired
	SignUpUserService signUpUserService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserService userService;
	@Autowired
	HttpSession session;

//	API名	アクティベートコード送信API
//	API_CODE	USER_ACTIVATE
//	更新日	2022/1/17
//	メソッド	POST
//	URI	/user/signup/activate
//	概要	メール送信とランダム生成したアクティベートコードを返す
	@RequestMapping(value = "/user/signup/activate", method = RequestMethod.POST)
	public ResponseEntity<String> signupActivate(@RequestBody MultiValueMap<String, String> map) {
		HttpHeaders headers = new HttpHeaders();

		String emailaddress = map.getFirst("emailaddress");
		String password = map.getFirst("password");
		String username = map.getFirst("username");

		System.out.println("USER ACTIVATE APIを読み込みました。");
		System.out.println("受け取りパラメータ：");
		System.out.println(username + password + emailaddress);
		System.out.println("以上");

		boolean isValueOK = signUpUserService.validation(emailaddress, password, username);
		if (isValueOK) {

			Usertable user = userService.findUserbyemailaddress(emailaddress);
			if (user != null) {
				System.out.println("メールアドレスが存在します。");
				return new ResponseEntity<String>("hi", headers, HttpStatus.BAD_REQUEST);
			} else {
				String activatecode = signUpUserService.sendmail(emailaddress);

				session.setAttribute("activatecode", activatecode);
				SignUpForm signUpForm = new SignUpForm();
				signUpForm.setUsername(username);
				signUpForm.setPassword(encoder.encode(password));
				signUpForm.setEmailaddress(emailaddress);
				signUpForm.setActivatecode(activatecode);
				session.setAttribute("signUpForm", signUpForm);

				return new ResponseEntity<String>("success", headers, HttpStatus.OK);
			}
		} else {
			System.out.println("validation NG");
			return new ResponseEntity<String>("hi", headers, HttpStatus.BAD_REQUEST);
		}

	}

//	API名	ユーザーデータ登録API
//	API_CODE	USER_CREATE
//	更新日	2022/1/17
//	メソッド	POST
//	URI	/user/signup
//	概要	ユーザー情報の登録
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ResponseEntity<Usertable> userSignUp(@RequestBody MultiValueMap<String, String> map) {
		HttpHeaders headers = new HttpHeaders();
		String activatecode = (String) session.getAttribute("activatecode");
		SignUpForm signupform = (SignUpForm) session.getAttribute("signUpForm");
		String sendedactivatecode = map.getFirst("inputactivatecode");

		System.out.println(activatecode);
		System.out.println(signupform);
		System.out.println(map.getFirst("inputactivatecode"));
		if (activatecode == null) {
			return new ResponseEntity<Usertable>(null, headers, HttpStatus.BAD_REQUEST);
		} else if (signupform == null) {
			return new ResponseEntity<Usertable>(null, headers, HttpStatus.BAD_REQUEST);
		}

		if (activatecode.equals(sendedactivatecode)) {
			Usertable user = signUpUserService.signup(signupform);
			session.invalidate();
			return new ResponseEntity<Usertable>(user, headers, HttpStatus.CREATED);
		} else {
			session.invalidate();
			return new ResponseEntity<Usertable>(null, headers, HttpStatus.BAD_REQUEST);
		}

	}

}
