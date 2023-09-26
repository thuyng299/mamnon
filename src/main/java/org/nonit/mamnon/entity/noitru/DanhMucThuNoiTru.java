package org.nonit.mamnon.entity.noitru;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nttc_danhmuc_thunoitru")
public class DanhMucThuNoiTru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(length = 500, nullable = false)
    private String name;

    @NotNull
    @Column(unique = true, nullable=false)
    private Integer code;

}
