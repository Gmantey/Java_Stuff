package com.goddy.Project3;
import java.io.*;
import java.util.ArrayList;
/**
 * Project 3 - Catalog
 * <p>
 * This catalog class will store the entire library's
 * catalog of books
 *
 * @author Godfred Mantey, LO1
 * @version March 28, 2020
 */
public class Catalog {
    private ArrayList<Book> catalog = new ArrayList<>();

    // Empty constructor
    public Catalog() {
    }

    // Load File Method
    public void loadCatalog(File bookCatalog) throws UnsupportedFileException, FileNotFoundException, IOException {
        if (bookCatalog.exists()) {
            FileReader fr = new FileReader(bookCatalog);
            BufferedReader bfr = new BufferedReader(fr);

            while (true) {
                boolean checked = true;
                String line = bfr.readLine();
                if (line == null)
                    break;
                String[] readbook = line.split(", ");

                if (readbook.length != 10) {
                    throw new UnsupportedFileException(" ");
                }
                if (readbook[9].equals("No")) {
                    checked = false;
                }
                Book book = new Book(Integer.parseInt(readbook[0]), readbook[1],
                        readbook[2], readbook[3], readbook[4], readbook[5],
                        Integer.parseInt(readbook[6]), Integer.parseInt(readbook[7]),
                        Double.parseDouble(readbook[8]), checked);

                catalog.add(book);
            }
            bfr.close();
        }
    }

    // Write Catalog Method
    public void writeCatalog(File bookCatalog) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(bookCatalog);
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < catalog.size(); i++) {

            pw.printf("%d, %s, %s, %s, %s, %s, %d, %d, %.2f, %s\n", catalog.get(i).getId(), catalog.get(i).getTitle(),
                    catalog.get(i).getAuthorFirstName(), catalog.get(i).getAuthorLastName(),
                    catalog.get(i).getPublisher(), catalog.get(i).getPublisherCity(),
                    catalog.get(i).getPublicationYear(), catalog.get(i).getNumCheckouts(),
                    catalog.get(i).getPurchasePrice(), currentlyloaned(catalog.get(i).isCurrentlyLoaned()));
        }
        pw.close();
    }

    // Add Book Method
    public void addBook(Book book) {
        catalog.add(book);
    }

    // Remove Book Method
    public boolean removeBook(int id) {
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getId() == id) {
                catalog.remove(i);
                return true;
            }
        }
        return false;
    }

    // Loan Method
    public boolean loanBook(int id) {
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getId() == id) {
                if (catalog.get(i).isCurrentlyLoaned() == false) {
                    catalog.get(i).setCurrentlyLoaned(true);
                    catalog.get(i).setNumCheckouts(catalog.get(i).getNumCheckouts() + 1);
                    return true;
                } else
                    return false;
            }
        }
        return (false);
    }

    // Find Method
    public ArrayList<Book> findBooks(String search) {
        ArrayList<Book> catalognew = new ArrayList<Book>();
        String newSearch = search.toLowerCase();

        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getTitle().toLowerCase().contains(newSearch) ||
                    catalog.get(i).getAuthorFirstName().toLowerCase().contains(newSearch) ||
                    catalog.get(i).getAuthorLastName().toLowerCase().contains(newSearch) ||
                    catalog.get(i).getPublisher().toLowerCase().contains(newSearch)
                    || catalog.get(i).getPublisherCity().toLowerCase().contains(newSearch)) {

                catalognew.add(catalog.get(i));
            }
        }
        return catalognew;
    }

    // Book sale Method
    public ArrayList<Book> bookSale() {
        ArrayList<Book> catalognew2 = new ArrayList<>();

        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getNumCheckouts() < 10 && (!catalog.get(i).isCurrentlyLoaned())) {
                catalognew2.add(catalog.get(i));
            }
        }
        return catalognew2;
    }
    // AvgCost Method
    public double avgCostPerLoan() {
        double answer = 0;
        for (int i = 0; i < catalog.size(); i++) {
            answer += catalog.get(i).averageLoanCost();
        }
        return (answer / catalog.size());
    }
    // Print Method
    public void printCatalogToFile(int mode, File newFile) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream(newFile);
        PrintWriter pw = new PrintWriter(fos);
        String checked;
        switch (mode) {
            case 1:
                for (int i = 0; i < catalog.size(); i++) {
                    pw.println("MLA: " + catalog.get(i).getAuthorLastName() + ", "
                            + catalog.get(i).getAuthorFirstName() +
                            ". " + catalog.get(i).getTitle() + ". " +
                            catalog.get(i).getPublisher() + ", " +
                            catalog.get(i).getPublicationYear() + ".");
                }
                pw.close();
                break;
            case 2:

                for (int i = 0; i < catalog.size(); i++) {
                    pw.println("APA: " + catalog.get(i).getAuthorLastName() + ", "
                            + catalog.get(i).getAuthorFirstName().charAt(0) +
                            ". (" + catalog.get(i).getPublicationYear() + "). "
                            + catalog.get(i).getTitle() + ". " +
                            catalog.get(i).getPublisherCity() + ": "
                            + catalog.get(i).getPublisher() + ".");
                }
                pw.close();
                break;
            case 3:
                for (int i = 0; i < catalog.size(); i++) {

                    pw.println("CS: " + catalog.get(i).getAuthorLastName() + ", "
                            + catalog.get(i).getAuthorFirstName() +
                            ". " + catalog.get(i).getTitle() + ". Number of Checkouts: "
                            + catalog.get(i).getNumCheckouts()
                            + ". Currently Checked Out: " + currentlyloaned(catalog.get(i).isCurrentlyLoaned()) + ".");
                }
                pw.close();
                break;
        }

    }
    // Number of Loaned Books
    public int numBooksLoaned() {
        int counter = 0;
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).isCurrentlyLoaned()) {
                counter++;
            }
        }
        return counter;
    }

    public String currentlyloaned(boolean x) {
        String currentLoan = null;

        if (x == true) {
            currentLoan = "Yes";
        } else currentLoan = "No";

        return currentLoan;
    }

    // Getters and Setters
    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }
}