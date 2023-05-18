package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Column(name = "id_c")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long id_c;
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String title;
	
	@Column(name = "creditPoints")
	@Min(1)
	@Max(50)
	private int creditPoints;
	
	@OneToOne
	@JoinColumn(name = "id_p")
	private Professor professor;

}
