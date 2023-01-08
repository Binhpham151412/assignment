package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.SuDungMayEntity;
import com.backend.general_assignment.repository.IKhachHangRepository;
import com.backend.general_assignment.repository.IMayRepository;
import com.backend.general_assignment.repository.ISuDungMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        suDungMayEntity.setSuDungMay_may(mayRepository.findByMaMay(suDungMayEntity.getSuDungMay_may().getMaMay()));
        suDungMayEntity.setSuDungMay_khachHang(khachHangRepository.findByMaKH(suDungMayEntity.getSuDungMay_khachHang().getMaKH()));
        suDungMayRepository.save(suDungMayEntity);
    }


//    @Transactional
//    public KhachHangEntity findByMaKH(String maKH) {
//        return khachHangRepository.findByMaKH(maKH);
//    }
//
//    @Transactional
//    public void deleteByMaKH(String maKH) {
//        khachHangRepository.deleteByMaKH(maKH);
//    }

//    @Transactional
//    public List<SuDungMayEntity> listSearch(String keyword) {
////        Sort sort = Sort.by(sortField);
////        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
////
////        Pageable pageable = PageRequest.of(pageNumber - 1, 2, sort);
//        if (keyword != null) {
//            return suDungMayRepository.search(keyword);
//        }
//        return suDungMayRepository.findAll();
//    }
}
