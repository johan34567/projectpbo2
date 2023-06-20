import java.util.ArrayList;

class Customer {
  public String id;
  public String name;
  public ArrayList<Motor> rentedMotors = new ArrayList<Motor>();

  public void rentMotor(Motor motor) {
    this.rentedMotors.add(motor);
  }

  public void returnMotor(Motor motor) {
    this.rentedMotors.remove(motor);
  }
}

