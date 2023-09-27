package org.nonit.mamnon.service.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.entity.mamnon.Grade;
import org.nonit.mamnon.entity.phieuthu.CalculationType;
import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
import org.nonit.mamnon.entity.thuchimamnon.DanhMucThuMamNon;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhMucThuAndDuThu {

    private String name;
    private CalculationType calculationType;

    private Integer amount;

    private Long duthuId;

    private Boolean isMandantory;

    private Boolean isAbsentCount;

    private Long parentId;

    private Long danhmucthuId;
}
