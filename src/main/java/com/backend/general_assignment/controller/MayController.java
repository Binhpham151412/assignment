package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.service.MayService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/may")
public class MayController {
    @Autowired
    private MayService mayService;

    @GetMapping("/list")
    public ModelAndView getAllMayWithPageAble() {
        ModelAndView modelAndView = new ModelAndView("may/list");
        modelAndView.addObject("listMay", mayService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddFormMay() {
        ModelAndView modelAndView = new ModelAndView("may/add");
        modelAndView.addObject("mayForm", new MayEntity());
        return modelAndView;
    }

    @PostMapping("/add")
    public Object addMay(final @Valid @ModelAttribute("mayForm") MayEntity mayEntity,
                         final BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("may/add");
            return modelAndView;
        }
//        mayEntity.setTrangThai(0); khi cần mặc định lúc insert có giá trị bao nhiều thì mới thêm dòng này
        mayService.save(mayEntity);
        return "redirect:/home";
    }

    @GetMapping("/edit/{maMay}")
    public ModelAndView findByMaMay(@PathVariable(name = "maMay") String maMay) {
        ModelAndView modelAndView = new ModelAndView("may/edit");
        modelAndView.addObject("mayForm", mayService.findByMaMay(maMay));
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public Object saveUpdateMay(final @Valid @ModelAttribute(name = "mayForm") MayEntity mayEntity,
                             final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("may/edit");
            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("msg_update", "cập nhật thành công máy " + mayEntity.getMaMay());
        mayService.save(mayEntity);
        return "redirect:/may/list";
    }

    @GetMapping("/delete/{maMay}")
    public String deleteMay(final @PathVariable(name = "maMay") String maMay, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_delete", "xóa thành công máy " + maMay);
        mayService.deleteByMaMay(maMay);
        return "redirect:/may/list";
    }

    @GetMapping("/search")
    public ModelAndView searchMay(Model model, @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("may/search");
        List<MayEntity> entityList = mayService.listSearch(keyword);
        model.addAttribute("listSearch", entityList);
        model.addAttribute("keyword", keyword);
        return modelAndView;
    }
}
