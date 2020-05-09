package com.github.dreamyoung.mprelation.demo.entity2.bean;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.AutoLazy;
import com.github.dreamyoung.mprelation.EntityMapper;
import com.github.dreamyoung.mprelation.InverseJoinColumn;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.JoinTable;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToMany;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.demo.entity.Course;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.mapper.StudentCourseMapper;

import lombok.Data;

@Data
@TableName("child")
@AutoLazy
public class Child2 {
	@TableId("child_id")
	private Long id;

	private String name;

	private Long laoHanId;
	
	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "lao_han_id", referencedColumnName = "man_id")
	//@EntityMapper
	@Lazy
	private Man laoHan;
	
	
	@TableField(exist = false)
	@ManyToMany
	@JoinTable
	@JoinColumn(name = "child_id", referencedColumnName = "student_id")
	@InverseJoinColumn(name = "course_id", referencedColumnName = "course_id")
	@Lazy(false)
	private List<Course> courses;
	
	


	

}
