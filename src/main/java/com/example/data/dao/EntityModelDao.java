package com.example.data.dao;

import com.example.data.models.MyEntityModel;

import jakarta.persistence.EntityManager;
import java.util.List;


public class EntityModelDao {

    private final EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    public void clear(){
        em.getTransaction().begin();
        em.createQuery("delete from MyEntityModel").executeUpdate();
        em.getTransaction().commit();
    }

    public void save(MyEntityModel model) {
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();
    }

    public List<MyEntityModel> findAll() {
        em.getTransaction().begin();
        List<MyEntityModel> list = em.createQuery("from MyEntityModel", MyEntityModel.class).getResultList();
        em.getTransaction().commit();
        return list;
    }
}
