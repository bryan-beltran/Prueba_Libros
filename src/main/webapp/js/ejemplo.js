$(document).ready(function() {//Trabajando Jquery

	alert("Hola Mundo")

	$('.sumar').on('click',function() {
		sumar()
	})
	
	function sumar(){	
		var num1 = parseInt(document.getElementById("n1").value)
		var num1 = parseInt(document.getElementById("n2").value)
		var suma = num1 + num2

		alert("La suma es: " +suma)
		console.log("La suma es: " +suma)
		var res = document.getElementById("resultado")
		res.innerHTML = "La suma es: " +suma
	}
	
})