package com.example.users.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.*;

import com.example.faculty.model.TbFaculty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class TbUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_uuid")
	private String userUuid = UUID.randomUUID().toString();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id")
	private TbFaculty tbFaculty;

	@Column(name = "user_username")
	private String userUsername;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_details")
	private String userDetails;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
