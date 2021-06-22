package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.CustomerModel;

/**
 * Dao implementation class consist of all customer related queries.
 *
 */
@Repository
public class CustomerDaoImplementation implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Save/update customer.
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(CustomerModel customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	/**
	 * Get all customers
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ArrayList<CustomerModel> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		return (ArrayList<CustomerModel>) session.createQuery("from CustomerModel").getResultList();
	}

	/**
	 * Find customer based on customer id
	 */
	@Override
	public Optional<CustomerModel> findByCustomerId(int userId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Query<CustomerModel> query = sessionFactory.getCurrentSession()
				.createQuery("from CustomerModel where userId=:customerId");
		query.setParameter("customerId", userId);

		return query.getResultStream().findFirst();
	}

}
