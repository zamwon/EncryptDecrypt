import java.util.Scanner;

/**
 * Product - Robot
 */
abstract class Robot {

    public abstract String getName();

    public abstract String getDescription();

    public abstract int getPower();

    @Override
    public String toString() {
        return "robot: {\n\t" +
                "name : " + getName() + "\n\t" +
                "description : " + getDescription() + "\n\t" +
                "power : " + getPower() + "\n}";
    }
}

/**
 * Robot types
 */
enum RobotType {
    ROBOT_CLEANER,
    ROBOT_GUARDIAN,
    /**  write your code here ... */
}

/**
 * Concrete Product - Robot Cleaner
 */
class RobotCleaner extends Robot {

    private String name;
    private String description;
    private int power;

    public RobotCleaner(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "cleaner-" + super.toString();
    }

}

/**
 * Concrete Product - Robot Guardian
 */
class RobotGuardian extends Robot {

    private String name;
    private String description;
    private int power;

    public RobotGuardian(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "guardian-" + super.toString();
    }
    /**  write your code here ... */
}

class RobotFactory {

    /**
     * Factory method
     */
    public Robot getRobot(RobotType type, String name, String description, int power) {
        /**  write your code here ... */
        if (type.equals(RobotType.ROBOT_CLEANER)) {
            return new RobotCleaner(name, description, power);
        } else if (type.equals(RobotType.ROBOT_GUARDIAN)) {
            return new RobotGuardian(name, description, power);
        } else {
            return null;
        }
    }
}

class RobotDemo {
    public static void main(String[] args) {

        RobotFactory robotFactory = new RobotFactory();
        Scanner scanner = new Scanner(System.in);

        String nameCleaner = scanner.nextLine();
        Robot robotCleaner = robotFactory.getRobot(RobotType.ROBOT_CLEANER, nameCleaner,
                "Robot will clean my room and dry my socks", 100);

        String nameGuardian = scanner.nextLine();
        Robot robotGuardian = robotFactory.getRobot(RobotType.ROBOT_GUARDIAN, nameGuardian,
                "Knight will secure my daughter while she sleeping", 200);

        System.out.println(robotCleaner);
        System.out.println(robotGuardian);

        scanner.close();
    }
}