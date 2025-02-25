package carmart.services;

import java.util.List;

import javax.xml.crypto.Data;

import carmart.entities.Car;
import carmart.entities.Company;
import carmart.entities.FuelType;
import carmart.entities.Model;
import carmart.db.DBConnection;
import carmart.db.DatabaseOperations;

import carmart.utils.Menu;

import java.util.ArrayList;


public class CarService{

    private static List<Company> companies = new ArrayList<>();
    private static List<Model> models = new ArrayList<>();
    private static List<FuelType> fuelTypes = new ArrayList<>();

    public CarService(){
        //populate companies, models and fuelTypes using the data from the database
        companies = getCompanies();
        models = getModels();
        fuelTypes = getFuelTypes();
    }

    public static List<Company> getCompanies(){
        return DatabaseOperations.getCompanies();
    }

    public static List<Model> getModels(){
        return DatabaseOperations.getModels();
    }

    public static List<FuelType> getFuelTypes(){
        return DatabaseOperations.getFuelTypes();
    }

    public static List<Car> getCars(){
        return DatabaseOperations.getCars();
    }

    public void addCar(){
        System.out.println("Adding car to the database");
        Company company = Menu.readCompany(companies);
        int model = Menu.readModel();
        int seater = Menu.readSeater();
        FuelType fuelType = Menu.readFuelType(fuelTypes); 
        Model type = Menu.readModelType(models);
        double price = Menu.readPrice();
        boolean sold = Menu.readSold();
        DatabaseOperations.addCar(new Car(company, model, seater, fuelType, type, price, sold));
        System.out.println("New Car has been added...");
    }

    public void searchCar(){
        // 2. Search

        // ----------

        // 1. ALL		(All unsold cars)

        // 2. Company	(All cars of specific company)

        // 3. Type		(eg. Hatchback, Sedan, SUV)

        // 4. Price range	(to display all cars in the range of min to max)

        System.out.println("Search using..");
        System.out.println("1. All");
        System.out.println("2. Company");
        System.out.println("3. Type");
        System.out.println("4. Price range");
        System.out.print("Enter your choice: ");
        int choice = Menu.readChoice(4);
        switch(choice){
            case 1:
                List<Car> cars = DatabaseOperations.getCars();
                for(Car car : cars){
                    System.out.println(car);
                }
                break;
            case 2:
                Company company = Menu.readCompany(companies);
                List<Car> carsByCompany = DatabaseOperations.getCarsByCompany(company);
                for(Car car : carsByCompany){
                    System.out.println(car);
                }
                break;
            case 3:
                Model type = Menu.readModelType(models);
                List<Car> carsByType = DatabaseOperations.getCarsByType(type);
                for(Car car : carsByType){
                    System.out.println(car);
                }
                break;
            case 4:
                double min = Menu.readPrice();
                double max = Menu.readPrice();
                List<Car> carsByPrice = DatabaseOperations.getCarsByPrice(min, max);
                for(Car car : carsByPrice){
                    System.out.println(car);
                }
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void updateCar(){
        System.out.println("Updating car in the database");
        System.out.println("Enter the id of the car to be updated: ");
        int id = Menu.readId();
        Car car = DatabaseOperations.getCar(id);
        System.out.println("Car to be update is : "+car);
        DatabaseOperations.updateCar(car);
        System.out.println("Car has been updated...");
    }

    public void soldCar(){
                
        // 4. Sold

        // ------------

        // 1. ALL		(All sold cars)

        // 2. Update	(unsold cars to be updated as sold out)

        // 3. Exit

        System.out.println("Sold Car Menu");
        System.out.println("1. All");
        System.out.println("2. Update");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = Menu.readChoice(3);

        switch(choice){
            case 1:
                List<Car> cars = DatabaseOperations.getCars();
                for(Car car : cars){
                    System.out.println(car);
                }
                break;
            case 2:
                List<Car> unsoldCars = DatabaseOperations.getUnsoldCars();
                for(Car car : unsoldCars){
                    System.out.println(car);
                }
                System.out.println("Enter the id of the car to be updated as sold: ");
                int id = Menu.readId();
                Car car = DatabaseOperations.getCar(id);
                car.setSold(true);
                DatabaseOperations.updateSoldCars(car);
                System.out.println("Car has been updated as sold...");
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void closeConnection(){
        DatabaseOperations.closeConnection();
    }
}

// private int id;     // id serial primary key,
// private Company company;         // company name,
// private int model;       //year 
// private int seater;;    //no. of seats
// private FuelType fuelType;    //petrol, diesel, electric
// private Model type;    //sedan, hatchback, suv
// private double price;   //price
// private boolean sold;   //tru or false