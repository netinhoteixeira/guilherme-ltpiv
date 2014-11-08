<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de Usuário</title>
    </head>
    <body>
        <div align="center">
            <form method="POST" action="UsuarioAlterarServlet">
                <h1>Alteração de Usuário</h1><br/>
                Login <input type="text" name="login"/><br/>
                Senha <input type="password" name="senha"/><br/>
                E-mail <input type="text" name="email"/><br/>

                <br/>

                <input type="submit">
                <input type="reset">


                <br />

                <a href="UsuarioListar.jsp">Listar Usuários</a>
            </form>
        </div>
    </body>
</html>