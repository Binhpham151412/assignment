package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.KhachHangEntity;
import com.backend.general_assignment.entity.SuDungMayEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISuDungMayRepository extends CrudRepository<SuDungMayEntity, Object> {
    List<SuDungMayEntity> findAll();

    @Query(value = "insert into su_dung_may values (maKH='asdasd' , maMay='m0002', thoiGianSD='143', ngayBDSD='2023-01-05', gioBDSD='11:25:11')",nativeQuery = true)
    void customerSave();
//    SuDungMayEntity findByMAndSuDungMay_mayAndAndSuDungMay_khachHangAndAndGioBDSDAndAndNgayBDSD(SuDungMayEntity suDungMayEntity);
//
//    @Query(value = "SELECT * FROM su_dung_may sdm WHERE CONCAT(sdm.maKH, ' ', sdm.maMay, ' ', sdm.gioBDSD, ' ', sdm.ngayBDSD, ' ', sdm.thoiGianSD) LIKE %?1%",
//            nativeQuery = true)
//    List<SuDungMayEntity> search(String keyword);
}
