package in.cerpsoft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "room_setup")
public class RoomSetupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Invalid Location Id")
	@NotNull(message = "Invalid Location Id")
	@NotBlank(message = "Invalid Location Id")
	private String locationId;
	
	private String roomType;
	
	private String roomNo;
	
	private String roomFloor;
}
