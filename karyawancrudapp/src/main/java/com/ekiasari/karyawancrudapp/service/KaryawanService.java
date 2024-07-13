package com.ekiasari.karyawancrudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ekiasari.karyawancrudapp.entity.Karyawan;
import com.ekiasari.karyawancrudapp.repository.KaryawanRepository;

@Service
public class KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    public List<Karyawan> getAllKaryawan() {
        Sort sort = Sort.by(Order.asc("id"));
        return karyawanRepository.findAll(sort);
    }

    public List<Karyawan> getKaryawanByKeyword(String keyword) {
        return karyawanRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Karyawan getKaryawanById(Long id) {
        return karyawanRepository.findById(id).orElseThrow(() -> new RuntimeException("Karyawan not found"));
    }

    public void createKaryawan(Karyawan karyawan) {
        karyawanRepository.save(karyawan);
    }

    public void updateKaryawan(Long id, Karyawan karyawan) {
        Optional<Karyawan> karyawanById = karyawanRepository.findById(id);
        if (karyawanById.isPresent()) {
            karyawanById.get().setName(karyawan.getName());
            karyawanById.get().setGender(karyawan.getGender());
            karyawanById.get().setAge(karyawan.getAge());
        }
        karyawanRepository.save(karyawanById.get());
    }

    public void deleteKaryawan(Long id) {
        karyawanRepository.deleteById(id);
    }
}
