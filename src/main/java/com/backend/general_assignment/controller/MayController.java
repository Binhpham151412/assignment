package com.backend.general_assignment.controller;

import com.backend.general_assignment.entity.MayEntity;
import com.backend.general_assignment.service.MayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
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
    public ModelAndView getAllMayWithPageAble(final @RequestParam(defaultValue = "1") int page) {
        Page<MayEntity> page2 = mayService.findAll(page);
        List<MayEntity> list = page2.getContent();
        ModelAndView modelAndView = new ModelAndView("may/list");
        modelAndView.addObject("listMay", list);

        int totalItems = page2.getNumberOfElements();
        int totalPages = page2.getTotalPages();
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("currentPage", page);

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
                         final BindingResult bindingResult,
                         final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("may/add");
            return modelAndView;
        }
//        mayEntity.setTrangThai(0); khi c???n m???c ?????nh l??c insert c?? gi?? tr??? bao nhi???u th?? m???i th??m d??ng n??y
        redirectAttributes.addFlashAttribute("msg_saveMay", "l??u th??nh c??ng m??y " + mayEntity.getMaMay());
        mayService.save(mayEntity);
        return "redirect:/may/list";
    }

    @GetMapping("/edit/{maMay}")
    public ModelAndView findByMaMay(final @PathVariable(name = "maMay") String maMay) {
        ModelAndView modelAndView = new ModelAndView("may/edit");
        modelAndView.addObject("mayForm", mayService.findByMaMay(maMay));
        return modelAndView;
    }

    @PostMapping("/edit/save")
    public Object saveUpdateMay(final @Valid @ModelAttribute(name = "mayForm") MayEntity mayEntity,
                                final BindingResult bindingResult,
                                final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("may/edit");
            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("msg_updateMay", "c???p nh???t th??nh c??ng m??y " + mayEntity.getMaMay());
        mayService.save(mayEntity);
        return "redirect:/may/list";
    }

    @GetMapping("/delete/{maMay}")
    public String deleteMay(final @PathVariable(name = "maMay") String maMay,
                            final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg_deleteMay", "x??a th??nh c??ng m??y " + maMay);
        mayService.deleteByMaMay(maMay);
        return "redirect:/may/list";
    }

    @GetMapping("/search")
    public ModelAndView searchMay(final @Param("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("may/search");
        List<MayEntity> entityList = mayService.listSearch(keyword);
        modelAndView.addObject("listSearch", entityList);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }
}
