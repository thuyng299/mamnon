//package org.nonit.mamnon.service.model;
//
//import lombok.*;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.nonit.mamnon.entity.congdoan.CongDoan;
//import org.nonit.mamnon.entity.mamnon.Grade;
//import org.nonit.mamnon.entity.phieuthu.CalculationType;
//import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
//import org.nonit.mamnon.entity.thuchimamnon.DanhMucThuMamNon;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.time.LocalDate;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class DanhMucThuAndDuThu {
//
//    private Long danhMucThuId;
//
//    private String name;
//
//    private Boolean isCurrentUse;
//
//    private Boolean isMandantory;
//
//    private Boolean isAbsentCount;
//
//    @Enumerated(EnumType.STRING)
//    private CalculationType calculationType = CalculationType.MONTHLY;
//
//    private Long parentId;
//
//    private Integer congDoanId;
//
//    private boolean isActive;
//
//    private Long duThuId;
//
//    private Integer amount;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "grade_id")
//    private Grade grade;
//
//    @UpdateTimestamp
//    private LocalDate modifiedDate;
//}
