package com.ekiasari.karyawancrudapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ekiasari.karyawancrudapp.entity.Karyawan;
import com.ekiasari.karyawancrudapp.service.KaryawanService;

@SpringBootApplication
public class KaryawancrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaryawancrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialValue(KaryawanService karyawanService) {
		return (args) -> {
			Karyawan karyawan1 = Karyawan.builder().name("Udin Saputra").gender("Male").age(21).build();
			Karyawan karyawan2 = Karyawan.builder().name("Angga Agus").gender("Male").age(27).build();
			Karyawan karyawan3 = Karyawan.builder().name("Budi Restawi").gender("Male").age(32).build();
			Karyawan karyawan4 = Karyawan.builder().name("Siti Ayu Fatimah").gender("Female").age(22).build();
			Karyawan karyawan5 = Karyawan.builder().name("Agung Saputra").gender("Male").age(17).build();
			Karyawan karyawan6 = Karyawan.builder().name("Farah Andini").gender("Female").age(27).build();
			Karyawan karyawan7 = Karyawan.builder().name("Ayu Lestari").gender("Female").age(26).build();
			Karyawan karyawan8 = Karyawan.builder().name("Laras Anggini").gender("Female").age(20).build();
			karyawanService.createKaryawan(karyawan1);
			karyawanService.createKaryawan(karyawan2);
			karyawanService.createKaryawan(karyawan3);
			karyawanService.createKaryawan(karyawan4);
			karyawanService.createKaryawan(karyawan5);
			karyawanService.createKaryawan(karyawan6);
			karyawanService.createKaryawan(karyawan7);
			karyawanService.createKaryawan(karyawan8);
		};
	}

}
