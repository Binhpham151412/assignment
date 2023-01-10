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
import javax.validation.constraints.Positive;
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
    @Positive(message = "Số lượng phải lớn hơn 0")
    private String donGia;

    @OneToMany(mappedBy = "suDungDV_maDV")
    private List<SuDungDichVuEntity> suDungDichVuEntityList;
}
