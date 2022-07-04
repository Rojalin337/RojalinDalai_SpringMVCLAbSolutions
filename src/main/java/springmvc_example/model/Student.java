package springmvc_example.model;

public class Student {
private Integer id;
private String name;
private String department;
private String country;


public Student() {
	super();
}
public Student(Integer id) {
	super();
	this.id = id;
}
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
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
