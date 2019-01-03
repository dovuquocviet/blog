package com.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@Column(name = "menuId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;

	@Column(name = "menuName", nullable = false)
	private String menuName;

//	@Column(name = "createDate")
//	private String createDate;
//
//	@Column(name = "updateDate")
//	private String updateDate;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

//	public String getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}
//
//	public String getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(String updateDate) {
//		this.updateDate = updateDate;
//	}

}
