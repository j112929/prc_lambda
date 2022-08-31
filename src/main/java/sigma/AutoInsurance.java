package sigma;

class AutoInsurance extends Insurance {
    public static void main(String[] args) {
        Insurance i = new AutoInsurance();
        i.getQuote();
        i.addMemberToPolicy();
        ((AutoInsurance) i).reportAccident();

    }

    public String reportAccident() {
        System.out.println("Report accident to Policy");
        return "AutoInsurance.reportAccident";
    }

    public String addMemberToPolicy() {
        System.out.println("Adding auto member to Policy");
        return "AutoInsurance.addMemberToPolicy";
    }

    public Employee getEmployeeById(long i) throws EmployeeNotFoundException {

        boolean employeeFound = readFromDB(i); // false if emp notfound
        if (!employeeFound) {
            // throw a EmployeeNotFoundException
            throw new EmployeeNotFoundException("emp not found!");
        }
        return new Employee();
    }

    private boolean readFromDB(long i) {
        return false;
    }

}
