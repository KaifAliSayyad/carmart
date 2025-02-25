package carmart.db;

import javax.sql.rowset.JdbcRowSet;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import carmart.entities.Company;
import carmart.entities.Model;
import carmart.entities.FuelType;
import carmart.db.DBConnection;
import carmart.entities.Car;
import carmart.utils.Menu;



public class DatabaseOperations {
    private static JdbcRowSet rs;
    static{
        rs = DBConnection.getConnection();
    }

    public static List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM company");
            rs.execute();
            while (rs.next()) {
                companies.add(new Company(rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return companies;
    }

    public static List<Model> getModels() {
        List<Model> models = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM model");
            rs.execute();
            while (rs.next()) {
                models.add(new Model(rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return models;
    }

    public static List<FuelType> getFuelTypes() {
        List<FuelType> fuelTypes = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM fuel_type");
            rs.execute();
            while (rs.next()) {
                fuelTypes.add(new FuelType(rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return fuelTypes;
    }

    public static List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM car");
            rs.execute();
            while (rs.next()) {
                cars.add(new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cars;
    }

    public static void addCar(Car car) {
        try {
            rs.setCommand("select * from car limit 1");
            rs.execute();
            rs.moveToInsertRow();
            rs.setString("company", car.getCompany().getName());
            rs.setInt("model", car.getModel());
            rs.setInt("seater", car.getSeater());
            rs.setString("fuel_type", car.getFuelType().getName());
            rs.setString("type", car.getType().getName());
            rs.setDouble("price", car.getPrice());
            rs.setBoolean("sold", car.isSold());
            rs.insertRow();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Car getCar(int id) {
        Car car = null;
        try {
            rs.setCommand("SELECT * FROM car WHERE id = ?");
            rs.setInt(1, id);
            rs.execute();
            if (rs.next()) {
                car = new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return car;
    }

    //update only price
    public static void updateCar(Car car) {
        try {
            System.out.println("Enter the new price : ");
            rs.setCommand("UPDATE car SET price = ? WHERE id = ?");
            rs.setDouble(1, Menu.readPrice());
            rs.setInt(2, car.getId());
            rs.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Company addCompany(){
        System.out.println("Enter the name of the company : ");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String name =  br.readLine();
            rs.setCommand("INSERT INTO Company (name) VALUES (?)");
            rs.setString(1, name);
            rs.execute();
            return new Company(name);
        }catch(Exception e){
            System.err.println("Invalid input. Please enter a valid company name.");
            return addCompany();
        }
    } 

    public static Model addModel(){
        System.out.println("Enter the name of the model : ");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String name =  br.readLine();
            rs.setCommand("INSERT INTO Model (name) VALUES (?)");
            rs.setString(1, name);
            rs.execute();
            return new Model(name);
        }catch(Exception e){
            System.err.println("Invalid input. Please enter a valid model name.");
            return addModel();
        }
    }

    public static FuelType addFuelType(){
        System.out.println("Enter the name of the fuel type : ");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String name =  br.readLine();
            rs.setCommand("INSERT INTO FuelType (name) VALUES (?)");
            rs.setString(1, name);
            rs.execute();
            return new FuelType(name);
        }catch(Exception e){
            System.err.println("Invalid input. Please enter a valid fuel type.");
            return addFuelType();
        }
    }

    public static List<Car> getCarsByCompany(Company c){
        List<Car> cars = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM car WHERE company = ?");
            rs.setString(1, c.getName());
            rs.execute();
            while (rs.next()) {
                cars.add(new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cars;
    }

    public static List<Car> getCarsByType(Model m){
        List<Car> cars = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM car WHERE type = ?");
            rs.setString(1, m.getName());
            rs.execute();
            while (rs.next()) {
                cars.add(new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cars;
    }

    public static List<Car> getCarsByPrice(double min, double max){
        List<Car> cars = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM car WHERE price >= ? AND price <= ?");
            rs.setDouble(1, min);
            rs.setDouble(2, max);
            rs.execute();
            while (rs.next()) {
                cars.add(new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cars;
    }

    public static void closeConnection() {
        try {
            DBConnection.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Car> getUnsoldCars(){
        List<Car> cars = new ArrayList<>();
        try {
            rs.setCommand("SELECT * FROM car WHERE sold = false");
            rs.execute();
            while (rs.next()) {
                cars.add(new Car(rs.getInt(1), new Company(rs.getString(2)), rs.getInt(3), rs.getInt(4), new FuelType(rs.getString(5)), new Model(rs.getString(6)), rs.getDouble(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cars;
    }

    public static void updateSoldCars(Car car){
        try {
            rs.setCommand("UPDATE car SET sold = true WHERE sold = false and id = ?");
            rs.setInt(1, car.getId());
            rs.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
