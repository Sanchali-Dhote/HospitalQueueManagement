package servlet;

import java.io.IOException;
import java.util.List;

import dao.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Appointment;

@WebServlet("/BookAppointmentServlet")
public class BookAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String doctor = request.getParameter("doctor");

        AppointmentDAO dao = new AppointmentDAO();

        List<Appointment> list = dao.getAppointments();

        int token = list.size() + 1;

        Appointment a = new Appointment(
                token,
                name,
                phone,
                department,
                doctor,
                "Waiting"
        );

        dao.bookAppointment(a);

        response.sendRedirect("index.jsp");
    }
}