package org.nonit.mamnon.entity.congdoan;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id","createdDate","updatedDate"})
@Table(name = "cong_doan")
public class CongDoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String principalName;

    @Column
    private String accountantName;

    @Column(unique = true)
    private String congDoanName;

    @Column(name = "payment_due_date")
    private String paymentDueDate;

    @Column(name = "payment_sent_date")
    private String paymentSentDate;

    @CreationTimestamp
    @Column(name = "created_date")
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "modified_date")
	private LocalDateTime updatedDate;

//	@OneToMany(mappedBy = "congdoan", cascade = CascadeType.ALL, orphanRemoval = true)
//    @ToString.Exclude
//   @JsonManagedReference
//	private List<CongDoanResource> congdoanResources;

    @Column(name = "is_abroad", columnDefinition = "boolean default false")
    private boolean abroad;

    @Column
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column
    @Enumerated(EnumType.STRING)
    private CongdoanType type;
}
