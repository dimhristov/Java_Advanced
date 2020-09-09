package com.company.p2_CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public String getName() {
        return this.name;
    }

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
