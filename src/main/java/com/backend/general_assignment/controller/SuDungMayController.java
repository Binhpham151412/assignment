package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.KhachHangEntity;
import com.backend.general_assignment.entity.SuDungMayEntity;
import com.backend.general_assignment.service.KhachHangService;
import com.backend.general_assignment.service.MayService;
import com.backend.general_assignment.service.SuDungMayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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
    public ModelAndView getAllKhachHangWithPageAble() {
        ModelAndView modelAndView = new ModelAndView("sudungmay/list");
        modelAndView.addObject("listSDM", suDungMayService.findAll());
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
                         final BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("sudungmay/add");
            return modelAndView;
        }
        suDungMayEntity.setNgayBDSD(LocalDate.now());
        suDungMayEntity.setGioBDSD(LocalTime.now());
        suDungMayService.save(suDungMayEntity);
        return "redirect:/dang-ky-su-dung-may/list";
    }
//
//    @GetMapping("/edit/{maKH}")
//    public ModelAndView findByMaKH(@PathVariable(name = "maKH") String maKH) {
//        ModelAndView modelAndView = new ModelAndView("khachhang/edit");
//        modelAndView.addObject("khachHangForm", khachHangService.findByMaKH(maKH));
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/save")
//    public Object saveUpdateKhachHang(final @Valid @ModelAttribute(name = "khachHangForm") KhachHangEntity khachHangEntity,
//                                      final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
//        ModelAndView modelAndView;
//        if (bindingResult.hasErrors()) {
//            modelAndView = new ModelAndView("khachhang/edit");
//            return modelAndView;
//        }
//        redirectAttributes.addFlashAttribute("msg_update", "cập nhật thành công dịch vụ " + khachHangEntity.getMaKH());
//        khachHangService.save(khachHangEntity);
//        return "redirect:/khach-hang/list";
//    }
//
//    @GetMapping("/delete/{maKH}")
//    public String deleteKhachHang(final @PathVariable(name = "maKH") String maKH, final RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("msg_delete", "xóa thành công máy " + maKH);
//        khachHangService.deleteByMaKH(maKH);
//        return "redirect:/khach-hang/list";
//    }
//
//    @GetMapping("/search")
//    public ModelAndView searchDichVu(Model model, @Param("keyword") String keyword) {
//        ModelAndView modelAndView = new ModelAndView("khachhang/search");
//        List<KhachHangEntity> entityList = khachHangService.listSearch(keyword);
//        model.addAttribute("listSearch", entityList);
//        model.addAttribute("keyword", keyword);
//        return modelAndView;
//    }
}
