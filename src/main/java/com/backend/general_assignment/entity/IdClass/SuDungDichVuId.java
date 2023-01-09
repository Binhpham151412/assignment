package com.backend.general_assignment.entity.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuDungDichVuId implements Serializable {

    private String SuDungDV_maDV;

    private String dichVu_khachHang;

    private LocalDate ngaySD;

    private LocalTime gioSD;
}
