package com.todo.practice.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.todo.practice.constants.ActivateCode;
import com.todo.practice.form.SignUpForm;
import com.todo.practice.model.Usertable;
import com.todo.practice.repository.UserRepository;

@Service
public class SignUpUserService {

	@Autowired
	MailSender mailSender;

	@Autowired
	UserRepository userRepository;

//	emailaddress,password,usernameの3つの値のバリデーションチェック
	public boolean validation(String emailaddress, String password, String username) {
		String mailpattern = "^([a-zA-Z0-9])+([a-zA-Z0-9._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$";
		Pattern mailp = Pattern.compile(mailpattern);

		String passpattern = "^(?=.*[0-9])[a-zA-Z0-9]{8,20}$";
		Pattern passp = Pattern.compile(passpattern);

		if (emailaddress.equals("") || emailaddress == null) {

			System.out.println(emailaddress + "メールアドレスが空白です。");
			return false;
		} else if (!(mailp.matcher(emailaddress).find())) {
			System.out.println(emailaddress + "メールアドレスの形式は〇〇@〇〇にしてください。");
			return false;
		} else if (!(passp.matcher(password).find())) {
			System.out.println(password + "パスワードは8文字以上20字以内でかつ英数字になります。");
			return false;
		} else if (username.equals("") || username == null) {
			System.out.println(username + "ユーザー名が空欄です。");
			return false;
		} else {
			return true;
		}
	}

//	メール送信とアクティベートコード生成
	public String sendmail(String emailaddress) {
		SimpleMailMessage msg = new SimpleMailMessage();
		String activatecode = ActivateCode.createActivateCode();

		msg.setFrom("test@mail.com");
		msg.setTo(emailaddress);
		msg.setSubject("認証用メール");// タイトルの設定
		msg.setText("test serverより本文送信\n\n\n" + "※※※※※※※※認証用コード※※※※※※※※\n" + activatecode
				+ "\n※※※※※※※※※※※※※※※※※※※※※※\n" + "\n\n上の認証用コードを画面に入力してください。"); // 本文の設定

		this.mailSender.send(msg);
		return activatecode;

	}

//	ユーザー情報を登録
	public Usertable signup(SignUpForm signUpForm) {
		Usertable user = new Usertable();
		user.setUsername(signUpForm.getUsername());
		user.setEmailaddress(signUpForm.getEmailaddress());
		user.setActivatecode(signUpForm.getActivatecode());
		user.setPassword(signUpForm.getPassword());
		user.setRole("USER");
		Usertable newuser = userRepository.save(user);
		return newuser;

	}

}
