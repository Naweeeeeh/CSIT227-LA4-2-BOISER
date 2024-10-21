package Management_Exc;

public class Manager extends Employee {
    public Manager(String name,         int age, double salary) {
        super(name, age, salary);
    }

    /**
     * TODO this implementation
     * @param e the employee to be given raise
     * @param raise the raise
     * @throws IllegalArgumentException when raise is negative
     */
    public void giveRaise(Employee e, double raise) throws IllegalArgumentException {

        if (raise < 0) {
            throw new IllegalArgumentException("Raise must be non-negative");
        }

        System.out.println("Before raise: " + e.getSalary());  // Debug print
        System.out.println("Raise: " + raise);

        if (e instanceof Manager) {
            e.setSalary(raise + e.getSalary());
        } else {
            e.setSalary(raise + e.getSalary());
            this.setSalary(raise / 2 + this.getSalary());
        }

    }
    @Override
    public String toString() {
        return "Mgr. " +super.toString();
    }
}