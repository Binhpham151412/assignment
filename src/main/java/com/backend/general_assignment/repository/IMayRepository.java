package com.backend.general_assignment.repository;

import com.backend.general_assignment.entity.MayEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMayRepository extends CrudRepository<MayEntity, String> {
    List<MayEntity> findAll();

    MayEntity findByMaMay(String maMay);

    void deleteByMaMay(String maMay);

    @Query(value = "SELECT * FROM may m WHERE CONCAT(m.maMay, ' ', m.trangThai, ' ', m.viTri) LIKE %?1%", nativeQuery = true)
    List<MayEntity> search(String keyword);

    Page<MayEntity> findAll(Pageable pageable);

}
