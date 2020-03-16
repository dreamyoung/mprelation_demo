package com.github.dreamyoung.mprelation.demo.entity;

import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.InverseJoinColumn;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.JoinTable;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToMany;
import com.github.dreamyoung.mprelation.demo.mapper.StudentCourseMapper;

import lombok.Data;

@Data
public class Teacher {
	@TableId(value = "teacher_id")
	private Long id;
	private String name;

	@TableField(exist = false)
	@ManyToMany
	@JoinTable(targetMapper = StudentCourseMapper.class)
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
	@InverseJoinColumn(name = "child_id", referencedColumnName = "student_id")
	@Lazy(false)
	private Set<Child> students;
}
