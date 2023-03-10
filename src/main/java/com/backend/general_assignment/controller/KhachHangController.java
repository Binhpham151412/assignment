package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.DichVuEntity;
import com.backend.general_assignment.entity.KhachHangEntity;
import com.backend.general_assignment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/list")
    public ModelAndView getAllKhachHangWithPageAble(final @RequestParam(defaultValue = "1") int page) {
//        ModelAndView modelAndView = new ModelAndView("khachhang/list");
//        modelAndView.addObject("listKH", khachHangService.findAll());
//        return modelAndView;

        Page<DichVuEntity> page2 = khachHangService.findAll(page);
        List<DichVuEntity> list = page2.getContent();
        ModelAndView modelAndView = new ModelAndView("khachhang/list");
        modelAndView.addObject("listKH", list);

        int totalItems = page2.getNumberOfElements();
        int totalPages = page2.getTotalPages();
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("currentPage", page);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddFormKhachHang() {
        ModelAndView modelAndView = new ModelAndView("khachhang/add");
        modelAndView.addObject("khachHangForm", new KhachHangEntity());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addKhachHang(final @Valid @ModelAttribute("khachHangForm") KhachHangEntity khachHangEntity,
                               final BindingResult bindingResult,
                               final RedirectAttributes redirectAttributes) {
//        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
//            modelAndView = new ModelAndView("khachhang/add");
            return "khachhang/add";
        }
//        mayEntity.setTrangThai(0); khi c???n m???c ?????nh l??c insert c?? gi?? tr??? bao nhi???u th?? m???i th??m d??ng n??y
        redirectAttributes.addFlashAttribute("msg_saveKH", "l??u th??nh c??ng kh??ch h??ng " + khachHangEntity.getMaKH());
        khachHangService.save(khachHangEntity);
        return "redirect:/khach-hang/list";
    }

    @GetMapping("/edit/{maKH}")
    public ModelAndView findByMaKH(@PathVariable(name = "maKH") String maKH) {
        ModelAndView modelAndView = new ModelAndView("khachhang/edit");
        modelAndView.addObject("khachHangForm", khachHangService.findByMaKH(maKH));
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public String saveUpdateKhachHang(final @Valid @ModelAttribute(name = "khachHangForm") KhachHangEntity khachHangEntity,
                                      final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/khach-hang/edit";
        }
        redirectAttributes.addFlashAttribute("msg_updateKH", "c???p nh???t th??nh c??ng d???ch v??? " + khachHangEntity.getMaKH());
        khachHangService.save(khachHangEntity);
        return "redirect:/khach-hang/list";
    }

    @GetMapping("/delete/{maKH}")
    public String deleteKhachHang(final @PathVariable(name = "maKH") String maKH, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_deleteKH", "x??a th??nh c??ng m??y " + maKH);
        khachHangService.deleteByMaKH(maKH);
        return "redirect:/khach-hang/list";
    }

    @GetMapping("/search")
    public ModelAndView searchDichVu(Model model, @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("khachhang/search");
        List<KhachHangEntity> entityList = khachHangService.listSearch(keyword);
        model.addAttribute("listSearch", entityList);
        model.addAttribute("keyword", keyword);
        return modelAndView;
    }
}
