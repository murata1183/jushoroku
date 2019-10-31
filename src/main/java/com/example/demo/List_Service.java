package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)

public class List_Service {
	@Autowired
	private List_Repository list_Repository;


	public void create(List_Entity list_Entity) {
		list_Repository.save(list_Entity);
	}

	public List<List_Entity> searchAll() {
		return list_Repository.findAll();
	}

	public List_Entity findById(Long No) {
		return list_Repository.findById(No).get();
	}
	public void update(List_Entity list_Entity) {
		list_Repository.save(list_Entity);
	}
	public void Update(List_Entity list_Entity) {
		list_Repository.save(list_Entity);
	}
	/**public Page<List_Entity> getAllWord(Pageable pageable) {

        return list_Repository.findAll(pageable);
    }*/


}
