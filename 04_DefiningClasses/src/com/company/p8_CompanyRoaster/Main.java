package com.company.p8_CompanyRoaster;


import java.util.*;

public class Main {

    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String mail = "n/a";
        private int age = -1;

        public Employee(String name, double salary, String position, String department) {

            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.mail = "n/a";
            this.age = -1;

        }

        public Employee(String name, double salary, String position, String department, String mail) {
            this(name, salary, position, department);
            this.mail = mail;
        }

        public Employee(String name, double salary, String position, String department, int age) {
            this(name, salary, position, department);
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String mail, int age) {
            this(name, salary, position, department, mail);
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getMail() {
            return this.mail;
        }

        public int getAge() {
            return this.age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDep() {
            return department;
        }

    }

    //до тук е Employee класът.
    private static String currentDep;
    private static double currentSalary = Double.MIN_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> allEmployees = new ArrayList<>();
        Map<String, List<Double>> depts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String dep = info[3];
            String mail = "";
            int age = -1;
            Employee employee;
            if (info.length == 4) {
                employee = new Employee(name, salary, position, dep);
            } else if (info.length == 6) {
                employee = new Employee(name, salary, position, dep, info[4], Integer.parseInt(info[5]));
            } else {
                try {
                    age = Integer.parseInt(info[4]);
                    employee = new Employee(name, salary, position, dep, age);
                } catch (NumberFormatException ex) {
                    employee = new Employee(name, salary, position, dep, info[4]);
                }
            }

            allEmployees.add(employee);
            depts.putIfAbsent(dep, new ArrayList<>());
            depts.get(dep).add(salary);
        }


        Map<String, Double> newDepts = new HashMap<>();
        depts.forEach((k, v) -> {
            newDepts.put(k,
                    v.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
        });


        newDepts.forEach((key, value) -> {
            if (value > currentSalary) {
                currentSalary = value;
                currentDep = key;
            }
        });

        System.out.printf("Highest Average Salary: %s%n", currentDep);

        List<Employee> finalList = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getDep().equals(currentDep)) {
                finalList.add(employee);
            }
        }
        finalList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        finalList.forEach(employee -> {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getMail(), employee.getAge());
        });
    }
}
