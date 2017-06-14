package com.etc.entity;

public class Employee {
    private Integer id;

    private String name;

    private String password;

    private String tel;

    private String email;

    private Integer dept;

    private Integer powerid;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public Integer getPowerid() {
		return powerid;
	}

	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + ", tel=" + tel + ", email=" + email + ", dept="
				+ dept + ", powerid=" + powerid + "]";
	}

	public Employee(String name, String password, String tel,
			String email, Integer dept, Integer powerid) {
		super();
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.dept = dept;
		this.powerid = powerid;
	}
    
}