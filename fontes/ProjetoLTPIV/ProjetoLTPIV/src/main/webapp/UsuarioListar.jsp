<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="br.com.reclame.dao.UsuarioDAO,br.com.reclame.vo.UsuarioVO,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
    </head>
    <body>

        <h1>Listagem dos Usuários</h1>
        <a href="UsuarioInserir.jsp">Adicionar</a>

        <%
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<UsuarioVO> usuarios = usuarioDAO.consulta();
        %>

        <table border="1">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Login</td>
                    <td>E-mail</td>
                    <td>Ações</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < usuarios.size(); i++) {
                        UsuarioVO usuario = usuarios.get(i);
                %>
                <tr>
                    <td><%=usuario.getIdUsuario()%></td>
                    <td><%=usuario.getLogin()%></td>
                    <td><%=usuario.getEmail()%></td>
                    <td>
                        <ul>
                            <li><a href="UsuarioAlterar.jsp?idUsuario=<%=usuario.getIdUsuario()%>">Alterar</a></li>
                            <li><a href="UsuarioRemoverServlet?idUsuario=<%=usuario.getIdUsuario()%>" onclick="return confirm('Deseja remover o usuário?')">Remover</a></li>
                        </ul>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </body>
</html>