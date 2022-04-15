/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.repository.impl;

import com.SpringDemo.pojo.Comment;
import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Comment> getComments(int idWed) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> w = b.createQuery(Comment.class);

        Root root = w.from(Comment.class);
        w.select(root);

        int count = 0;

        Query query = session.createQuery(w);
        List<Comment> comments = query.getResultList();
        List<Comment> cmts2 = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getIdWedding().getIdWedding() == idWed) {
                cmts2.add(comments.get(i));
            }
        }
        return cmts2;
    }

    @Override
    public boolean addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(c);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
