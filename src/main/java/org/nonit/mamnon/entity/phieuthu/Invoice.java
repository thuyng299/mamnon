package org.nonit.mamnon.entity.phieuthu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.nonit.mamnon.entity.mamnon.Student;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Builder.Default;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_invoice")
@NamedQueries({
		@NamedQuery(name = Invoice.FIND_BY_MONTH_YEAR_CLASSID_AND_FETCH_TUITIONS, query = "select distinct i from Invoice i " +
				"left join fetch i.tuitions where i.month = ?1 and i.year = ?2 and i.student.clazz.id = ?3"),
		@NamedQuery(name = Invoice.FIND_BY_MONTH_YEAR_CLASSID_STUDENTID_IN_AND_FETCH_TUITIONS, query = "select distinct i from Invoice i " +
				"left join fetch i.tuitions where i.month = ?1 and i.year = ?2 and i.student.clazz.id = ?3 and i.student.id in (?4)") }
)
@NamedEntityGraph(
		name = "invoice-tuitions-graph",
		attributeNodes = {
				@NamedAttributeNode("tuitions")
		}
)
public class Invoice {

	public static final String FIND_BY_MONTH_YEAR_CLASSID_AND_FETCH_TUITIONS = "Invoice.findByMonthAndYearAndStudentClazzIdAndFetchTuitions";
	public static final String FIND_BY_MONTH_YEAR_CLASSID_STUDENTID_IN_AND_FETCH_TUITIONS = "Invoice.findByMonthAndYearAndStudentClazzIdAndStudentIdInAndFetchTuitions";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column
	private int month;

	@NotNull
	@Column
	private int year;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer totalAmount = 0;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer paymentAmount = 0;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer remainAmount = 0;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer kDaysPrevMonth = 0;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0", name = "p_days_prev_month")
	private Integer pDaysPrevMonth = 0;

//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer daysToClassCurrentMonth = 0;

	@NotNull
//	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

//	@ToString.Exclude
//	@Builder.Default
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Tuition> tuitions = new ArrayList<>();

	@Default
	@Column(name = "is_paid")
	private Boolean isPaid = false;

	@Column(name = "truy_thu_amount")
	private Integer truyThuAmount = 0;
	// if the year and month is equal to the invoice, tuitions will transfer to thumamnon from 1 to 7
	// else will update the total amount that mapped to the above truyThuAmount
	@Column(name = "paid_date")
	private LocalDate paidDate;

	@Column(name = "created_time")
	private LocalDateTime createdTime;

	@NotNull
	@Column(name = "school_id")
	private Integer schoolId;
	@Column
	private Integer stt;

	@Column
	private String note;

	public void addTuitions(List<Tuition> tuitions) {
		for(Tuition tuition: tuitions) {
			tuition.setInvoice(this);
			this.tuitions.add(tuition);
			this.totalAmount += tuition.getAmount();
		}
	}

}
