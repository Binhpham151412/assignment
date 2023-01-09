package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.IdClass.SuDungMayId;
import com.backend.general_assignment.entity.SuDungMayEntity;
import com.backend.general_assignment.repository.IKhachHangRepository;
import com.backend.general_assignment.repository.IMayRepository;
import com.backend.general_assignment.repository.ISuDungMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SuDungMayService {
    @Autowired
    private ISuDungMayRepository suDungMayRepository;
    @Autowired
    private IMayRepository mayRepository;
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Transactional
    public List<SuDungMayEntity> findAll() {
        return suDungMayRepository.findAll();
    }

    @Transactional
    public void save(SuDungMayEntity suDungMayEntity) {
        suDungMayEntity.setSuDungMay_khachHang(khachHangRepository.findByMaKH(suDungMayEntity.getSuDungMay_khachHang().getMaKH()));
        suDungMayEntity.setSuDungMay_may(mayRepository.findByMaMay(suDungMayEntity.getSuDungMay_may().getMaMay()));
        suDungMayRepository.save(suDungMayEntity);
    }


    @Transactional
    public Optional<SuDungMayEntity> findBySuDungMayId(SuDungMayId suDungMayId) {
        return suDungMayRepository.findById(suDungMayId);
    }

    @Transactional
    public void deleteBySuDungMayId(SuDungMayId suDungMayId) {
        suDungMayRepository.deleteById(suDungMayId);
    }

    @Transactional
    public List<SuDungMayEntity> listSearch(String keyword) {
        if (keyword != null) {
            return suDungMayRepository.search(keyword);
        }
        return suDungMayRepository.findAll();
    }
}
