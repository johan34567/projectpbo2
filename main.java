import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static RentalSystem rentalSystem = new RentalSystem();

  public static void main(String[] args) {
    initMotorData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showMotorList();
      } else if (selectedMenu == 2) {
        showCustomers();
      } else if (selectedMenu == 3) {
        addCustomer();
      } else if (selectedMenu == 4) {
        rentMotor();
      } else if (selectedMenu == 5) {
        returnMotor();
      } else if (selectedMenu == 6) {
        addMotor();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. Show motor list");
    System.out.println("2. Show customers list");
    System.out.println("3. Add customer");
    System.out.println("4. Rent a motor");
    System.out.println("5. Return a motor");
    System.out.println("6. Add motor");
    System.out.println("================================");
  }

  public static void initMotorData() {
    Motor motor1 = new Motor("1", "Honda Vario");
    Motor motor2 = new Motor("2", "Yamaha NMax");
    Motor motor3 = new Motor("3", "Suzuki Smash");
    Motor motor4 = new Motor("4", "Kawasaki Ninja");

    Customer customer1 = new Customer();
    customer1.id = "1";
    customer1.name = "John";

    Customer customer2 = new Customer();
    customer2.id = "2";
    customer2.name = "Emily";

    Customer customer3 = new Customer();
    customer3.id = "3";
    customer3.name = "Michael";

    Customer customer4 = new Customer();
    customer4.id = "4";
    customer4.name = "Sophia";

    rentalSystem.motors.add(motor1);
    rentalSystem.motors.add(motor2);
    rentalSystem.motors.add(motor3);
    rentalSystem.motors.add(motor4);

    rentalSystem.customers.add(customer1);
    rentalSystem.customers.add(customer2);
    rentalSystem.customers.add(customer3);
    rentalSystem.customers.add(customer4);
  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int choice = scan.nextInt();
    return choice;
  }

  public static void showMotorList() {
    for (Motor motor : rentalSystem.motors) {
      if (motor == null) {
        continue;
      }
      System.out.println(motor.getId() + " " + motor.getName());
    }
  }

  public static void showCustomers() {
    for (Customer customer : rentalSystem.customers) {
      System.out.println(customer.id + " " + customer.name);
    }
  }

  public static void addCustomer() {
    Customer customer = new Customer();

    System.out.print("id : ");
    customer.id = scan.next();

    System.out.print("name : ");
    customer.name = scan.next();

    rentalSystem.addCustomer(customer);
  }

  public static void addMotor() {
    Motor motor = new Motor("", "");

    System.out.print("id : ");
    motor.setId(scan.next());

    System.out.print("name : ");
    motor.setName(scan.next());

    rentalSystem.addMotor(motor);
  }

  public static void rentMotor() {
    System.out.print("customer id : ");
    String customerId = scan.next();

    System.out.print("motor id : ");
    String motorId = scan.next();

    rentalSystem.rentMotor(customerId, motorId);
  }

  public static void returnMotor() {
    System.out.print("customer id : ");
    String customerId = scan.next();

    System.out.print("motor id : ");
    String motorId = scan.next();

    rentalSystem.returnMotor(customerId, motorId);
  }
}
