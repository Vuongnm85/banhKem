package com.vuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vuong.dao.AccountDAO;
import com.vuong.dao.CategoryDAO;
import com.vuong.dao.ProductDAO;
import com.vuong.entity.Account;
import com.vuong.entity.Category;
import com.vuong.entity.Product;

@Controller
public class OnTapController {
	@Autowired
	AccountDAO acDao;
	@Autowired
	CategoryDAO cateDao;
	@Autowired
	ProductDAO proDao;

	@RequestMapping("/ot/account/index")
	public String index(Model model) {
		Account a = new Account();
		model.addAttribute("item", a);
		List<Account> ac = acDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/account";
	}

	@RequestMapping("/ot/account/edit/{username}")
	public String accountEdit(@PathVariable("username") String username, Model model) {
		Account a = acDao.findById(username).get();
		model.addAttribute("item", a);
		List<Account> ac = acDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/account";
	}

	@RequestMapping("/ot/account/delete/{username}")
	public String accountDelete(@PathVariable("username") String username, Model model) {
		acDao.deleteById(username);
		return "redirect:/ot/account/index";
	}

	@RequestMapping("/ot/account/create")
	public String accountCre(Account item) {
		acDao.save(item);
		return "redirect:/ot/account/index";
	}

	@RequestMapping("/ot/account/update")
	public String accountUp(Account item, Model model) {
		acDao.save(item);
		Account items = acDao.save(item);
		model.addAttribute("item", items);
		return "redirect:/ot/account/edit/" + item.getUsername();
	}

	// categories
	@RequestMapping("/ot/categories/index")
	public String Cate(Model model) {
		Category a = new Category();
		model.addAttribute("item", a);
		List<Category> ac = cateDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/category";
	}

	@RequestMapping("/ot/categories/edit/{id}")
	public String CateEdit(@PathVariable("id") String id, Model model) {
		Category a = cateDao.findById(id).get();
		model.addAttribute("item", a);
		List<Category> ac = cateDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/category";
	}

	@RequestMapping("/ot/categories/delete/{id}")
	public String CateDelete(@PathVariable("id") String id, Model model) {
		cateDao.deleteById(id);
		return "redirect:/ot/categories/index";
	}

	@RequestMapping("/ot/categories/create")
	public String CateCre(@Validated @ModelAttribute("item") Category item,Errors error, Model model) {
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui long nhap du lieu hop le");
		} else {
			model.addAttribute("message", "Chuc mung, Du lieu da nhap hop le");
		}
		cateDao.save(item);
		return "redirect:/ot/categories/index";
	}

	@RequestMapping("/ot/categories/update")
	public String CateUp(Category item, Model model) {
		cateDao.save(item);
		Category items = cateDao.save(item);
		model.addAttribute("item", items);
		return "redirect:/ot/categories/edit/" + item.getId();
	}

	// Product
	@RequestMapping("/ot/pro/index")
	public String Pro(Model model) {
		Product a = new Product();
		model.addAttribute("item", a);
		List<Product> ac = proDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/product";
	}

	@RequestMapping("/ot/pro/edit/{id}")
	public String ProEdit(@PathVariable("id") Integer id, Model model) {
		Product a = proDao.findById(id).get();
		model.addAttribute("item", a);
		List<Product> ac = proDao.findAll();
		model.addAttribute("items", ac);
		return "/on_tap/product";
	}

	@RequestMapping("/ot/pro/delete/{id}")
	public String ProDelete(@PathVariable("id") Integer id, Model model) {
		proDao.deleteById(id);
		return "redirect:/ot/pro/index";
	}

	@RequestMapping("/ot/pro/create")
	public String ProCre(Product item) {
		proDao.save(item);
		return "redirect:/ot/pro/index";
	}

	@RequestMapping("/ot/pro/update")
	public String ProUp(Product item, Model model) {
		proDao.save(item);
		Product items = proDao.save(item);
		model.addAttribute("item", items);
		return "redirect:/ot/pro/edit/" + item.getId();
	}
}
