package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.IdClass.SuDungDichVuId;
import com.backend.general_assignment.entity.IdClass.SuDungMayId;
import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.entity.SuDungDichVuEntity;
import com.backend.general_assignment.entity.SuDungMayEntity;
import com.backend.general_assignment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SuDungDichVuService {
    @Autowired
    private ISuDungDichVuRepository suDungDichVuRepository;
    @Autowired
    private IDichVuRepository dichVuRepository;
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Transactional
    public List<SuDungDichVuEntity> findAll() {
        return suDungDichVuRepository.findAll();
    }

    @Transactional
    public void save(SuDungDichVuEntity suDungDichVuEntity) {
        suDungDichVuEntity.setSuDungDV_maKH(khachHangRepository.findByMaKH(suDungDichVuEntity.getSuDungDV_maKH().getMaKH()));
        suDungDichVuEntity.setSuDungDV_maDV(dichVuRepository.findByMaDV(suDungDichVuEntity.getSuDungDV_maDV().getMaDV()));
        suDungDichVuRepository.save(suDungDichVuEntity);
    }

    @Transactional
    public Optional<SuDungDichVuEntity> findBySuDungMayId(SuDungDichVuId suDungDichVuId) {
        return suDungDichVuRepository.findById(suDungDichVuId);
    }

    @Transactional
    public void deleteBySuDungDichVuId(SuDungDichVuId suDungDichVuId) {
        suDungDichVuRepository.deleteById(suDungDichVuId);
    }

    @Transactional
    public List<SuDungDichVuEntity> listSearch(String keyword) {
        if (keyword != null) {
            return suDungDichVuRepository.search(keyword);
        }
        return suDungDichVuRepository.findAll();
    }

    @Transactional
    public Page<SuDungDichVuEntity> findAll(int page){
        int pageSize = 4;
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return suDungDichVuRepository.findAll(pageable);
    }

    @Transactional
    public List<Object[]> findAllInfo() {
        return suDungDichVuRepository.findAllInfo();
    }

//    @Transactional
//    public Page<Object[]> findAll(int page){
//        int pageSize = 4;
//        Pageable pageable = PageRequest.of(page-1,pageSize);
//        return suDungDichVuRepository.findAll(pageable);
//    }
}
