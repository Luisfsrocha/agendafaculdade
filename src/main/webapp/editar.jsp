<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/agenda.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="">
		<table>
			<tr>
				<td><input type="text" name="idcon" id="caixa3" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="Caixa2"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1"></td>
			</tr>
		</table>

		<input type="button" value="Salvar" class="Botao1" onclick="validar()">

	</form>

	<script src="scripts/validador.js"></script>

</body>
</html>