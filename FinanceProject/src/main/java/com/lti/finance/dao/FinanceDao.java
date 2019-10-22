package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.lti.finance.entity.User;

@Repository 
public class FinanceDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public User fetchByUsername(String username){
		String query="select u from User u where u.userName=:un";
		Query q =entityManager.createQuery(query);
		q.setParameter("un", username);
		//try catch for username invalid 
		return (User)q.getSingleResult();
	}
	

}
