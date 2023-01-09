package com.backend.general_assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khach_hang")
public class KhachHangEntity {
    @Id
    @NotBlank(message = "không được để trống")
    private String maKH;

    @NotBlank(message = "Vui lòng nhập")
    private String tenKH;

    @NotBlank(message = "Vui lòng nhập")
    private String diaChi;

    @NotBlank(message = "Vui lòng nhập")
    @Pattern(regexp = "^[0-9\\-\\+]{10,11}$", message = "Phone có 10-11 số")
    private String soDT;

    @NotBlank(message = "Vui lòng nhập")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "không đúng định dạng email")
    private String email;

    @OneToMany(mappedBy = "dichVu_khachHang")
    private List<SuDungDichVuEntity> suDungDichVuEntityList;

    @OneToMany(mappedBy = "suDungMay_khachHang")
    private List<SuDungMayEntity> dichVuEntityList;

}