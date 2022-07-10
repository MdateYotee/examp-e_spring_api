package com.example.faculty.json;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TbFacultyJson {

	private long facultyId;
	private String facultyName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
