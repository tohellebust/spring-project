<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table>
    <c:forEach var="deltager" items="${deltagere}">
        <tr>
            <td align="center">
                    <%-- Viser mann/kvinne-symbol basert på kjønn --%>
                <c:if test="${deltager.kjonn == 'kvinne'}">&#9792;</c:if>
                <c:if test="${deltager.kjonn == 'mann'}">&#9794;</c:if>
            </td>
            <td>${deltager.fornavn} ${deltager.etternavn}</td>
            <td>${deltager.mobil}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>