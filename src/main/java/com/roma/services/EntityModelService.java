package com.roma.services;

import com.roma.data.dao.EntityModelDao;
import com.roma.data.models.MyEntityModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;

import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public class EntityModelService {

    @Inject
    private EntityModelDao entityModelDao;

    public void saveModel(MyEntityModel model) {
        entityModelDao.save(model);
    }

    public void clearTable(){entityModelDao.clear();}

    public List<MyEntityModel> findAllUsers() {
        return entityModelDao.findAll();
    }

}
