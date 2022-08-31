package sigma;

class Insurance {
    public String getQuote() {
        System.out.println("parent Quote");
        return "Insurance.getQuote";
    }

    public String addMemberToPolicy() {
        System.out.println("Adding member to Policy");
        return "Insurance.addMemberToPolicy";
    }
}
