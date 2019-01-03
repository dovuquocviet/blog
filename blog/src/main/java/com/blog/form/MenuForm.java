package com.blog.form;

import javax.validation.constraints.NotEmpty;

public class MenuForm {

	private Integer menuId;

	@NotEmpty(message = "{validation.menuNameNotEmpty}")
	private String menuName;

	public MenuForm() {
		// TODO Auto-generated constructor stub
	}

	public MenuForm(Integer menuId, String menuName) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
}
