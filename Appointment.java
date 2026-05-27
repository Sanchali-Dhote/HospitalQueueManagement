package model;

public class Appointment {

    private int id;
    private int token;
    private String name;
    private String phone;
    private String department;
    private String doctor;
    private String status;

    public Appointment() {
    }

    public Appointment(int token, String name, String phone,
                       String department, String doctor, String status) {

        this.token = token;
        this.name = name;
        this.phone = phone;
        this.department = department;
        this.doctor = doctor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}