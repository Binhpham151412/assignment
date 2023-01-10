package com.backend.general_assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "may")
public class MayEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) khi id là String thì ko dùng được GeneratedValue!!!
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^M[0-9]{3}$", message = "Mã Máy có định dạng là Mxxx !")
    private String maMay;

    @NotBlank(message = "không được để trống")
    private String viTri;

    @NotNull(message = "không được để trống")
    private int trangThai;

    @OneToMany(mappedBy = "suDungMay_may")
    private List<SuDungMayEntity> suDungMayEntityList;
}
