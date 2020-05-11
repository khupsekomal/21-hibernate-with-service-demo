package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List findAll() {

        //create query
        Query query;
        query = entityManager.createQuery("from Employee");

        //execute query

        //return list
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class,id);
    }

    @Override
    public void save(Employee employee) {
        Employee employee1=entityManager.merge(employee);
        employee.setId(employee1.getId());
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=:theId");
        query.setParameter("theId",id);
        query.executeUpdate();
    }
}
