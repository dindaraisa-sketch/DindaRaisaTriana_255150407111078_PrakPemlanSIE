public class AmongUsGame {

    public static void main(String[] args) {

        Crew brian, cindy, david;
        Impostor jacky;

        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Impostor("Jacky");

        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();

        jacky.kill(cindy);

        // Crew yang mati mencoba memanggil meeting
        cindy.callMeeting();

        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);
    }

    public static void check(ICrew crew) {
        if (AmongUsGame.isImpostor(crew))
            System.out.println(crew.getName() + " is the impostor!");
        else
            System.out.println(crew.getName() + " is not the impostor.");
    }

    public static boolean isImpostor(ICrew crew) {
        return (crew instanceof Impostor);
    }
}

public class Crew implements ICrew {

    private String name;
    private boolean alive = true;

    public Crew(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("Crew " + this.name + " is doing work.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick() {
        System.out.println(this.name + " has been kicked from the spaceship.");
    }

    public void die() {
        this.alive = false;
    }

    public void callMeeting() {
        if (alive) {
            System.out.print(this.name + " found a corpse ");
            System.out.print("and calls a meeting. ");
            System.out.println("Let's find the impostor!");
        } else {
            System.out.println(this.name + " is dead and cannot call a meeting.");
        }
    }
}

public class Customer {
    private final Emoney account;
    public Customer(Emoney account) {
        this.account = account;
    }
    public void pay(double amount) {
        this.account.pay(amount);
    }
    public void deposit(double amount) {
        this.account.topUp(amount);
    }
    public void getMoney() {
        this.account.balance();
    }
}

public abstract class Emoney {
    protected double balance;
    protected String name;
    public abstract void topUp(double amount);
    public abstract void pay(double amount);
    public void balance() {
        System.out.print(this.name + " balance: ");
        System.out.println(String.valueOf(this.balance));
    }
}

public interface ICrew extends IKickable {
    void doWork();
    String getName();
}

public interface IImpostor extends IKickable {
    void kill(ICrew crew);
}

public interface IKickable {
    void kick();
}

public class Impostor implements IImpostor, ICrew {

    private final String name;

    public Impostor(String name) {
        this.name = name;
    }

    @Override
    public void kill(ICrew crew) {
        System.out.println(crew.getName() + " has been killed!");

        if (crew instanceof Crew) {
            ((Crew) crew).die();
        }
    }

    @Override
    public void doWork() {
        System.out.println("Impostor " + this.name + " is doing work.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick() {
        System.out.println(this.name + " has been kicked from the spaceship.");
    }
}

public class Kris extends Emoney {

    public Kris() {
        this.name = "Kris";
    }
    @Override
    public void topUp(double amount) {
        System.out.println("Top up: " + amount);
        this.balance += (amount + (0.05 * amount));
        this.balance();
    }
    @Override
    public void pay(double amount) {
        double amountToPay = amount - (0.03 * amount);

        if (this.balance > amountToPay) {
            this.balance -= amountToPay;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else {
            System.out.println("Not enough balance.");
        }

        this.balance();
    }
}

public class Opo extends Emoney {
    public Opo() { this.name = "Opo"; }
    @Override
    public void topUp(double amount) {
    System.out.println("Top up: " + amount);
    this.balance += amount;
    this.balance();
    }
    @Override
    public void pay(double amount) {
        double amountToPay = amount - (0.1 * amount);
        if (this.balance > amountToPay) {
            this.balance -= amountToPay;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else System.out.println("Not enough balance.");
        this.balance();
    }
}

public class ShopiPay extends Emoney {
    public ShopiPay() { this.name = "ShopiPay"; }
    @Override
    public void topUp(double amount) {
        System.out.println("Top up: " + amount);
        this.balance += (amount + (0.05 * amount));
        this.balance();
    }
    @Override
    public void pay(double amount) {
        if (this.balance > amount) {
            this.balance -= amount;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else System.out.println("Not enough balance.");
        this.balance();
    }
}

public class Shopipedia {
    public static void main(String[] args) {

        Emoney kris = new Emoney() {

            {
                this.name = "Kris";
            }

            @Override
            public void topUp(double amount) {
                System.out.println("Top up: " + amount);
                this.balance += (amount + (0.05 * amount));
                this.balance();
            }

            @Override
            public void pay(double amount) {
                double amountToPay = amount - (0.03 * amount);

                if (this.balance > amountToPay) {
                    this.balance -= amountToPay;
                    System.out.printf("Pay " + amount);
                    System.out.println(" using " + this.name);
                } else {
                    System.out.println("Not enough balance.");
                }

                this.balance();
            }
        };

        Customer customerKris = new Customer(kris);

        customerKris.deposit(10000);
        customerKris.pay(2000);
        customerKris.pay(3000);
        customerKris.deposit(1000);
        customerKris.pay(7000);
    }
}
