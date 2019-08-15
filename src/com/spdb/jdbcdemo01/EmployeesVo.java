package com.spdb.jdbcdemo01;

public class EmployeesVo {
	private int id;
	private String name;
	private String gender;
	private int age;
	private String degree;
	private String email;
	private String entry_date;
	public EmployeesVo() {}
	public EmployeesVo(int id, String name, String gender, int age, String degree, String email, String entry_date) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.degree = degree;
		this.email = email;
		this.entry_date = entry_date;
	}
	@Override
	public String toString() {
		return "EmployeesVo [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", degree=" + degree
				+ ", email=" + email + ", entry_date=" + entry_date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
}
