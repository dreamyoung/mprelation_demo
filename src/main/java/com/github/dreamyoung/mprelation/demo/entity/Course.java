package com.github.dreamyoung.mprelation.demo.entity;

import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.InverseJoinColumn;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.JoinTable;
import com.github.dreamyoung.mprelation.ManyToMany;
import com.github.dreamyoung.mprelation.demo.mapper.StudentCourseMapper;

import lombok.Data;

@Data
public class Course {
	@TableId(value = "course_id")
	private Long id;
	private String name;

	@TableField(exist = false)
	@ManyToMany
	@JoinTable(targetMapper = StudentCourseMapper.class)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	@InverseJoinColumn(name = "child_id", referencedColumnName = "student_id")
	private Set<Child> students;
}
