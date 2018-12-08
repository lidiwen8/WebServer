package entity;

public class User {
    private String name;
    private String sessionname;
    private String password;
    private String mail;
    private String number;
    private String sex;
    private String description;

    public void setUser() {
    }

    public void User(String name, String password, String mail, String number, String sex, String description) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.mail = mail;
        this.number = number;
        this.description = description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getNumber() {
        return number;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSessionname() {
        return sessionname;
    }

    public void setSessionname(String sessionname) {
        this.sessionname = sessionname;
    }
}
