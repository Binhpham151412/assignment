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
public class SuDungMayId implements Serializable {

    private LocalDate ngayBDSD;

    private LocalTime gioBDSD;

    private String suDungMay_may;

    private String suDungMay_khachHang;

}
