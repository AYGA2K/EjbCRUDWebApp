<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>
    <h1>Update Student</h1>

    <form action="updateetudiant" method="post">
        <input type="hidden" name="id" value="${etudiant.id_etudiant}">
        <label for="nom">First Name:</label>
        <input type="text" name="nom" value="${etudiant.nom}"><br>

        <label for="prenom">Last Name:</label>
        <input type="text" name="prenom" value="${etudiant.prenom}"><br>

        <label for="cne">CNE:</label>
        <input type="text" name="cne" value="${etudiant.cne}"><br>

        <label for="adresse">Address:</label>
        <input type="text" name="adresse" value="${etudiant.adresse}"><br>

        <label for="niveau">Level:</label>
        <input type="text" name="niveau" value="${etudiant.niveau}"><br>

        <input type="submit" value="Update Student">
    </form>
</body>
</html>

