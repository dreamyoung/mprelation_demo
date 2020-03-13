package com.github.dreamyoung.mprelation.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

@Data
public class StudentCourse {
	private Long id;

	@TableField("student_id")
	private Long studentId;

	@TableField("course_id")
	private Long courseId;
}
