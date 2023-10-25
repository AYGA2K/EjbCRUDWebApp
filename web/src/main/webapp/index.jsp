<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
</head>
<body>
    <h1>Students List</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>CNE</th>
                <th>Address</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${etudiants}">
                <tr>
                    <td>${student.id_etudiant}</td>
                    <td>${student.nom}</td>
                    <td>${student.prenom}</td>
                    <td>${student.cne}</td>
                    <td>${student.adresse}</td>
                    <td>${student.niveau}</td>
                    <td>
                        <a href="updateEtudiantServelet?id=${student.id_etudiant}">Update</a> 
                        <a href="DeleteEtudiantServelet?action=delete&id=${student.id_etudiant}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Add Student</h2>
    <form action="etudiant" method="post">
        <label for="nom">First Name:</label>
        <input type="text" name="nom" id="nom"><br>

        <label for="prenom">Last Name:</label>
        <input type="text" name="prenom" id="prenom"><br>

        <label for="cne">CNE:</label>
        <input type="text" name="cne" id="cne"><br>

        <label for="adresse">Address:</label>
        <input type="text" name="adresse" id="adresse"><br>

        <label for="niveau">Level:</label>
        <input type="text" name="niveau" id="niveau"><br>

        <input type="submit" value="Add Student">
    </form>
</body>
</html>

