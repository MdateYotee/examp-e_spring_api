package users.json;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TbUserJson {
	private long id;
	private String username;
	private String password;
	private String Details;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
