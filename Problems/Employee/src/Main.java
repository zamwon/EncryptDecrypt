class Employee {

    String name;
    int salary;
    String address;

    public Employee() {
        this.address = "unknown";
        this.name = "unknown";
        this.salary = 0;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.address = "unknown";
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}