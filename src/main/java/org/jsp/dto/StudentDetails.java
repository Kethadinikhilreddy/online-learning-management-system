package org.jsp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	@Column(name="email",nullable = false,unique = true)
	private String email;
	private String password;
	private String gender;
	private LocalDate dateOfBirth;
	@Column(name="mobileNumber",nullable = false,unique = true)
	private long mobileNumber;
	private String address;
	
	@ManyToMany
	@JoinTable(
	    name = "student_batch",
	    joinColumns = @JoinColumn(name = "student_id"),
	    inverseJoinColumns = @JoinColumn(name = "batch_id")
	)
	private List<BatchDetails> batches;

	
	
	public int getId() {
		return sid;
	}
	public void setId(int id) {
		this.sid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<BatchDetails> getBatches() {
		return batches;
	}
	public void setBatches(List<BatchDetails> batches) {
		this.batches = batches;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	@Override
	public String toString() {
		return "StudentDetails [id=" + sid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address=" + address + ", batches="
				+ batches + "]";
	}
	

	public void addBatch(BatchDetails batch) {
	    batches.add(batch);
	    batch.getStudents().add(this);
	}
}
