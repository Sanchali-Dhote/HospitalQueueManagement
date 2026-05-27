package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;

public class AppointmentDAO {

    Connection con;

    // INSERT APPOINTMENT
    public boolean bookAppointment(Appointment a) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String sql = "insert into appointments(token,name,phone,department,doctor,status) values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getToken());
            ps.setString(2, a.getName());
            ps.setString(3, a.getPhone());
            ps.setString(4, a.getDepartment());
            ps.setString(5, a.getDoctor());
            ps.setString(6, a.getStatus());

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            System.out.println(e);
        }

        return status;
    }

    // GET ALL APPOINTMENTS
    public List<Appointment> getAppointments() {

        List<Appointment> list = new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            String sql = "select * from appointments order by token";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Appointment a = new Appointment();

                a.setId(rs.getInt("id"));
                a.setToken(rs.getInt("token"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setDepartment(rs.getString("department"));
                a.setDoctor(rs.getString("doctor"));
                a.setStatus(rs.getString("status"));

                list.add(a);
            }

        } catch(Exception e) {
            System.out.println(e);
        }

        return list;
    }

    // CALL NEXT PATIENT
    public void callNextPatient() {

        try {

            con = DBConnection.getConnection();

            String sql = "delete from appointments order by token limit 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}