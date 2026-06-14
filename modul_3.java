public class Car extends Vehicle {
    public int numWheel = 4;

    Car() {
        System.out.println("Car is created");
    }

    public int getNumWheel() {
        return numWheel;
    }

    public void drift() {
        System.out.println("Car is drifting");
    }

    public void honk() {
        System.out.println("Car is honking");
    }
}

public class Driver {

    private Car coupe;

    public Driver() {
        System.out.println("Driver is created.");
        coupe = new Car();
    }

    public void driving() {
        System.out.println("Driver is driving.");
        System.out.println("Using a car that has " + coupe.numWheel + " wheels.");
    }
}

public class DrivingApp { 
    public static void main(String[] args) { 
    Driver miki = new Driver(); 
    miki.driving(); 
    } 
}

public class Sedan extends Car {
    public int numDoors = 3;

    Sedan() {
        System.out.println("Sedan is created");
    }

    public void trunk() {
        System.out.println("Sedan is opening trunk");
    }

    public void honk() {
        super.honk();
        System.out.println("Sedan is honking");
    }

    public void getNumWheels() {
        System.out.println("Sedan has " + getNumWheel() + " wheels");
    }
}

public class Vehicle {
    Vehicle() {
        System.out.println("Vehicle is created");
    }

    protected void drive() {
        System.out.println("Vehicle is driving");
    }

    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}

public class AutomotiveApp { 
    public static void main(String[] args) { 
        Vehicle vehicle = new Vehicle(); 
        Car car = new Car(); 
        Sedan sedan = new Sedan(); 
        
        vehicle.drive(); 
        car.drive(); 
        sedan.drive(); 
        System.out.println("-----------------"); 
        car.drift(); 
        sedan.drift(); 
        
        System.out.println("-----------------"); 
        car.honk(); 
        sedan.honk(); 
        System.out.println("-----------------"); 
        sedan.getNumWheels(); 
    } 
}
