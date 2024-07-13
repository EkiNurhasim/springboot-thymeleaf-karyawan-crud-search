package com.ekiasari.karyawancrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ekiasari.karyawancrudapp.entity.Karyawan;
import com.ekiasari.karyawancrudapp.service.KaryawanService;

@Controller
public class KaryawanController {

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping(path = { "/", "/karyawan", "/search-karyawan" })
    public String getAllKaryawan(Model model, String keyword) {
        if (keyword == null) {
            List<Karyawan> allKaryawan = karyawanService.getAllKaryawan();
            model.addAttribute("karyawans", allKaryawan);
        } else {
            List<Karyawan> searchKaryawan = karyawanService.getKaryawanByKeyword(keyword);
            model.addAttribute("karyawans", searchKaryawan);
            model.addAttribute("isKeywordEmpty", true);
        }
        return "karyawan";
    }

    @GetMapping(path = "/detail-karyawan/{id}")
    public String getKaryawanById(@PathVariable Long id, Model model) {
        Karyawan karyawanById = karyawanService.getKaryawanById(id);
        model.addAttribute("karyawan", karyawanById);
        return "karyawan-detail";
    }

    @GetMapping(path = "/remove-karyawan/{id}")
    public String removeKaryawanById(@PathVariable Long id, Model model) {
        karyawanService.deleteKaryawan(id);
        model.addAttribute("karyawans", karyawanService.getAllKaryawan());
        return "redirect:/karyawan";
    }

    @GetMapping(path = "/add-karyawan-view")
    public String addKaryawan(Karyawan karyawan) {
        return "add-karyawan";
    }

    @PostMapping(path = "/add-karyawan-form")
    public String addKaryawan(Karyawan karyawan, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "add-karyawan";
        }

        karyawanService.createKaryawan(karyawan);
        model.addAttribute("karyawans", karyawanService.getAllKaryawan());
        return "redirect:/karyawan";
    }

    @GetMapping(path = "/edit-karyawan-view/{id}")
    public String editKaryawan(@PathVariable Long id, Model model) {
        Karyawan karyawanUpdate = karyawanService.getKaryawanById(id);
        model.addAttribute("karyawan", karyawanUpdate);
        return "edit-karyawan";
    }

    @PostMapping(path = "/edit-karyawan-from/{id}")
    public String postMethodName(@PathVariable Long id, Karyawan karyawan, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-karyawan";
        }
        karyawanService.updateKaryawan(id, karyawan);
        model.addAttribute("karyawans", karyawan);
        return "redirect:/karyawan";
    }

}
