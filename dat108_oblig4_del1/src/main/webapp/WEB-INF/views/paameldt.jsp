<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value='/css/simple.css' />" rel="stylesheet">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>

<%-- Sjekker at objektet finnes før vi prøver å vise det --%>
<c:if test="${not empty paameldtDeltager}">
    <p>Påmeldingen er mottatt for</p>
    <p>
        &nbsp;&nbsp;&nbsp;${paameldtDeltager.fornavn}<br />
        &nbsp;&nbsp;&nbsp;${paameldtDeltager.etternavn}<br />
        &nbsp;&nbsp;&nbsp;${paameldtDeltager.mobil}<br />
        &nbsp;&nbsp;&nbsp;${paameldtDeltager.kjonn}
    </p>
</c:if>

<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>