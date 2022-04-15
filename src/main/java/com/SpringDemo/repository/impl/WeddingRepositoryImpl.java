/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringDemo.repository.impl;

import com.SpringDemo.pojo.Wedding;
import com.SpringDemo.repository.WeddingRepository;
import static java.lang.String.format;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
@PropertySource("classpath:info.properties")
public class WeddingRepositoryImpl implements WeddingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Wedding> getWeddings(String kw, String collum, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Wedding> w = b.createQuery(Wedding.class);

        Root root = w.from(Wedding.class);
        w.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            w.where(p);
        }

        w.orderBy(b.desc(root.get("idWedding")));

        Query query = session.createQuery(w);

        int pageSize = Integer.parseInt(env.getProperty("info.page_size"));
        int start = (page - 1) * pageSize;

        query.setMaxResults(pageSize);
        query.setFirstResult(start);

        return query.getResultList();
    }

    @Override
    public int countWeds() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query w = session.createQuery("SELECT COUNT(*) FROM Wedding ");

        Object re = w.getSingleResult();

        return Integer.parseInt(re.toString());
    }

    @Override
    public boolean addOrUpdateWedding(Wedding w) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.saveOrUpdate(w);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Wedding getWeddingById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Wedding.class, id);
    }

    @Override
    public boolean deleteWedding(Wedding w) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(w);
            return true;
        } catch (Exception ex) {
            return  false;
        }
    }
    @Override
    public List<Wedding> getAllWeddings(){
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Wedding> w = b.createQuery(Wedding.class);

        Root root = w.from(Wedding.class);
        w.select(root);

        
        w.orderBy(b.desc(root.get("idWedding")));

        Query query = session.createQuery(w);


        return query.getResultList();
    }
    
    
    @Override
    public List<Wedding> getFindWeddings(String kw){
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Wedding> w = b.createQuery(Wedding.class);

        Root root = w.from(Wedding.class);
        w.select(root);



        Query query = session.createQuery(w);

        List<Wedding> weddings = query.getResultList();
        

        return weddings;
    }

    @Override
    public List<Wedding> SortDescWeddings() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Wedding> w = b.createQuery(Wedding.class);

        Root root = w.from(Wedding.class);
        w.select(root);

        
        w.orderBy(b.desc(root.get("price")));

        Query query = session.createQuery(w);


        return query.getResultList();
    }

    @Override
    public List<Wedding> ascDescWeddings() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Wedding> w = b.createQuery(Wedding.class);

        Root root = w.from(Wedding.class);
        w.select(root);

        
        w.orderBy(b.asc(root.get("price")));

        Query query = session.createQuery(w);


        return query.getResultList();
    }
}
