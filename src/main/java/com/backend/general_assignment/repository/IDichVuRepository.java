package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.DichVuEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDichVuRepository extends CrudRepository<DichVuEntity, String> {
    List<DichVuEntity> findAll();

    DichVuEntity findByMaDV(String maDV);

    void deleteByMaDV(String maDV);

    @Query(value = "SELECT * FROM dich_vu d WHERE CONCAT(d.maDV, ' ', d.donGia, ' ', d.donViTinh, ' ', d.tenDV) LIKE %?1%", nativeQuery = true)
    List<DichVuEntity> search(String keyword);

}
