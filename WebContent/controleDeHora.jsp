<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Controle de Horário</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<form method="POST" action="HoraDeTrabalhoServlet">
		<input type="hidden" name="action" value="add"> <input
			type="hidden" name="delete_all" value="true">
		<h2 class="semMargem">Registro de ponto</h2>
		<div>
			<label> CPF: <input type="text" name="cpf"
				value="${not empty param.cpf ? param.cpf : ''}" required></label>
		</div>
		<h2 class="comMargem">Horário de Trabalho</h2>
		Entrada: <input type="text" name="entrada" pattern="^([0-1][0-9]|2[0-3]):[0-5][0-9]$" placeholder="HH:MM" maxlength="5"> 
		Saída: <input type="text" name="saida" pattern="^([0-1][0-9]|2[0-3]):[0-5][0-9]$" placeholder="HH:MM" maxlength="5">
		<div>
			<br> <input type="submit" value="Cadastrar"> <input
				type="button" value="Excluir todos"
				onclick="if(confirm('Tem certeza que deseja excluir todos?')) { document.forms[0].action='HoraDeTrabalhoServlet?action=delete_all'; document.forms[0].submit(); }">
		</div>
	</form>

	<div class="clear"></div>

	<!-- Lista os horários de trabalho cadastrados -->
	<table class="horarios">
		<thead>
			<tr>
				<th>Entrada</th>
				<th>Saída</th>
				<th>Opções</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="horario" items="${horarios}">
				<tr>
					<td>${horario.entrada}</td>
					<td>${horario.saida}</td>
					<td
						style="display: flex; justify-content: space-between; align-items: center; width: 120px;">
						<button class="editar" onclick="editarHorario(${horario.id})">Editar</button>						
						<button class="excluir" onclick="excluirHorario(${horario.id})">Excluir</button>
					</td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>
	
	<div class="clear"></div>	
	<h2 class="comMargem">Marcações Feitas</h2>
	<form method="POST" action="MarcacoesFeitasServlet">
		<input type="hidden" name="action" value="add"> <label>
			<input type="hidden" name="cpf" id="cpf" value="">
		</label> Entrada: <input type="text" name="entrada" pattern="^([0-1][0-9]|2[0-3]):[0-5][0-9]$" placeholder="HH:MM" maxlength="5"> 				
				 Saída: <input type="text" name="saida" pattern="^([0-1][0-9]|2[0-3]):[0-5][0-9]$" placeholder="HH:MM" maxlength="5">
		<div>
			<br> <input type="submit" value="Cadastrar">
		</div>
	</form>
	<!-- Lista das marcações feitas -->
	<table class="horarios">
		<thead>
			<tr>
				<th>Entrada</th>				
				<th>Saída</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="marcacao" items="${marcacoes}">
				<tr>
					<td>${marcacao.entrada}</td>					
					<td>${marcacao.saida}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="clear"></div>
	<h2 class="comMargem">Atrasos</h2>	
	<!-- Lista dos atrasos -->
	<table class="horarios">
		<thead>
			<tr>
				<th>Período</th>
				<th>Horas</th>				
				<th></th>
			</tr>	
		</thead>
		<tbody>
<<<<<<< HEAD
			<c:forEach var="at" items="${atraso}">
=======
			<c:forEach var="ats" items="${at}">
>>>>>>> f7ebaaf26b0257b9afad7a1bf04762570dc04726
				<tr>
					<td>${at.periodoAtraso}</td>
					<td>${at.entrada}</td>
				</tr>
<<<<<<< HEAD
				 console.log(${at.id});				
			</c:forEach>
			
=======
				 <script>
    console.log(${at}); // aqui está o console.log() que você pode adicionar
  </script>
			</c:forEach>
>>>>>>> f7ebaaf26b0257b9afad7a1bf04762570dc04726
		</tbody>
	</table>
	<h2 class="comMargem">Hora Extra</h2>
	<!-- Lista das horas extras -->	

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
	<script>

<<<<<<< HEAD
    console.log(${at.id}); // aqui está o console.log() que você pode adicionar
=======
    console.log(${horario}); // aqui está o console.log() que você pode adicionar
>>>>>>> f7ebaaf26b0257b9afad7a1bf04762570dc04726
 
	function editarHorario(id) {
        // Redireciona para a página de edição passando o ID como parâmetro na URL
	 window.location.href = "HoraDeTrabalhoServlet?action=edit&id=" + id;
    }
	
	function excluirHorario(id) {
	     if (confirm('Tem certeza que deseja excluir este horário?')) {
	        var form = document.createElement('form');
	        form.method = 'POST';
	        form.action = 'HoraDeTrabalhoServlet';
	        form.innerHTML = '<input type="hidden" name="action" value="delete"><input type="hidden" name="id" value="' + id + '">';
	        document.body.appendChild(form);
	        form.submit();
	        
	        // Exibir mensagem de excluído com sucesso como pop-up
	        alert("Horário excluído com sucesso!");
	    }
	}	  
	
	// preenche o valor do campo "cpf" com o valor do CPF do usuário logado
	  var cpf = "01439869103"; // substitua por uma chamada à API de autenticação ou por um valor dinâmico
	  document.getElementById("cpf").value = cpf;
	  
  //para aplicar automaticamente a máscara ao campo de valor hora
  $(document).ready(function() {
  $('input[name="entrada"]').mask('00:00');
  $('input[name="intervaloInicio"]').mask('00:00');
  $('input[name="intervaloFim"]').mask('00:00');
  $('input[name="saida"]').mask('00:00');
});
</script>

</body>
</html>