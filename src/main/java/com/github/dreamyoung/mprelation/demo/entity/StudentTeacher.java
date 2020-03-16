package com.github.dreamyoung.mprelation.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

@Data
public class StudentTeacher {
	private Long id;

	@TableField("student_id")
	private Long studentId;

	@TableField("teacher_id")
	private Long teacherId;
}
