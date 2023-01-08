package com.backend.general_assignment.service;

import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.repository.IMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MayService {
    @Autowired
    private IMayRepository IMayRepository;

    @Transactional
    public List<MayEntity> findAll() {
        return IMayRepository.findAll();
    }

    @Transactional
    public void save(MayEntity mayEntity) {
        IMayRepository.save(mayEntity);
    }

    @Transactional
    public MayEntity findByMaMay(String maMay) {
        return IMayRepository.findByMaMay(maMay);
    }

    @Transactional
    public void deleteByMaMay(String maMay) {
        IMayRepository.deleteByMaMay(maMay);
    }

    @Transactional
    public List<MayEntity> listSearch(String keyword) {
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//
//        Pageable pageable = PageRequest.of(pageNumber - 1, 2, sort);
        if (keyword != null) {
            return IMayRepository.search(keyword);
        }
        return IMayRepository.findAll();
    }

//    public Page<MayEntity> findWithPageAble(String keyword, Pageable pageable) {
//        return mayRepository.findWithPageAble(keyword, pageable);
//    }
//    @Transactional
//    public List<MayEntity> findWithPageAble (){
//
//    }
}
