package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.DichVuEntity;
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

    /**
     * show list Dich Vu and paging
     *
     * @param page auto
     * @return list.jsp
     * @author BinhPV7
     * @since 11-01-2023
     */
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

    /**
     * show form input information for DichVu
     *
     * @return add.jsp
     * @author BinhPV7
     * @since 11-01-2023
     */
    @GetMapping("/add")
    public ModelAndView showAddFormDichVu() {
        ModelAndView modelAndView = new ModelAndView("dichvu/add");
        modelAndView.addObject("dichVuForm", new DichVuEntity());
        return modelAndView;
    }

    /**
     * before add dichvu validate , if validate not null return add.jsp or redirect:/dich-list when validate is null
     *
     * @param dichVuEntity       dichVuEntity
     * @param bindingResult      bindingResult
     * @param redirectAttributes redirectAttributes
     * @return add.jsp if validate not null or redirect:/dich-vu/list if validate is null
     * @author BinhPV7
     * @since 11-01-2023
     */
    @PostMapping("/add")
    public Object addDichVu(final @Valid @ModelAttribute("dichVuForm") DichVuEntity dichVuEntity,
                            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("dichvu/add");
//            modelAndView.addObject("dichVuForm", new DichVuEntity());
            return modelAndView;
        }
//        mayEntity.setTrangThai(0); khi cần mặc định lúc insert có giá trị bao nhiều thì mới thêm dòng này
        redirectAttributes.addFlashAttribute("msg_saveDichVu", "lưu thành công dịch vụ " + dichVuEntity.getMaDV());
        dichVuService.save(dichVuEntity);
        return "redirect:/dich-vu/list";
    }

    /**
     * show form input edit DichVu
     *
     * @param maDV maDV
     * @return modelAndView
     * @author BinhPV7
     * @since 11-01-2023
     */
    @GetMapping("/edit/{maDV}")
    public ModelAndView findByMaDV(@PathVariable(name = "maDV") String maDV) {
        ModelAndView modelAndView = new ModelAndView("dichvu/edit");
        modelAndView.addObject("dichVuForm", dichVuService.findByMaDV(maDV));
        return modelAndView;
    }

    /**
     * @param dichVuEntity       dichVuEntity
     * @param bindingResult      bindingResult
     * @param redirectAttributes redirectAttributes
     * @return redirect:/dichvu/edit if validate is not null or redirect:/dich-vu/list when validate is null
     * @author BinhPV7
     * @since 11-01-2023
     */
    @PostMapping("/edit/save")
    public String saveUpdateDichVu(final @Valid @ModelAttribute(name = "dichVuForm") DichVuEntity dichVuEntity,
                                   final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/dich-vu/edit";
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
        ModelAndView modelAndView = new ModelAndView("dichvu/search");
        List<DichVuEntity> entityList = dichVuService.listSearch(keyword);
        model.addAttribute("listSearch", entityList);
        model.addAttribute("keyword", keyword);
        return modelAndView;
    }
}
