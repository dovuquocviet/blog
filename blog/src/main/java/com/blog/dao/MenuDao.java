package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {

}
