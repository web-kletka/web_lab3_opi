package com.roma.services;

import com.roma.data.dao.EntityModelDao;
import com.roma.data.models.MyEntityModel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class EntityModelService {

    private final EntityModelDao entityModelDao = new EntityModelDao();

    public void saveModel(MyEntityModel model) {
        entityModelDao.save(model);
    }

    public void clearTable(){entityModelDao.clear();}

    public List<MyEntityModel> findAllUsers() {
        return entityModelDao.findAll();
    }

}
