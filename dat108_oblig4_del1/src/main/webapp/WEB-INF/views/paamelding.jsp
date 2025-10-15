<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value='/css/simple.css' />" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>

<%-- Display general error messages --%>
<c:if test="${not empty errormessage}">
    <p style="color:red;">${errormessage}</p>
</c:if>

<%-- Display validation errors from BindingResult --%>
<c:if test="${not empty errors}">
    <div style="color:red;">
        <c:forEach items="${errors}" var="error">
            <p>${error}</p>
        </c:forEach>
    </div>
</c:if>

<form action="paamelding" method="post">
    <fieldset>
        <label for="fornavn">Fornavn</label>
        <input type="text" id="fornavn" name="fornavn"
               value="${not empty deltager ? deltager.fornavn : param.fornavn}">

        <label for="etternavn">Etternavn</label>
        <input type="text" id="etternavn" name="etternavn"
               value="${not empty deltager ? deltager.etternavn : param.etternavn}">

        <label for="mobil">Mobil (8 siffer)</label>
        <input type="text" id="mobil" name="mobil"
               value="${not empty deltager ? deltager.mobil : param.mobil}">

        <label for="passord">Passord</label>
        <input type="password" id="passord" name="passord">

        <label for="passordRepetert">Passord repetert</label>
        <input type="password" id="passordRepetert" name="passordRepetert">

        <p>Kjønn</p>
        <label>
            <input type="radio" name="kjonn" value="mann"
            ${(not empty deltager and deltager.kjonn == 'mann') or param.kjonn == 'mann' ? 'checked' : ''}> Mann
        </label>
        <label>
            <input type="radio" name="kjonn" value="kvinne"
            ${(not empty deltager and deltager.kjonn == 'kvinne') or param.kjonn == 'kvinne' ? 'checked' : ''}> Kvinne
        </label>
    </fieldset>

    <button type="submit">Meld meg på</button>
</form>

</body>
</html>