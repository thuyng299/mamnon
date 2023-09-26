package org.nonit.mamnon.entity.mamnon;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_grade")
@Builder
public class Grade {
	private static final String QUALIFIER ="com.assignment.entity.mamnon.Grade.";

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotNull
	 @Size(min = 1, max = 300)
	 @Column(length = 300, nullable = false)
	 private String name;
	 
	 @NotNull
	 @Size(min = 1, max = 100)
	 @Column(length = 100, nullable = false)
	 private String academicYear;
	 
	 @ManyToOne
	 @JoinColumn(name="congdoan_id")
	 private CongDoan congdoan;
	
}
