package lv.venta.models;

import java.util.Collection;

import org.hibernate.sql.ast.tree.expression.Collation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
	
	@Column(name = "id_st")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long id_st;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;

	public Student(@NotNull @Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 50) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname) {
		this.name = name;
		this.surname = surname;
	}

	@OneToMany(mappedBy = "student")
	private Collection<Grade> grades;
	
	
}
