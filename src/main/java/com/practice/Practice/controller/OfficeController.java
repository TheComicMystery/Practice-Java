package com.practice.Practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.practice.Practice.entity.Office;
import com.practice.Practice.service.OfficeService;

@Controller
public class OfficeController {

    private OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        super();
        this.officeService = officeService;
    }

    @GetMapping("/offices")
    public String listOffices(Model model) {
        model.addAttribute("offices", officeService.getAllOffices());
        return "offices";
    }

    @GetMapping("/offices/new")
    public String createOfficeForm(Model model) {
        Office office = new Office();
        model.addAttribute("office", office);
        return "create_office";
    }

    @PostMapping("/offices")
    public String saveOffice(@ModelAttribute("office") Office office) {
        officeService.saveOffice(office);
        return "redirect:/offices";
    }

    @GetMapping("/offices/edit/{id}")
    public String editOfficeForm(@PathVariable Long id, Model model) {
        model.addAttribute("office", officeService.getOfficeById(id));
        return "edit_office";
    }

    @PostMapping("/offices/{id}")
    public String updateOffice(@PathVariable Long id, @ModelAttribute("office") Office office, Model model) {
        Office existingOffice = officeService.getOfficeById(id);
        existingOffice.setId(id);
        existingOffice.setFirstName(office.getFirstName());
        existingOffice.setLastName(office.getLastName());
        existingOffice.setEmail(office.getEmail());

        officeService.updateOffice(existingOffice);
        return "redirect:/offices";
    }

    @GetMapping("/offices/{id}")
    public String deleteOffice(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        officeService.deleteOfficeById(id);
        redirectAttributes.addFlashAttribute("message", "Client deleted successfully!");
        return "redirect:/offices";
    }
}