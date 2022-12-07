package resources.models.players;

public class Person extends Player {

    private String name;

    private int age;

    private String country;

    public Person(String name, int age, String country) {
        super();
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
