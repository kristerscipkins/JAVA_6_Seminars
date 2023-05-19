package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

@Table(name = "course_table")//table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idc;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	@Column(name="Title")
	private String title;
	
	@Column(name="Creditpoints")
	@Min(value = 1)
	@Max(value = 20)
	private int creditpoints;
	
	
	@ManyToMany(mappedBy = "courses")
	@ToString.Exclude
	private Collection<Professor> professors;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;


	public Course(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String title,
			@Min(1) @Max(20) int creditpoints, ArrayList<Professor> professor) {
		this.title = title;
		this.creditpoints = creditpoints;
		this.professors = professor;
	}
	
	public void addProffesor(Professor inputProffesor) {
		if (!professors.contains(inputProffesor)) {
			professors.add(inputProffesor);
		}
	}

	private void removeProffesor(Professor inputProffesor) {
			professors.remove(inputProffesor);

	}
	
}