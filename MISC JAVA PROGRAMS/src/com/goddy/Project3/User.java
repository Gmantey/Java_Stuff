package com.goddy.Project3;

import java.io.*;
import java.util.ArrayList;

/**
 * Project 3 - User
 * <p>
 * This User Class stores the Employee and Patrons Arraylist
 * along with a few methods used to modify those lists.
 *
 * @author Godfred Mantey, LO1
 * @version March 28, 2020
 */
public class User {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Patron> patrons = new ArrayList<>();

    // Empty Constructor
    public User() {
    }

    public void loadUsers(File employeeRecords, File patronRecords) throws UnsupportedFileException,
            FileNotFoundException, IOException {
        if (employeeRecords.exists() && patronRecords.exists()) {
            // Employee Records Readers
            FileReader fr = new FileReader(employeeRecords);
            BufferedReader bfr = new BufferedReader(fr);
            // Patrons Records Readers
            FileReader fr2 = new FileReader(patronRecords);
            BufferedReader bfr2 = new BufferedReader(fr2);

            while (true) {
                String line2 = bfr2.readLine();
                if (line2 == null)
                    break;
                String[] readPatron = line2.split(", ");
                if (readPatron.length != 6) {
                    throw new UnsupportedFileException("Patron User Not Supported");
                }
                // Builds the Patron
                ArrayList<Integer> bookLoanList = new ArrayList<>();
                String[] bookLoanListB = readPatron[5].split(" ");
                for (int i = 0; i < bookLoanListB.length; i++) {
                    bookLoanList.add(Integer.parseInt(bookLoanListB[i]));
                }
                Patron patron = new Patron(Integer.parseInt(readPatron[0]), readPatron[1],
                        readPatron[2], readPatron[3],
                        readPatron[4], bookLoanList);
                patrons.add(patron);
            }
            bfr2.close();

            while (true) {
                String line = bfr.readLine();
                if (line == null)
                    break;
                String[] readEmployee = line.split(", ");

                if (readEmployee.length != 6) {
                    throw new UnsupportedFileException("Employee User Not Supported");
                }
                // Build the Employee
                ArrayList<String> actionList = new ArrayList<String>();
                String[] actionListB = readEmployee[5].split(" ");
                for (int i = 0; i < actionListB.length; i++) {
                    actionList.add(actionListB[i]);
                }
                Employee employee = new Employee(Integer.parseInt(readEmployee[0]),
                        readEmployee[1], readEmployee[2], Double.parseDouble(readEmployee[3]),
                        Double.parseDouble(readEmployee[4]), actionList);
                employees.add(employee);
            }
            bfr.close();
        }
    }

    // Write User
    public void writeUsers(File employeeRecords, File patronRecords) throws FileNotFoundException {
        // Employee Records
        FileOutputStream fos = new FileOutputStream(employeeRecords);
        PrintWriter pw = new PrintWriter(fos);

        // Patron Records
        FileOutputStream fos1 = new FileOutputStream(patronRecords);
        PrintWriter pw1 = new PrintWriter(fos1);

        // Employee PrintOut
        for (int i = 0; i < employees.size(); i++) {
            pw.printf("%d, %s, %s, %.2f, %.0f,", employees.get(i).getId(), employees.get(i).getName(),
                    employees.get(i).getAddress(), employees.get(i).getHourlyRate(),
                    employees.get(i).getHoursWorked());

            for (int j = 0; j < employees.get(i).getActionList().size(); j++) {
                pw.printf(" %s", employees.get(i).getActionList().get(j));
            }
            pw.printf("\n");
        }
        pw.close();

        // Patron PrintOut
        for (int i = 0; i < patrons.size(); i++) {
            pw1.printf("%d, %s, %s, %s, %s,", patrons.get(i).getId(), patrons.get(i).getName(),
                    patrons.get(i).getAddress(), patrons.get(i).getEmail(), patrons.get(i).getPhoneNumber());

            for (int j = 0; j < patrons.get(i).getBookLoanList().size(); j++) {
                pw1.printf(" %d", patrons.get(i).getBookLoanList().get(j));
            }
            pw1.printf("\n");
        }
        pw1.close();
    }

    // Add  Employee Method
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Add  Patron Method
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Remove Employee Method
    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    // Remove Patron Method
    public boolean removePatron(int id) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getId() == id) {
                patrons.remove(i);
                return true;
            }
        }
        return false;
    }

    // Getters and Setters
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(ArrayList<Patron> patrons) {
        this.patrons = patrons;
    }
}
