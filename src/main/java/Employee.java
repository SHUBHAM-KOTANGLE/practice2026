public record Employee(
        int id,
        String name,
        String department,
        double salary,
        int age,String city,
        int joiningYear,
        boolean active) {

    @Override
    public String name() {
        return name;
    }
}