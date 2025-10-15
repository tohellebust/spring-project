<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value='/css/simple.css' />" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>

<%-- Viser generelle feilmeldinger sendt via RedirectAttributes (f.eks. "mobil er opptatt") --%>
<c:if test="${not empty errormessage}">
    <p style="color:red;">${errormessage}</p>
</c:if>

<%-- Viser valideringsfeil fra BindingResult --%>
<form:errors path="deltager.*" cssStyle="color:red;" />

<form action="paamelding" method="post">
    <fieldset>
        <label for="fornavn">Fornavn</label>
        <input type="text" id="fornavn" name="fornavn" required>

        <label for="etternavn">Etternavn</label>
        <input type="text" id="etternavn" name="etternavn" required>

        <label for="mobil">Mobil (8 siffer)</label>
        <input type="text" id="mobil" name="mobil" required>

        <label for="passord">Passord</label>
        <input type="password" id="passord" name="passord" required>

        <label for="passordRepetert">Passord repetert</label>
        <input type="password" id="passordRepetert" name="passordRepetert" required>

        <p>Kjønn</p>
        <label>
            <input type="radio" name="kjonn" value="mann" required> Mann
        </label>
        <label>
            <input type="radio" name="kjonn" value="kvinne" required> Kvinne
        </label>
    </fieldset>

    <button type="submit">Meld meg på</button>
</form>

</body>
</html>