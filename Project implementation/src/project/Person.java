package project;

public class Person {

    private String name;
    private int phone;
    private String imageName;
    private String Email;
    private String Sex;

    public Person(String name, int phone, String imageName, String Email, String Sex) {
        this.name = name;
        this.phone = phone;
        this.imageName = imageName;
        this.Email = Email;
        this.Sex = Sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return (Email);
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getSex() {
        return Sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean login(String userName, String password) {
        return false;
    }

}
