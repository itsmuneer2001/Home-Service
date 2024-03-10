package com.jsp.HomeServo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.HomeServo.Dto.Work;

public interface WorkRepo extends JpaRepository<Work, Integer>{
	@Query("select a from Work a where a.startDate=null")
	public List<Work> listOfWork();
}
