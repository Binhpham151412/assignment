package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends CrudRepository<KhachHangEntity, String> {
    List<KhachHangEntity> findAll();

    KhachHangEntity findByMaKH(String maKH);

    void deleteByMaKH(String maKH);

    @Query(value = "SELECT * FROM khach_hang k WHERE CONCAT(k.maKH, ' ', k.diaChi, ' ', k.email, ' ', k.soDT, ' ', k.tenKH) LIKE %?1%",
            nativeQuery = true)
    List<KhachHangEntity> search(String keyword);
}
