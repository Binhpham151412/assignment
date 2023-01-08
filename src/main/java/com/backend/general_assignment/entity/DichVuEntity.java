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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dich_vu")
public class DichVuEntity {
    @Id
    @NotBlank(message = "không được để trống")
    private String maDV;

    @NotBlank(message = "không được để trống")
    private String tenDV;

    @NotNull(message = "không được để trống")
    private int donViTinh;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[0-9]+.[0-9]+", message = "Đơn giá phải là số lớn hơn 0")
    private String donGia;

    @OneToMany(mappedBy = "SuDungDV_maDV")
    private List<SuDungDichVuEntity> suDungDichVuEntityList;
}
