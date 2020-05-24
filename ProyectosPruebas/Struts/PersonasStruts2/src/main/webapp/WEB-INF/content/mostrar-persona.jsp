<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="titulo" /></title>
    </head>
    <body>
        <h1><s:property value="titulo" /></h1>
        <div>
            <s:form>
                <s:textfield key="form.usuario" name="usuario" />
                <s:textfield key="form.password" name="password" />
                <br/>
                <s:submit key="form.boton" name="submit" />
            </s:form>
        </div>
        <br/>
        <div>
            <s:text name="Usuario" />: <s:property value="usuario" />
            <br/>
            <s:text name="Password" />: <s:property value="password" />
        </div>
    </body>
</html>
