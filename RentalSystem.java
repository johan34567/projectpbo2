import java.util.ArrayList;

class RentalSystem {
  public ArrayList<Motor> motors = new ArrayList<Motor>();
  public ArrayList<Customer> customers = new ArrayList<Customer>();

  public void addCustomer(Customer customer) {
    for (Customer existingCustomer : this.customers) {
      if (existingCustomer.id.equals(customer.id)) {
        System.out.println("Error: Customer with ID " + customer.id + " already exists!");
        return;
      }
    }
    this.customers.add(customer);
  }

  public void addMotor(Motor motor) {
    for (Motor existingMotor : this.motors) {
      if (existingMotor.getId().equals(motor.getId())) {
        System.out.println("Error: Motor with ID " + motor.getId() + " already exists!");
        return;
      }
    }
    this.motors.add(motor);
  }

  public void rentMotor(String customerId, String motorId) {
    try {
      Motor motor = this.getMotorById(motorId, this.motors);
      if (motor == null) {
        throw new Exception("Motor with ID " + motorId + " not found!");
      }
      this.motors.remove(motor);

      Customer customer = this.getCustomerById(customerId);
      if (customer == null) {
        throw new Exception("Customer with ID " + customerId + " not found!");
      }
      int customerIndex = this.getCustomerIndex(customer);
      this.customers.get(customerIndex).rentMotor(motor);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void returnMotor(String customerId, String motorId) {
    Customer customer = this.getCustomerById(customerId);
    int customerIndex = this.getCustomerIndex(customer);

    Motor motor = this.getMotorById(motorId, customer.rentedMotors);
    this.motors.add(motor);
    this.customers.get(customerIndex).returnMotor(motor);
  }

  private int getCustomerIndex(Customer customer) {
    return this.customers.indexOf(customer);
  }

  private Customer getCustomerById(String id) {
    for (Customer customer : this.customers) {
      if (customer.id.equals(id)) {
        return customer;
      }
    }
    return null;
  }

  private Motor getMotorById(String id, ArrayList<Motor> list) {
    for (Motor motor : list) {
      if (motor.getId().equals(id)) {
        return motor;
      }
    }
    return null;
  }
}

