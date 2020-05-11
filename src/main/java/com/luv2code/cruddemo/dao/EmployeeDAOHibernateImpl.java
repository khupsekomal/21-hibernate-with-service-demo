package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entitymanager
    private EntityManager entityManager;

    //constructor injection for entitymanager
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityMnager) {
        entityManager = theEntityMnager;
    }

    @Override
    public List<Employee> findAll() {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query<Employee> theQuery = currentSession.createQuery("from Employee");

        //execute query and get result list
        List<Employee> results = theQuery.getResultList();
        //return results
        return results;

    }

    @Override
    public Employee findById(int id) {
        //get hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        // Employee employee = currentSession.get(Employee.class,id);

        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        //get hibernate current session
        Session currentSession = entityManager.unwrap(Session.class);

        //save employee object
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {
        //get current session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query query = currentSession.createQuery("delete from Employee where id=:thId");
        query.setParameter("thId", id);
        //execute query

        query.executeUpdate();
    }
}
