package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.KhachHangEntity;
import com.backend.general_assignment.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Transactional
    public List<KhachHangEntity> findAll() {
        return khachHangRepository.findAll();
    }

    @Transactional
    public void save(KhachHangEntity khachHangEntity) {
        khachHangRepository.save(khachHangEntity);
    }

    @Transactional
    public KhachHangEntity findByMaKH(String maKH) {
        return khachHangRepository.findByMaKH(maKH);
    }

    @Transactional
    public void deleteByMaKH(String maKH) {
        khachHangRepository.deleteByMaKH(maKH);
    }

    @Transactional
    public List<KhachHangEntity> listSearch(String keyword) {
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//
//        Pageable pageable = PageRequest.of(pageNumber - 1, 2, sort);
        if (keyword != null) {
            return khachHangRepository.search(keyword);
        }
        return khachHangRepository.findAll();
    }
}
