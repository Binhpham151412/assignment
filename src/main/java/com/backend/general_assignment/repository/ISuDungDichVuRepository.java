package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.IdClass.SuDungDichVuId;
import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.entity.SuDungDichVuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISuDungDichVuRepository extends CrudRepository<SuDungDichVuEntity, SuDungDichVuId> {

    List<SuDungDichVuEntity> findAll();

    @Override
    Optional<SuDungDichVuEntity> findById(SuDungDichVuId suDungDichVuId);

    @Override
    void deleteById(SuDungDichVuId suDungDichVuId);

    @Query(value = "SELECT * FROM su_dung_dich_vu sddv WHERE CONCAT(sddv.maDV, ' ', sddv.maKH, ' ', sddv.soLuong) LIKE %?1%", nativeQuery = true)
    List<SuDungDichVuEntity> search(String keyword);

    @Query(value = "SELECT kh.maKH,\n" +
            "       kh.tenKH,\n" +
            "       m.maMay,\n" +
            "       m.viTri,\n" +
            "       m.trangThai,\n" +
            "       sdm.ngayBDSD,\n" +
            "       sdm.gioBDSD,\n" +
            "       sdm.thoiGianSD,\n" +
            "       sddv.maDV,\n" +
            "       sddv.ngaySD,\n" +
            "       sddv.gioSD,\n" +
            "       sddv.soLuong,\n" +
            "       (dv.donGia * sddv.soLuong) as tt\n" +
            "FROM su_dung_may as sdm\n" +
            "         JOIN khach_hang as kh\n" +
            "              ON sdm.maKH = kh.maKH\n" +
            "         JOIN may as m\n" +
            "              ON sdm.maMay = m.maMay\n" +
            "         JOIN su_dung_dich_vu as sddv\n" +
            "              ON kh.maKH = sddv.maKH\n" +
            "         JOIN dich_vu as dv\n" +
            "              ON sddv.maDV = dv.maDV", nativeQuery = true)
    List<Object[]> findAllInfo();

}
