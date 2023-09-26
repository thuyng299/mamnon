package org.nonit.mamnon.entity.phieuthu;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.nonit.mamnon.entity.thuchimamnon.DanhMucThuMamNon;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_invoice_details")
//@NamedQuery(
//		name = "Tuition.findMienGiamAmountByInvoiceIds",
//		query = "select COALESCE(abs(sum(t.amount)), 0) from Tuition t where t.amount < 0 and t.invoice.id in ?1 "
//)
public class Tuition {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID uuid;

	@NotNull
	@Column(nullable = false)
	private String name;
	private Integer amount;
	private Integer dailyAmount;
	private String description;
	private Long duthuId;// to support show in UI in lap PhieuThu
	private Boolean isMandantory;
	@Enumerated(EnumType.STRING)
	private CalculationType calculationType;
//	@Builder.Default
	private Boolean isAbsentCount = false;

	// remaining Amount from previous month
//	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer remainingAmount = 0;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	// mienGiamTuition
	@JoinColumn(name = "ref_tuition")
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	private Tuition referencedTuition;

	@ManyToOne
	@JoinColumn(name = "code", referencedColumnName = "code")
	private DanhMucThuMamNon dmThuMamNon;

	@Column
	private LocalDateTime subjectRegistrationDate;

	@Column(name = "danhmucthu_id")
	private Long danhMucThuId;
}
