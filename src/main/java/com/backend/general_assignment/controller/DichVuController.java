package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.DichVuEntity;
import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.service.DichVuService;
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

@RequestMapping("/dich-vu")
@Controller
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;

    @GetMapping("/list")
    public ModelAndView getAllDichVuWithPageAble(@RequestParam(defaultValue = "1") int page) {
//        ModelAndView modelAndView = new ModelAndView("dichvu/list");
//        modelAndView.addObject("listDV", dichVuService.findAll());
//        return modelAndView;

        Page<DichVuEntity> page2 = dichVuService.findAll(page);
        List<DichVuEntity> list = page2.getContent();
        ModelAndView modelAndView = new ModelAndView("dichvu/list");
        modelAndView.addObject("listDV", list);

        int totalItems = page2.getNumberOfElements();
        int totalPages = page2.getTotalPages();
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("currentPage", page);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddFormDichVu() {
        ModelAndView modelAndView = new ModelAndView("dichvu/add");
        modelAndView.addObject("dichVuForm", new DichVuEntity());
        return modelAndView;
    }

    @PostMapping("/add")
    public Object addDichVu(final @Valid @ModelAttribute("dichVuForm") DichVuEntity dichVuEntity,
                            final BindingResult bindingResult,final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("dichvu/add");
            return modelAndView;
        }
//        mayEntity.setTrangThai(0); khi cần mặc định lúc insert có giá trị bao nhiều thì mới thêm dòng này
        redirectAttributes.addFlashAttribute("msg_saveDichVu", "lưu thành công dịch vụ " + dichVuEntity.getMaDV());
        dichVuService.save(dichVuEntity);
        return "redirect:/dich-vu/list";
    }

    @GetMapping("/edit/{maDV}")
    public ModelAndView findByMaDV(@PathVariable(name = "maDV") String maDV) {
        ModelAndView modelAndView = new ModelAndView("dichvu/edit");
        modelAndView.addObject("dichVuForm", dichVuService.findByMaDV(maDV));
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public Object saveUpdateDichVu(final @Valid @ModelAttribute(name = "dichVuForm") DichVuEntity dichVuEntity,
                                   final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("dichvu/edit");
            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("msg_updateDichVu", "cập nhật thành công dịch vụ " + dichVuEntity.getMaDV());
        dichVuService.save(dichVuEntity);
        return "redirect:/dich-vu/list";
    }

    @GetMapping("/delete/{maDV}")
    public String deleteDichVu(final @PathVariable(name = "maDV") String maDV, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_deleteDichVu", "xóa thành công máy " + maDV);
        dichVuService.deleteByMaDV(maDV);
        return "redirect:/dich-vu/list";
    }

    @GetMapping("/search")
    public ModelAndView searchDichVu(Model model, @Param("keyword") String keyword) {
        ModelAndView modelAndView =new ModelAndView("dichvu/search");
        List<DichVuEntity> entityList = dichVuService.listSearch(keyword);
        model.addAttribute("listSearch", entityList);
        model.addAttribute("keyword", keyword);
        return modelAndView;
    }
}
