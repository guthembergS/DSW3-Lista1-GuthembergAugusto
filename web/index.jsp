<%-- 
    Document   : index
    Created on : 18/09/2019, 19:13:56
    Author     : guto
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="index.js"></script>
        <link rel="stylesheet" type="text/css" href="index.css" />
        <title>JSP Page</title>
    </head>
    <body>
        
        <table id="lista">
            <thead>
                <tr>
                    <th><img id="inserir" src="imgs/inserir.png" alt="Inserir Parlamentar" /></th>
                    
                    <th>Nome</th>
                    
                </tr>
            </thead>
            <tbody></tbody>
        </table>
         <form action="ServletCadastro" method="post" id="form">
            <input type="hidden" name="codigo" value="" />
            <fieldset id="formulario"><legend>Dados</legend>
                <table>
                    <tr>
                        <th>Nome:</th>
                        <td><input type="text" name="nome" /></td>
                    </tr>
                     <tr>
                        <td colspan="2"><input type="submit" value="Inserir" name="submeter" /></td>
                    </tr>
                </table>
            </fieldset>
         </form>
        
    </body>
</html>
