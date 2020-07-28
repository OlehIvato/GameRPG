package spring.service;

import spring.model.databaseModel.MobsModel;

import java.util.List;

public interface MobsService {


    List<MobsModel> findAll();

    MobsModel findOneById(Long id);

    MobsModel save(MobsModel heroModel);

    void delete(Long id);

}
