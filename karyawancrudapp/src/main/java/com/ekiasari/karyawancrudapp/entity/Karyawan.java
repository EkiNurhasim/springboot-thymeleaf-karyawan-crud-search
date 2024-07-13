package com.ekiasari.karyawancrudapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Karyawan {

    @Id
    @SequenceGenerator(name = "karyawan_seq", sequenceName = "karyawan_seq", allocationSize = 1)
    @GeneratedValue(generator = "karyawan_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String gender;
    private Integer age;
}
