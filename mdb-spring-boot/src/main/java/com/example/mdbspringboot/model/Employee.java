package com.example.mdbspringboot.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employees")
public class Employee implements Comparable<Employee> {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private int id;
    private int salary;
    private String firstname;
    private String lastname;
    public int getId() {
        return id;
    }
    public String getLastname() {
        return lastname;
    }
    public int getSalary() {
        return salary;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public Employee(int id, int salary, String firstname, String lastname){
        this.id=id;
        this.salary=salary;
        this.firstname=firstname;
        this.lastname=lastname;
    }
    public Employee(int salary, String firstname, String lastname) {
    	this.salary=salary;
        this.firstname=firstname;
        this.lastname=lastname;
    }
    public Employee() {
    	
    }
    public Employee(int id){
        this.id=id;
    }

    public boolean equals(Object o){
        return o instanceof Employee && (((Employee) o).id == this.id);
    }
    public String toString(){
        return "Name:"+this.firstname+" "+this.lastname+" id: "+this.id+",sal="+this.salary;
    }
    public int hashCode(){
        int hash = 7;//pick prime
        hash = 17*hash + this.id;//for each member in .equals method incorporate in hash
        return hash;
    }
    @Override
    public int compareTo(Employee e){
        return this.id- e.id;
    }
}