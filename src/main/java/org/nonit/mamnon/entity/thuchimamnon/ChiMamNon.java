package org.nonit.mamnon.entity.thuchimamnon;

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
import javax.validation.constraints.Size;


import lombok.*;
import org.nonit.mamnon.entity.congdoan.CongDoan;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mntc_chimamnon")
public class ChiMamNon {
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
	@JoinColumn(name="dmchimamnon_id")
	private DanhMucChiMamNon danhMucChiMamNon;

}
