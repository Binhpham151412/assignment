package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.DichVuEntity;
import com.backend.general_assignment.repository.IDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DichVuService {
    @Autowired
    private IDichVuRepository dichVuRepository;

    @Transactional
    public List<DichVuEntity> findAll() {
        return dichVuRepository.findAll();
    }

    @Transactional
    public void save(DichVuEntity dichVuEntity) {
        dichVuRepository.save(dichVuEntity);
    }

    @Transactional
    public DichVuEntity findByMaDV(String maDV) {
        return dichVuRepository.findByMaDV(maDV);
    }

    @Transactional
    public void deleteByMaDV(String maDV) {
        dichVuRepository.deleteByMaDV(maDV);
    }

    @Transactional
    public List<DichVuEntity> listSearch(String keyword) {
        if (keyword != null) {
            return dichVuRepository.search(keyword);
        }
        return dichVuRepository.findAll();
    }

    @Transactional
    public Page<DichVuEntity> findAll(int page) {
        int pageSize = 4;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return dichVuRepository.findAll(pageable);
    }
}
