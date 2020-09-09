package com.company.p2_CompanyRoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Department> departments = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            Department department = null;
            if (departments.size() == 0) {
                department = new Department(departmentName);
                departments.add(department);
            } else {

                for (Department currentDepartment : departments) {
                    if (currentDepartment.getName().equals(departmentName)) {
                        department = currentDepartment;
                        break;
                    } else {
                        department = new Department(departmentName);
                        departments.add(department);

                    }
                }
            }


            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    try {
                        Integer.parseInt(tokens[4]);
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } catch (NumberFormatException e) {
                        employee = new Employee(name, salary, position, department, tokens[4]);
                    }
                    break;
                default:
                    employee = new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5]));
                    break;

            }
            for (int j = 0; j < departments.size(); j++) {
                if (employee.getDepartment().getName().equals(departments.get(j).getName())) {
                    List<Employee> employees = departments.get(j).getEmployees();
                    employees.add(employee);
                    departments.get(j).setEmployees(employees);
                }
            }

        }
    }
}
