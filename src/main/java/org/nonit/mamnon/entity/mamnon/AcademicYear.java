package org.nonit.mamnon.entity.mamnon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name="mn_academicyear")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYear {
	@Id
	private String name;

	@Column
	private Integer usdExchangeRate;

	@Column
	private Integer congDoanStartMonth;

	@Column
	private Integer congDoanNumOfMonth;
}
