package carmart.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import carmart.entities.Company;
import carmart.entities.FuelType;
import carmart.entities.Model;

import carmart.db.DatabaseOperations;

public class Menu {

    public static Company readCompany(List<Company> companies) {
        System.out.println("Select a Company : ");
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(i).getName());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1) throw new Exception();
                if (choice == companies.size() + 1) {
                    return DatabaseOperations.addCompany();
                } else {
                    return companies.get(choice - 1);
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static int readModel() {
        System.out.println("Enter the model year : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int model = Integer.parseInt(br.readLine());
                if (model < 1800 || model > 2025) {
                    System.out.println("Invalid model year. Please enter a valid model year.");
                } else {
                    return model;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid model year.");
            }
        }
    }

    public static int readSeater() {
        System.out.println("Enter the number of seats : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int seats = Integer.parseInt(br.readLine());
                if (seats < 2 || seats > 10) {
                    System.out.println("Invalid number of seats. Please enter a valid number of seats.");
                } else {
                    return seats;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid number of seats.");
            }
        }
    }

    public static FuelType readFuelType(List<FuelType> fuelTypes) {
        System.out.println("Select a Fuel Type : ");
        for (int i = 0; i < fuelTypes.size(); i++) {
            System.out.println((i + 1) + ". " + fuelTypes.get(i).getName());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice < 1) throw new Exception();
                if (choice == fuelTypes.size() + 1) {
                    return DatabaseOperations.addFuelType();
                }
                return fuelTypes.get(choice - 1);
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static Model readModelType(List<Model> models) {
        System.out.println("Select a Model Type : ");
        for (int i = 0; i < models.size(); i++) {
            System.out.println((i + 1) + ". " + models.get(i).getName());
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choice = Integer.parseInt(br.readLine());
                if (choice == 1) throw new Exception();
                if (choice == models.size() + 1) {
                    return DatabaseOperations.addModel();
                }
                return models.get(choice - 1);
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static double readPrice() {
        System.out.println("Enter the price : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                double price = Double.parseDouble(br.readLine());
                if (price < 0) {
                    System.out.println("Invalid price. Please enter a valid price.");
                } else {
                    return price;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    public static boolean readSold() {
        System.out.println("Is the car sold?\n1. true\n2. false : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                return Integer.parseInt(br.readLine()) == 1;
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid choice.");
            }
        }
    }

    public static int readChoice(int max) {
        try{
            int choice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            return choice;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int readId(){
        System.out.println("Enter the id of the car : ");
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int id = Integer.parseInt(br.readLine());
                if (id < 1) {
                    System.out.println("Invalid id. Please enter a valid id.");
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid id.");
            }
        }
    }
}
