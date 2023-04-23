package in.dibya.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="AIT_COURSES")
public class CourseEntity {
	@Id
	private Integer courseId;
	private String Coursename;

}
