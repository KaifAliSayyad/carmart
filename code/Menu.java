package carmart.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import carmart.entities.Company;
import carmart.entities.FuelType;
import carmart.entities.Model;

import carmart.db.DatabaseOperations;

public class Menu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Company readCompany(List<Company> companies) {
        Company company = null;
        do {
            System.out.println("Select a Company : ");
            for (int i = 0; i < companies.size(); i++) {
                System.out.println((i + 1) + ". " + companies.get(i).getName());
            }

            try {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1) throw new Exception();
                if (choice == companies.size() + 1) {
                    company = DatabaseOperations.addCompany();
                } else {
                    company = companies.get(choice - 1);
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        } while (company == null);
        return company;
    }

    public static int readModel() {
        int model = -1;
        do {
            System.out.println("Enter the model year : ");
            try {
                model = Integer.parseInt(br.readLine());
                if (model < 1800 || model > 2025) {
                    System.out.println("Invalid model year. Please enter a valid model year.");
                    model = -1;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid model year.");
            }
        } while (model == -1);
        return model;
    }

    public static int readSeater() {
        int seats = -1;
        do {
            System.out.println("Enter the number of seats : ");
            try {
                seats = Integer.parseInt(br.readLine());
                if (seats < 2 || seats > 10) {
                    System.out.println("Invalid number of seats. Please enter a valid number of seats.");
                    seats = -1;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid number of seats.");
            }
        } while (seats == -1);
        return seats;
    }

    public static FuelType readFuelType(List<FuelType> fuelTypes) {
        FuelType fuelType = null;
        do {
            System.out.println("Select a Fuel Type : ");
            for (int i = 0; i < fuelTypes.size(); i++) {
                System.out.println((i + 1) + ". " + fuelTypes.get(i).getName());
            }

            try {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1) throw new Exception();
                if (choice == fuelTypes.size() + 1) {
                    fuelType = DatabaseOperations.addFuelType();
                } else {
                    fuelType = fuelTypes.get(choice - 1);
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        } while (fuelType == null);
        return fuelType;
    }

    public static Model readModelType(List<Model> models) {
        Model model = null;
        do {
            System.out.println("Select a Model Type : ");
            for (int i = 0; i < models.size(); i++) {
                System.out.println((i + 1) + ". " + models.get(i).getName());
            }

            try {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1) throw new Exception();
                if (choice == models.size() + 1) {
                    model = DatabaseOperations.addModel();
                } else {
                    model = models.get(choice - 1);
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        } while (model == null);
        return model;
    }

    public static double readPrice() {
        double price = -1;
        do {
            System.out.println("Enter the price : ");
            try {
                price = Double.parseDouble(br.readLine());
                if (price < 0) {
                    System.out.println("Invalid price. Please enter a valid price.");
                    price = -1;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid price.");
            }
        } while (price == -1);
        return price;
    }

    public static boolean readSold() {
        boolean sold = false;
        boolean validInput = false;
        do {
            System.out.println("Is the car sold?\n1. true\n2. false : ");
            try {
                int choice = Integer.parseInt(br.readLine());
                if (choice == 1) {
                    sold = true;
                    validInput = true;
                } else if (choice == 2) {
                    sold = false;
                    validInput = true;
                } else {
                    System.err.println("Invalid input. Please enter a valid choice.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        } while (!validInput);
        return sold;
    }

    public static int readChoice(int max) {
        int choice = 0;
        do {
            try {
                choice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                if (choice < 1 || choice > max) {
                    System.err.println("Invalid input. Please enter a valid choice.");
                    choice = 0;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        } while (choice == 0);
        return choice;
    }

    public static int readId() {
        int id = -1;
        do {
            System.out.println("Enter the id of the car : ");
            try {
                id = Integer.parseInt(br.readLine());
                if (id < 1) {
                    System.out.println("Invalid id. Please enter a valid id.");
                    id = -1;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid id.");
            }
        } while (id == -1);
        return id;
    }
}
