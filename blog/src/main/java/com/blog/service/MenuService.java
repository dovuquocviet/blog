package com.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.MenuDao;
import com.blog.entity.Menu;
import com.blog.form.MenuForm;

@Service
@Transactional
public class MenuService {

//	@Autowired
//	MenuDao1 menuDao1;

	@Autowired
	private MenuDao menuDao;

	public void createMenu(MenuForm menuForm) {
		menuDao.save(convertToMenu(menuForm));
		// menuDao1.createMenu(convertToMenu(menuForm));
	}

	public MenuForm findById(int id) {
		return convertToMenuForm(menuDao.findById(id).orElse(new Menu()));
	}

	public List<Menu> findByKeyWord(String keyWord, int start) {
//		return menuDao1.findByKeyWord(keyWord, start);
		return null;
	}

	private Menu convertToMenu(MenuForm menuForm) {
		Menu menu = new Menu();
		if (menuForm.getMenuId() != null) {
			menu.setMenuId(menuForm.getMenuId());
		}
		menu.setMenuName(menuForm.getMenuName());
		return menu;
	}

	private MenuForm convertToMenuForm(Menu menu) {
		if (menu == null)
			return null;
		MenuForm menuForm = new MenuForm();
		menuForm.setMenuId(menu.getMenuId());
		menuForm.setMenuName(menu.getMenuName());
		return menuForm;
	}

	// private List<MenuForm> convertToListMenuForm(List<Menu> menus) {
	// List<MenuForm> menuForms = new ArrayList<>();
	// for (Menu menu : menus) {
	// MenuForm menuForm = convertToMenuForm(menu);
	// menuForms.add(menuForm);
	// }
	// return menuForms;
	// }
}
