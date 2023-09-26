package org.nonit.mamnon.entity.noitru;


import lombok.*;
import org.nonit.mamnon.entity.congdoan.CongDoan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nttc_thunoitru")
public class ThuNoiTru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long amount;

    @NotNull
    private Integer year;

    @NotNull
    private Integer month;

    private LocalDate collectDate;

    @Size(max = 500)
    @Column(length = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name="congdoan_id")
    private CongDoan congdoan;

    @ManyToOne
    @JoinColumn(name="dmthunoitru_id")
    private DanhMucThuNoiTru danhMucThuNoiTru;

    @Column
    private BigDecimal usdAmount;

    @Column
    private BigDecimal eurAmount;

    @Column
    private String ngoaiTeAmount;
}
