package com.tcs.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.management.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{

    Application findByName(String name);

   

    

    
}
