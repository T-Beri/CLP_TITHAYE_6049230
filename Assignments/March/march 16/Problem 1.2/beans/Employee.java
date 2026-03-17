package cg.demo.springcore.beans;

public class Employee {
	int empid;
	String name;
	double salary;
	private SBU sbu;
	int age;
	String bizzUnit;
	
	public SBU getSbu() {
		return sbu;
	}
	public void setSbu(SBU sbu) {
		this.sbu = sbu;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBizzUnit() {
		return bizzUnit;
	}
	public void setBizzUnit(String bizzUnit) {
		this.bizzUnit = bizzUnit;
	}
	public String getSBUdeets() {
		return sbu.toString();
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", age=" + age + ", bizzUnit="
				+ bizzUnit + "]";
	}
	
}
