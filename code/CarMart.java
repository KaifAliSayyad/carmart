
package carmart.main;

import carmart.services.CarService;
import carmart.utils.Menu;

public class CarMart {
    public static void main(String[] args) {
        CarService cs  = new CarService();
        int choice = 0;
        do{
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Update");
            System.out.println("4. Sold");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Menu.readChoice(5);
            switch(choice){
                case 1:
                    cs.addCar();
                    break;
                case 2:
                    cs.searchCar();
                    break;
                case 3:
                    cs.updateCar();
                    break;
                case 4:
                    cs.soldCar();
                    break;
                case 5:
                    cs.closeConnection();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice != 5);
    }
}
