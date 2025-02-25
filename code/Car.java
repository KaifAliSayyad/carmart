package carmart.entities;


// id serial primary key,
// 	company int not null,
// 	model int not null, --year
// 	seater smallint not null,
// 	fuel_type int not null,
// 	type int not null,
// 	price numeric(8, 2) not null,
// 	sold boolean not null,


public class Car{
	private int id;     // id serial primary key,
    private Company company;         // company name,
    private int model;       //year 
    private int seater;;    //no. of seats
    private FuelType fuelType;    //petrol, diesel, electric
    private Model type;    //sedan, hatchback, suv
    private double price;   //price
    private boolean sold;   //tru or false

    public Car(int id, Company company, int model, int seater, FuelType fuelType, Model type, double price, boolean sold) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.seater = seater;
        this.fuelType = fuelType;
        this.type = type;
        this.price = price;
        this.sold = sold;
    }

    public Car(Company company, int model, int seater, FuelType fuelType, Model type, double price, boolean sold) {
        this.company = company;
        this.model = model;
        this.seater = seater;
        this.fuelType = fuelType;
        this.type = type;
        this.price = price;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getSeater() {
        return seater;
    }

    public void setSeater(int seater) {
        this.seater = seater;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Model getType() {
        return type;
    }

    public void setType(Model type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", company=" + company.getName() + ", model=" + model + ", seater=" + seater + ", fuelType="
                + fuelType.getName() + ", type=" + type.getName() + ", price=" + price + ", sold=" + sold + "]";
    }

    
}