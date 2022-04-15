/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.repository.impl;

import com.SpringDemo.pojo.Booking;
import com.SpringDemo.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author billg
 */
@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Booking> getBooking(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Booking> w = b.createQuery(Booking.class);

        Root root = w.from(Booking.class);
        w.select(root);

        int count = 0;

        Query query = session.createQuery(w);
        List<Booking> bookings = query.getResultList();
        List<Booking> bookings2 = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            
            if (bookings.get(i).getUsername().getUsername().trim().equals(username.trim())) {
                bookings2.add(bookings.get(i));
            }
            else{
                
            }
        }
        
        return bookings2;
    }

    @Override
    public boolean addBook(Booking book) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(book);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public int countBookingByWedding̣̣̣̣̣(int wedID){
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query w = session.createQuery("SELECT COUNT(*) FROM Booking where idWedding = '"+wedID+"'");

        Object re = w.getSingleResult();

        return Integer.parseInt(re.toString());
    }
}
