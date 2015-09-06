

abstract class Employee
{
   public Employee(String aName) { name = aName; }
   public void setSalary(double aSalary) { salary = aSalary; }
   public String getName() { return name; }
   public double getSalary() { return salary; }

    // must be overridden by subclasses Engineer, etc.
   public abstract double compensation();

    // template method:
   public String format() {
       double comp = this.compensation();  
       return this.getName() + "'s salary is $" + this.getSalary() + 
	   " and his/her total compensation is $" + comp;
   }

   private String name;
   private double salary;
}

class Engineer extends Employee {
    public Engineer(String name, double stockOpt) {
	super(name);
	this.stockOptions = stockOpt;
    }

    public double compensation() {
	return this.getSalary() + this.stockOptions;
    }

    // nobody said to make this attribute visible with an accessor, so no public accessor provide
    private double stockOptions;
}

class Manager extends Employee {
    public Manager(String name, double bonus) {
	super(name);
	this.bonus = bonus;
    }

    public double compensation() {
	return this.getSalary() + this.bonus;
    }

    // nobody said to make this attribute visible with an accessor, so no public accessor provide
    private double bonus;
}

class CEO extends Manager {
    // CEO "is a" Manager, so we need to initialize bonus, too:
    public CEO(String name, double bonus, double parachute) {
	super(name, bonus);
	this.goldenParachute = parachute;
    }

    public double compensation() {
	return super.compensation() + this.goldenParachute;
    }

    // nobody said to make this attribute visible with an accessor, so no public accessor provided
    private double goldenParachute;
}


public class EmployeeTest {
    public static void main(String[] args) {
	Manager mana = new Manager("Alice", 10000);
	mana.setSalary(80000);

	Engineer eng = new Engineer("Barbara", 100000);
	eng.setSalary(90000);

	CEO ceo = new CEO("Charlene", 20000, 1000000);
	ceo.setSalary(200000);

	System.out.println(mana.format());
	System.out.println(eng.format());
	System.out.println(ceo.format());
    }
}