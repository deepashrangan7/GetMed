package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "admintable")
public class AdminBean {

	@Id
	@Column(name = "adminId")
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Type Valid emailId")
	@NotBlank(message="email cant be empty")
	private String emailId;

	@NotBlank(message = "FirstName should not be empty")
	@Pattern(regexp = "[a-zA-Z ]+",message = "Should contain only alphabets")
	private String firstName;

	@NotBlank(message = "LastName should not be empty")
	@Pattern(regexp = "[a-zA-Z ]+",message = "Should contain only alphabets")
	private String lastName;

	@Min(value = 1, message = "Age Should Not Be 0 or Negative")
	@Max(value = 150, message = "Age Cant be more than 150")
	private Integer age;

	@NotNull(message = "Choose Gender")
	private String gender;

	@Column(name = "contactNumber")
	@Length(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Must Contain Only Digits")
	private String contact;
	@NotBlank(message = "Must not Be Empty")
	@Length(min = 8, max = 20, message = "Password length must be greater than or equal to 8")
	@Length(max = 20, message = "Password length must be less than or equal to 20")
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminBean [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", contact=" + contact + ", password=" + password + "]";
	}

}
