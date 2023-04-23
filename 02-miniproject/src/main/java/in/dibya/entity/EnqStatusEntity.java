package in.dibya.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="AIT_ENQURIRY_STATUS")
public class EnqStatusEntity {
	@Id
	private Integer statusId;
	private String statusname;
	
	

}
