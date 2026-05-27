<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dao.AppointmentDAO" %>
<%@ page import="model.Appointment" %>

<%
AppointmentDAO dao = new AppointmentDAO();

List<Appointment> list = dao.getAppointments();

String message = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Queue Management</title>

<style>

body{
    margin:0;
    font-family:Arial;
    background:linear-gradient(to right,#a8e063,#56ab2f);
    display:flex;
}

.main{
    width:70%;
}

.side{
    width:30%;
    background:white;
    height:100vh;
    overflow:auto;
    padding:20px;
    box-sizing:border-box;
}

.card{
    width:420px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 10px 20px rgba(0,0,0,0.2);
}

.card h2{
    text-align:center;
}

input,select{
    width:100%;
    padding:10px;
    margin:8px 0;
    border-radius:5px;
    border:1px solid #ccc;
    box-sizing:border-box;
}

button{
    width:100%;
    padding:10px;
    border:none;
    border-radius:5px;
    margin-top:10px;
    cursor:pointer;
    font-size:15px;
}

.book{
    background:green;
    color:white;
}

.next{
    background:blue;
    color:white;
}

.queue-box{
    background:#f4f4f4;
    padding:12px;
    margin-bottom:10px;
    border-left:5px solid green;
    border-radius:8px;
}

.success{
    color:green;
    font-weight:bold;
    text-align:center;
}

</style>
</head>

<body>

<div class="main">

<div class="card">

<h2>🌿 Ayurvedic Hospital</h2>

<% if(message != null){ %>

<div class="success">
<%= message %>
</div>

<% } %>

<form action="BookAppointmentServlet" method="post">

<input type="text"
       name="name"
       placeholder="Enter Name"
       pattern="[A-Za-z ]+"
       title="Name should contain only alphabets"
       required>

<input type="tel"
       name="phone"
       placeholder="Enter 10 Digit Phone Number"
       pattern="[0-9]{10}"
       maxlength="10"
       title="Phone number must contain exactly 10 digits"
       required>

<select id="dept" name="department" required onchange="setDoctor()">

<option value="">Select Department</option>

<option>Kayachikitsa (General Medicine)</option>
<option>Panchakarma Therapy</option>
<option>Twak Roga (Skin Care)</option>
<option>Grahani (Digestive)</option>
<option>Shalakya (ENT & Eye)</option>
<option>Kaumarbhritya (Child Care)</option>
<option>Prasuti (Women Health)</option>
<option>Vedana (Pain Relief)</option>
<option>Yoga (Wellness)</option>

</select>

<select id="doctor" name="doctor" required>

<option value="">Select Doctor</option>

</select>

<button class="book" type="submit">
Book Appointment
</button>

</form>

<form action="CallNextServlet" method="post">

<button class="next" type="submit">
Call Next
</button>

</form>

</div>

</div>

<div class="side">

<h3>👨‍⚕️ Queue List</h3>

<%
for(Appointment a : list){
%>

<div class="queue-box">

<b>Token <%= a.getToken() %></b><br>

Patient: <%= a.getName() %><br>

Phone: <%= a.getPhone() %><br>

Department: <%= a.getDepartment() %><br>

Doctor: <%= a.getDoctor() %>

</div>

<%
}
%>

<h4>Total Patients: <%= list.size() %></h4>

</div>

<script>

function setDoctor(){

    let dept = document.getElementById("dept").value;

    let doctor = document.getElementById("doctor");

    doctor.innerHTML = "";

    if(dept.includes("Kayachikitsa"))
        doctor.innerHTML = "<option>Dr. Sharma</option>";

    else if(dept.includes("Panchakarma"))
        doctor.innerHTML = "<option>Dr. Nair</option>";

    else if(dept.includes("Twak"))
        doctor.innerHTML = "<option>Dr. Patel</option>";

    else if(dept.includes("Grahani"))
        doctor.innerHTML = "<option>Dr. Mehta</option>";

    else if(dept.includes("Prasuti"))
        doctor.innerHTML = "<option>Dr. Joshi</option>";

    else if(dept.includes("Kaumarbhritya"))
        doctor.innerHTML = "<option>Dr. Kulkarni</option>";

    else if(dept.includes("Shalakya"))
        doctor.innerHTML = "<option>Dr. Iyer</option>";

    else if(dept.includes("Vedana"))
        doctor.innerHTML = "<option>Dr. Deshmukh</option>";

    else if(dept.includes("Yoga"))
        doctor.innerHTML = "<option>Dr. Verma</option>";
}

</script>

</body>
</html>