package com.ekiasari.karyawancrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekiasari.karyawancrudapp.entity.Karyawan;
import java.util.List;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

    List<Karyawan> findByNameContainingIgnoreCase(String name);
}
