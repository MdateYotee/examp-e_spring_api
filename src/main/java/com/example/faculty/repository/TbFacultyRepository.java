package com.example.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.faculty.model.TbFaculty;

public interface TbFacultyRepository extends JpaRepository<TbFaculty, Long>{
	TbFaculty findOneByfacultyId(long facultyId);

}
