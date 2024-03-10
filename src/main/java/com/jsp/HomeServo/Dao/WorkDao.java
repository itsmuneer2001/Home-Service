package com.jsp.HomeServo.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.Dto.Work;
import com.jsp.HomeServo.Repo.WorkRepo;

@Repository
public class WorkDao {
	@Autowired
	private WorkRepo repo;

	public Work saveWork(Work work) {
		return repo.save(work);
	}

	public Work getWorkById(int id) {
		if (repo.findById(id).isPresent()) {
			Work work = repo.findById(id).get();
			return work;
		}
		return null;
	}
	public List<Work> getListOfWork() {
		List<Work> list = repo.listOfWork();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	public Work updateById(Work work) {
		if (repo.findById(work.getId()).isPresent()) {
			Work dataBase = repo.findById(work.getId()).get();
			if (work.getTypeOfWork() == null) {
				work.setTypeOfWork(dataBase.getTypeOfWork());
			}
					}
		return null;
	}

}
