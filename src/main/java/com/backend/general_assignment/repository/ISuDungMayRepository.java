package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.IdClass.SuDungMayId;
import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.entity.SuDungMayEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISuDungMayRepository extends CrudRepository<SuDungMayEntity, SuDungMayId> {
    List<SuDungMayEntity> findAll();

    @Override
    Optional<SuDungMayEntity> findById(SuDungMayId suDungMayId);

    @Override
    void deleteById(SuDungMayId suDungMayId);

    @Query(value = "SELECT * FROM su_dung_may sdm WHERE CONCAT(sdm.maKH, ' ', sdm.maMay, ' ', sdm.thoiGianSD) LIKE %?1%", nativeQuery = true)
    List<SuDungMayEntity> search(String keyword);
}


