package com.vuong.controller;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vuong.bean.MailInfo;
import com.vuong.dao.AccountDAO;
import com.vuong.entity.Account;
import com.vuong.service.MailerService;

@Controller
public class MailerController {
	@Autowired
	MailerService mailer;
	@Autowired
	AccountDAO accountDao;
	
	@RequestMapping("/account/remember-pass")
	public String demo3(Model model) {
		return "icream/remember-pass";
	}

	// @ResponseBody account/remember-pass
	@RequestMapping("/account/remember-send")
	public String send(Model model, MailInfo mailinfo, @RequestParam("username") String username,
			@RequestParam("email") String email) {
		Optional<Account> account = accountDao.findById(username);
		if (username.equalsIgnoreCase(account.get().getUsername())) {
			if (email.equalsIgnoreCase(account.get().getEmail())) {

				mailinfo.setSubject("Thông tin của tài khoản " + account.get().getFullname());
				mailinfo.setBody(
						"Tên người dùng: " + account.get().getUsername() + " Mật khẩu: " + account.get().getPassword());
				mailinfo.setTo(account.get().getEmail());
				mailinfo.setFrom("vuongnmps12651@fpt.edu.vn");
				mailer.queue(mailinfo.getTo(), mailinfo.getSubject(), mailinfo.getBody());
				model.addAttribute("mail", mailinfo);
				model.addAttribute("message", "Gửi mail thành công. Vui lòng kiểm tra mail để đăng nhập tài khoản.^^");
				System.out.print("Thanh cong");
			} else {
				model.addAttribute("message", "Sai email!! Vui lòng kiểm tra lại email.^^");
			}
		} else {
			model.addAttribute("message",
					"Tài khoản không tồn tại.^^");
		}

		return "icream/remember-pass";
	}

}
