package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blog.entity.Menu;
import com.blog.form.MenuForm;
import com.blog.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService menuService;

	@GetMapping("/createMenu")
	public String creaeteMenu(Model model) {
		model.addAttribute("menuForm", new MenuForm());
		return "admin/createMenu";
	}

	@GetMapping("/updateMenu")
	public String updateMenu(Model model, Integer id) {
		if (id == null) {
			return "redirect:/";
		}
		MenuForm menuForm = menuService.findById(id);
		if (menuForm == null) {
			return "redirect:/";
		}
		model.addAttribute("menuForm", menuForm);
		return "admin/createMenu";
	}

	@PostMapping("/createMenu")
	public String creaeteMenu(Model model, @ModelAttribute("menuForm") @Valid MenuForm menuForm,
			BindingResult bindingResult) {
		// Check if error
		if (bindingResult.hasErrors()) {
			// If create menu - else update menu
			if (menuForm.getMenuId() == null) {
				model.addAttribute("menuForm", new MenuForm());
				return "admin/createMenu";
			}
			return "redirect:/updateMenu?id=" + menuForm.getMenuId();
		}

		menuService.createMenu(menuForm);
		// If create menu - else update menu
		if (menuForm.getMenuId() == null) {
			model.addAttribute("menuForm", new MenuForm());
			return "redirect:/";
		}
		return "redirect:/updateMenu?id=" + menuForm.getMenuId();
	}

	@GetMapping("/listMenu")
	public String listMenu(Model model, String keyWord, Integer page) {
		keyWord = keyWord == null ? "" : keyWord;
		page = page == null ? 0 : page;
		List<Menu> menus = menuService.findByKeyWord(keyWord, page);
		model.addAttribute("menus", menus);
		return "admin/listMenu";
	}
}
