package spring.service;

import spring.model.databaseModel.BossesModel;

import java.util.List;

public interface BossesService {

    List<BossesModel> findAll();

    BossesModel findOneById(Long id);

    BossesModel save(BossesModel heroModel);

    void delete(Long id);

}
