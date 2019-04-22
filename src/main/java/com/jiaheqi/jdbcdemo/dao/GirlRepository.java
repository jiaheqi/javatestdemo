package com.jiaheqi.jdbcdemo.dao;

import com.jiaheqi.jdbcdemo.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repository栈的意思
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer age);
}
