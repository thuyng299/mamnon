package org.nonit.mamnon.entity.phieuthu;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.nonit.mamnon.entity.mamnon.Grade;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Builder.Default;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_duthu")
public class DuThu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer amount;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "danhmucthu_id")
	private DanhMucThu danhMucThu;

	@Column(nullable = false)
//	@Default
	private Boolean isMandantory = false;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;

	@UpdateTimestamp
	private LocalDate modifiedDate;
}
