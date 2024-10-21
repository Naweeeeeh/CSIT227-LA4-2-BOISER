package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Manager manage = null;
        Employee emp = null;
        for (Person p : persons) {
            if (Objects.equals(p.getName(), manager)) {
                if (!(p instanceof Manager)) {
                    throw new ClassCastException(p.getName() + " is not a manager");
                }
                manage = (Manager) p;
            }

            if (Objects.equals(p.getName(), employee)) {
                if (!(p instanceof Employee)) {
                    throw new ClassCastException(p.getName() + " is not an employee");
                }
                emp = (Employee) p;
            }

            if (manage != null && emp != null) {
                break;
            }
        }

        if (manage == null || emp == null) {
            throw new NoSuchElementException((manage == null ? manager : employee) + " does not exist");
        }

        manage.giveRaise(emp, salary);


    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer dev = null;
        Manager managerr = null;

        for (Person p : persons) {
            if (Objects.equals(p.getName(), developer)) {
                if (!(p instanceof Developer)) {
                    throw new ClassCastException(p.getName() + " is not a developer");
                }
                dev = (Developer) p;
            }

            if (Objects.equals(p.getName(), manager)) {
                if (!(p instanceof Manager)) {
                    throw new ClassCastException(p.getName() + " is not a manager");
                }
                managerr = (Manager) p;
            }
            if (dev != null && managerr != null) {
                break;
            }
        }

        if (dev == null || managerr == null) {
            throw new NoSuchElementException((managerr == null ? manager : dev) + " does not exist");
        }

        dev.setProjectManager(managerr);

    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer customerr = null;
        Employee emp = null;
        // Find the manager
        for (Person p : persons) {
            if (Objects.equals(p.getName(), customer)) {
                if (!(p instanceof Customer)) {
                    throw new ClassCastException(p.getName() + " is not a customer");
                }
                customerr = (Customer) p;
            }

            if (Objects.equals(p.getName(), employee)) {
                if (!(p instanceof Employee)) {
                    throw new ClassCastException(p.getName() + " is not an employee");
                }
                emp = (Employee) p;
            }
            if (customerr != null && emp != null) {
                break;
            }
        }

        if (emp == null || customerr == null) {
            throw new NoSuchElementException((emp == null ? employee : customer) + " does not exist");
        }

        return customerr.speak(emp);
    }
}