package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.repository.IMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MayService {
    @Autowired
    private IMayRepository mayRepository;

    @Transactional
    public List<MayEntity> findAll() {
        return mayRepository.findAll();
    }

    @Transactional
    public void save(MayEntity mayEntity) {
        mayRepository.save(mayEntity);
    }

    @Transactional
    public MayEntity findByMaMay(String maMay) {
        return mayRepository.findByMaMay(maMay);
    }

    @Transactional
    public void deleteByMaMay(String maMay) {
        mayRepository.deleteByMaMay(maMay);
    }

    @Transactional
    public List<MayEntity> listSearch(String keyword) {

        if (keyword != null) {
            return mayRepository.search(keyword);
        }
        return mayRepository.findAll();
    }

    public Page<MayEntity> findAll(int page) {
        int pageSize = 4;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return mayRepository.findAll(pageable);
    }
}
