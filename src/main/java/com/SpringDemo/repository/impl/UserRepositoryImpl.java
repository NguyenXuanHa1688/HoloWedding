/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.repository.impl;

import com.SpringDemo.pojo.Booking;
import com.SpringDemo.pojo.User;
import com.SpringDemo.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author billg
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public User getUser(String Uname) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, Uname);
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUserByAdmin(User u, String role) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            u.setRole(role);
            session.save(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(User u) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(u);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(u);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> w = b.createQuery(User.class);

        Root root = w.from(User.class);
        w.select(root);

        Query query = session.createQuery(w);
        List<User> users = query.getResultList();
        List<User> users2 = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {

            if (!users.get(i).getUsername().equals("Admin")) {
                users2.add(users.get(i));
            } else {

            }
        }

        return users2;
    }
}
