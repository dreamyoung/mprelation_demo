package com.github.dreamyoung.mprelation.demo.entity;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.AutoLazy;
import com.github.dreamyoung.mprelation.EntityMapper;
import com.github.dreamyoung.mprelation.InverseJoinColumn;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.JoinTable;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToMany;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.demo.mapper.StudentCourseMapper;
import com.github.dreamyoung.mprelation.demo.mapper.StudentTeacherMapper;

import lombok.Data;

@Data
@AutoLazy
public class Child {

	@TableId("child_id")
	private Long id;

	private String name;

	private Long laoHanId;

	private Long laoMaId;

	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "lao_han_id", referencedColumnName = "man_id")
	@EntityMapper
	@Lazy
	private Man laoHan;

	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "lao_ma_id", referencedColumnName = "woman_id")
	@EntityMapper
	@Lazy
	private Woman laoMa;

	@TableField(exist = false)
	@ManyToMany
	@JoinTable(targetMapper = StudentCourseMapper.class)
	@JoinColumn(name = "child_id", referencedColumnName = "student_id")
	@InverseJoinColumn(name = "course_id", referencedColumnName = "course_id")
	@Lazy()
	private List<Course> courses;

	@TableField(exist = false)
	@ManyToMany
	@JoinTable(targetMapper = StudentTeacherMapper.class)
	@JoinColumn(name = "child_id", referencedColumnName = "student_id")
	@InverseJoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
	@Lazy
	private Set<Teacher> teachers;

}
