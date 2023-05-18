package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "proffesor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	
	@Column(name = "id_p")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long id_p;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	private Degree Degree;

	public Professor(@NotNull @Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname,
			lv.venta.models.@NotNull Degree degree) {
		this.name = name;
		this.surname = surname;
		Degree = degree;
	}





	
	
}
