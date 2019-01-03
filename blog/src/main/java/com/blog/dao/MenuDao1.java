package com.blog.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.blog.entity.Menu;

@Repository
public class MenuDao1 {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public MenuDao1() {
		// TODO Auto-generated constructor stub
	}

	public void createMenu(Menu menu) {
		if (menu.getMenuId() == 0) {
			hibernateTemplate.save(menu);
		} else {
			hibernateTemplate.update(menu);
		}

	}

	public Menu findById(int id) {
		return hibernateTemplate.get(Menu.class, id);
	}

	public List<Menu> findByKeyWord(String keyWord, int start) {
		List<Menu> result = hibernateTemplate.execute(new HibernateCallback<List<Menu>>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public List<Menu> doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT * FROM menu";
				if (keyWord != "") {
					hql += " WHERE menuName LIKE '%:keyWord%'";
				}
				hql += " LIMIT :start,10";
				
				SQLQuery query = session.createSQLQuery(hql);
				query.addEntity(Menu.class);
				if (keyWord != "") {
					query.setParameter("keyWord", keyWord);
				}
				query.setParameter("start", start);
				return query.list();
			}
		});
		return result;
	}
}
