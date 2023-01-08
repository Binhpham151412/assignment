package com.backend.general_assignment.entity;

import com.backend.general_assignment.entity.IdClass.SuDungDichVuId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "su_dung_dich_vu")
@IdClass(SuDungDichVuId.class)
public class SuDungDichVuEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "maDV", nullable = false)
    private DichVuEntity SuDungDV_maDV;

    @Id
    @ManyToOne
    @JoinColumn(name = "maKH", nullable = false)
    private KhachHangEntity dichVu_khachHang;

    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaySD;

    @Id
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioSD;

    private int soLuong;
}
