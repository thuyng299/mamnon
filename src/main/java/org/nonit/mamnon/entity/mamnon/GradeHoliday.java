package org.nonit.mamnon.entity.mamnon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_grade_holiday")
public class GradeHoliday {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotNull
	 @Column(nullable = false)
	 private Integer holidayMonth;
	 
	 // store all holidays by numbers: 4,6,8,24,29 ==> will handle by code
	 @NotNull
	 @Size(min = 1, max = 200)
	 @Column(length = 200, nullable = false)
	 private String dayOffs;
	 
	 @UpdateTimestamp
	 private LocalDateTime modifiedDate;
	 
	 @ManyToOne (fetch = FetchType.LAZY)
	 @JoinColumn(name="grade_id")
//	 @JsonIdentityReference(alwaysAsId = true)
	 private Grade grade;
	 
}
