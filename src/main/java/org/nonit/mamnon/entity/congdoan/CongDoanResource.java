package org.nonit.mamnon.entity.congdoan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class CongDoanResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable=false)
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private ResourceType type;

	@Column
	private String manager;
	
//	@ManyToOne
//	@JoinColumn(name="congdoan_id")
//	@JsonBackReference
//	private CongDoan congdoan;
	
}
