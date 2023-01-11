package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.IdClass.SuDungMayId;
import com.backend.general_assignment.entity.SuDungMayEntity;
import com.backend.general_assignment.service.KhachHangService;
import com.backend.general_assignment.service.MayService;
import com.backend.general_assignment.service.SuDungMayService;
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
@RequestMapping("/dang-ky-su-dung-may")
public class SuDungMayController {
    @Autowired
    private SuDungMayService suDungMayService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private MayService mayService;

    @GetMapping("/list")
    public ModelAndView getAllSDMWithPageAble(final @RequestParam(defaultValue = "1") int page) {
//        ModelAndView modelAndView = new ModelAndView("sudungmay/list");
//        modelAndView.addObject("listSDM", suDungMayService.findAll());
//        return modelAndView;

        Page<SuDungMayEntity> page2 = suDungMayService.findAll(page);
        List<SuDungMayEntity> list = page2.getContent();
        ModelAndView modelAndView = new ModelAndView("sudungmay/list");
        modelAndView.addObject("listSDM", list);

        int totalItems = page2.getNumberOfElements();
        int totalPages = page2.getTotalPages();
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("currentPage", page);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddFormSDM() {
        ModelAndView modelAndView = new ModelAndView("sudungmay/add");
        modelAndView.addObject("SDMForm", new SuDungMayEntity());
        modelAndView.addObject("khachhang", khachHangService.findAll());
        modelAndView.addObject("may", mayService.findAll());
        return modelAndView;
    }

    @PostMapping("/add")
    public Object addSDM(final @Valid @ModelAttribute("SDMForm") SuDungMayEntity suDungMayEntity,
                         final BindingResult bindingResult,
                         final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("sudungmay/add");
            modelAndView.addObject("khachhang", khachHangService.findAll());
            modelAndView.addObject("may", mayService.findAll());
            return modelAndView;
        }
        suDungMayEntity.setNgayBDSD(LocalDate.now());
        suDungMayEntity.setGioBDSD(LocalTime.now());
        redirectAttributes.addFlashAttribute("msg_saveSDM", "lưu thành công khách sử dụng máy "
                + suDungMayEntity.getSuDungMay_khachHang().getMaKH()
                + ", " + suDungMayEntity.getSuDungMay_may().getMaMay()
                + ", " + suDungMayEntity.getNgayBDSD()
                + ", " + suDungMayEntity.getGioBDSD()
                + ", " + suDungMayEntity.getThoiGianSD());
        suDungMayService.save(suDungMayEntity);
        return "redirect:/dang-ky-su-dung-may/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView findBySuDungMayId(final @RequestParam(name = "idKH") String idKH,
                                          final @RequestParam(name = "idMay") String idMay,
                                          final @RequestParam(name = "ngaySD") String ngaySD,
                                          final @RequestParam(name = "gioSD") String gioSD) {
        ModelAndView modelAndView = new ModelAndView("sudungmay/edit");
        SuDungMayId suDungMayId = new SuDungMayId();
        suDungMayId.setSuDungMay_khachHang(idKH);
        suDungMayId.setSuDungMay_may(idMay);
        suDungMayId.setNgayBDSD(LocalDate.parse(ngaySD));
        suDungMayId.setGioBDSD(LocalTime.parse(gioSD));
        Optional<SuDungMayEntity> suDungMayEntity = suDungMayService.findBySuDungMayId(suDungMayId);
        modelAndView.addObject("SDMForm", suDungMayEntity.get());
        modelAndView.addObject("khachhang", khachHangService.findAll());
        modelAndView.addObject("may", mayService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public Object saveUpdateSuDungMayId(@Valid @ModelAttribute(name = "SDMForm") SuDungMayEntity suDungMayEntity,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("sudungmay/edit");
            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("msg_updateSDM", "cập nhật thành công dịch vụ "
                + suDungMayEntity.getSuDungMay_khachHang().getMaKH()
                + ", " + suDungMayEntity.getSuDungMay_may().getMaMay()
                + ", " + suDungMayEntity.getNgayBDSD()
                + ", " + suDungMayEntity.getGioBDSD());

        suDungMayService.save(suDungMayEntity);
        return "redirect:/dang-ky-su-dung-may/list";
    }

    @GetMapping("/delete")
    public String deleteSuDungMay(@RequestParam(name = "idKH") String idKH,
                                  @RequestParam(name = "idMay") String idMay,
                                  @RequestParam(name = "ngaySD") String ngaySD,
                                  @RequestParam(name = "gioSD") String gioSD,
                                  final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_deleteSDM", "xóa thành công máy " + idKH);
        SuDungMayId suDungMayId = new SuDungMayId();
        suDungMayId.setSuDungMay_khachHang(idKH);
        suDungMayId.setSuDungMay_may(idMay);
        suDungMayId.setNgayBDSD(LocalDate.parse(ngaySD));
        suDungMayId.setGioBDSD(LocalTime.parse(gioSD));
        suDungMayService.deleteBySuDungMayId(suDungMayId);
        return "redirect:/dang-ky-su-dung-may/list";
    }

    @GetMapping("/search")
    public ModelAndView searchDichVu(final @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("sudungmay/search");
        List<SuDungMayEntity> entityList = suDungMayService.listSearch(keyword);
        modelAndView.addObject("listSearch", entityList);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }
}
