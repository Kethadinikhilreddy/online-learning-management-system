package org.jsp.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "batch_details")
public class BatchDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String trainerName;
	private String subjectName;
	private LocalDate batchDate;
	private LocalTime batchTiming;
	private String status;
	
	@ManyToMany(mappedBy = "batches")
	private List<StudentDetails> students;
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public LocalDate getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(LocalDate batchDate) {
		this.batchDate = batchDate;
	}
	public LocalTime getBatchTiming() {
		return batchTiming;
	}
	public void setBatchTiming(LocalTime batchTiming) {
		this.batchTiming = batchTiming;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<StudentDetails> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDetails> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "BatchDetails [bid=" + bid + ", trainerName=" + trainerName + ", subjectName=" + subjectName
				+ ", batchDate=" + batchDate + ", batchTiming=" + batchTiming + ", status=" + status + "]";
	}
	
	public void addStudent(StudentDetails student) {
	    students.add(student);
	    student.getBatches().add(this);
	}

	
	
	

}
