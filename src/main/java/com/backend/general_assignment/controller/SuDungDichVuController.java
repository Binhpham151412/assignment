package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.IdClass.SuDungDichVuId;
import com.backend.general_assignment.entity.SuDungDichVuEntity;
import com.backend.general_assignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/su-dung-dich-vu")
public class SuDungDichVuController {
    @Autowired
    private SuDungDichVuService suDungDichVuService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private MayService mayService;
    @Autowired
    private SuDungMayService suDungMayService;

    @GetMapping("/list")
    public ModelAndView getAllSDDVWithPageAble(final @RequestParam(defaultValue = "1") int page) {
//        ModelAndView modelAndView = new ModelAndView("sudungdichvu/list");
//        modelAndView.addObject("listSDDV", suDungDichVuService.findAll());
//        return modelAndView;

        Page<SuDungDichVuEntity> page2 = suDungDichVuService.findAll(page);
        List<SuDungDichVuEntity> list = page2.getContent();
        ModelAndView modelAndView = new ModelAndView("sudungdichvu/list");
        modelAndView.addObject("listSDDV", list);

        int totalItems = page2.getNumberOfElements();
        int totalPages = page2.getTotalPages();
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("currentPage", page);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddFormSDDV() {
        ModelAndView modelAndView = new ModelAndView("sudungdichvu/add");
        modelAndView.addObject("SDDVForm", new SuDungDichVuEntity());
        modelAndView.addObject("khachhang", khachHangService.findAll());
        modelAndView.addObject("dichvu", dichVuService.findAll());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addSDM(final @Valid @ModelAttribute("SDDVForm") SuDungDichVuEntity suDungDichVuEntity,
                         final BindingResult bindingResult,
                         final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/su-dung-dich-vu/add";
        }
        suDungDichVuEntity.setNgaySD(LocalDate.now());
        suDungDichVuEntity.setGioSD(LocalTime.now());
        redirectAttributes.addFlashAttribute("msg_saveSDDV", "lưu thành công khách sử dụng dịch vụ");
        suDungDichVuService.save(suDungDichVuEntity);
        return "redirect:/su-dung-dich-vu/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView findBySuDungMayId(final @RequestParam(name = "idKH") String idKH,
                                          final @RequestParam(name = "idDV") String idDV,
                                          final @RequestParam(name = "ngaySD") String ngaySD,
                                          final @RequestParam(name = "gioSD") String gioSD) {
        ModelAndView modelAndView = new ModelAndView("sudungdichvu/edit");
        SuDungDichVuId suDungDichVuId = new SuDungDichVuId();
        suDungDichVuId.setSuDungDV_maKH(idKH);
        suDungDichVuId.setSuDungDV_maDV(idDV);
        suDungDichVuId.setNgaySD(LocalDate.parse(ngaySD));
        suDungDichVuId.setGioSD(LocalTime.parse(gioSD));
        Optional<SuDungDichVuEntity> suDungDichVuEntity = suDungDichVuService.findBySuDungMayId(suDungDichVuId);
        modelAndView.addObject("SDDVForm", suDungDichVuEntity.get());
        modelAndView.addObject("khachhang", khachHangService.findAll());
        modelAndView.addObject("dichvu", dichVuService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public Object saveUpdateSuDungMayId(final @Valid @ModelAttribute(name = "SDDVForm") SuDungDichVuEntity suDungDichVuEntity,
                                        final BindingResult bindingResult,
                                        final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("sudungdichvu/edit");
            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("msg_updateSDDV", "cập nhật thành công dịch vụ "
                + suDungDichVuEntity.getSuDungDV_maKH().getMaKH()
                + ", " + suDungDichVuEntity.getSuDungDV_maDV().getMaDV()
                + ", " + suDungDichVuEntity.getNgaySD()
                + ", " + suDungDichVuEntity.getGioSD()
                + ", " + suDungDichVuEntity.getSoLuong());

        suDungDichVuService.save(suDungDichVuEntity);
        return "redirect:/su-dung-dich-vu/list";
    }

    @GetMapping("/delete")
    public String deleteSuDungMay(final @RequestParam(name = "idKH") String idKH,
                                  final @RequestParam(name = "idDV") String idDV,
                                  final @RequestParam(name = "ngaySD") String ngaySD,
                                  final @RequestParam(name = "gioSD") String gioSD,
                                  final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_deleteSDDV", "xóa thành công SDDV idKH: " + idKH);
        SuDungDichVuId suDungDichVuId = new SuDungDichVuId();
        suDungDichVuId.setSuDungDV_maKH(idKH);
        suDungDichVuId.setSuDungDV_maDV(idDV);
        suDungDichVuId.setNgaySD(LocalDate.parse(ngaySD));
        suDungDichVuId.setGioSD(LocalTime.parse(gioSD));
        suDungDichVuService.deleteBySuDungDichVuId(suDungDichVuId);
        return "redirect:/su-dung-dich-vu/list";
    }

    @GetMapping("/search")
    public ModelAndView searchDichVu(final @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("sudungdichvu/search");
        List<SuDungDichVuEntity> entityList = suDungDichVuService.listSearch(keyword);
        modelAndView.addObject("listSearch", entityList);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }

    @GetMapping("/tat-ca-thong-tin")
    public ModelAndView tatCaThongTin() {
        ModelAndView modelAndView = new ModelAndView("sudungdichvu/tatcathongtin");
        modelAndView.addObject("listSDDV", suDungDichVuService.findAllInfo());
        return modelAndView;

//        Page<Object[]> page2 = suDungDichVuService.findAll(page);
//        List<Object[]> list = page2.getContent();
//        ModelAndView modelAndView = new ModelAndView("sudungdichvu/tatcathongtin");
//        modelAndView.addObject("listSDDV", list);
//        int totalItems = page2.getNumberOfElements();
//        int totalPages = page2.getTotalPages();
//        modelAndView.addObject("totalPages", totalPages);
//        modelAndView.addObject("totalItems", totalItems);
//        modelAndView.addObject("currentPage", page);
//
//        return modelAndView;
    }

}
