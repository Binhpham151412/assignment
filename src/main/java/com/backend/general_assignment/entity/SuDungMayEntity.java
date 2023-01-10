package com.backend.general_assignment.entity;

import com.backend.general_assignment.entity.IdClass.SuDungMayId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "su_dung_may")
@IdClass(SuDungMayId.class)
public class SuDungMayEntity {

    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayBDSD;

    @Id
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime gioBDSD;

    @Id
    @ManyToOne
    @JoinColumn(name = "maMay", nullable = false)
    private MayEntity suDungMay_may;

    @Id
    @ManyToOne
    @JoinColumn(name = "maKH", nullable = false)
    private KhachHangEntity suDungMay_khachHang;

    @NotNull(message = "không được để trống")
    @Positive(message = "Số lượng phải lớn hơn 0")
    private int thoiGianSD;
}
