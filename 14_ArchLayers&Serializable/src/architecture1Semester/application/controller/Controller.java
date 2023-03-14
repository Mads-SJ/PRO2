package architecture1Semester.application.controller;

import architecture1Semester.application.model.Company;
import architecture1Semester.application.model.Employee;
import architecture1Semester.storage.Storage;
import opg1.MyTime;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

public class Controller {
    private static Controller instance;
    private Storage storage;

    private Controller() {
        storage = Storage.getStorage();
    }

    public static Controller getController() {
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }

    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        storage.addCompany(company);
        return company;
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public void deleteCompany(Company company) {
        storage.removeCompany(company);
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    /**
     * Get all the companies
     */
    public ArrayList<Company> getCompanies() {
        return storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public Employee createEmployee(String name, int wage) {
        Employee employee = new Employee(name, wage);
        storage.addEmployee(employee);
        return employee;
    }

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0, company!=null.
     */
    public Employee createEmployee(String name, int wage, Company company) {
        Employee employee = createEmployee(name, wage);
        company.addEmployee(employee);
        return employee;
    }

    /**
     * Deletes the employee.
     */
    public void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
        }
        storage.removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public void updateEmployee(Employee employee, String name, int wage) {
        employee.setName(name);
        employee.setWage(wage);
    }
    
    /**
     * Adds the employee to the company. Removes the employee from the old company if present.
     */
    public void addEmployeeToCompany(Employee employee, Company company) {
        company.addEmployee(employee);
    }
    
    /**
     * Removes the employee from the old company if not null.
     * @param company The old company. Can be null.
     * @param employee The employee to remove.
     */
    public void removeEmployeeFromCompany(Employee employee, Company company) {
        if (company != null) {
            company.removeEmployee(employee);            
        }
    }

    /**
     * Get all the employees.
     */
    public ArrayList<Employee> getEmployees() {
        return storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    public void loadStorage() {
        try (
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mads\\Desktop\\datamatiker\\2. semester\\PRO2\\PRO2\\14_ArchLayers&Serializable\\src\\architecture1Semester\\storage.txt");
                ObjectInputStream in = new ObjectInputStream(fileInputStream)
        ) {
            Object o = in.readObject();
            if (o instanceof Storage) {
                storage = (Storage) o;
                System.out.println("Storage loaded.");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStorage() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mads\\Desktop\\datamatiker\\2. semester\\PRO2\\PRO2\\14_ArchLayers&Serializable\\src\\architecture1Semester\\storage.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ) {
            out.writeObject(storage);
            System.out.println("Storage saved.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
