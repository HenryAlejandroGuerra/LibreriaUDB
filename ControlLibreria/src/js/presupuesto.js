$(document).ready(function () {

    $('.money').mask('000,000,000.00', {reverse: true});
    $("#n1").val("");
    $("#n2").val("");

    $("#tipo_moneda_1").val("dolar");
    $("#tipo_moneda_2").val("dolar");
    $("#span1").html("<b>$</b>");
    $("#span2").html("<b>$</b>");

    function quit(money){
    	var comas = money.split(",");
    	var respuesta;
    	respuesta = comas[0]+comas[1]+comas[2];
        respuesta = respuesta.split("undefined");

    	return respuesta[0];
    }

    function conversion(cant, tipo1, tipo2){
        var respuesta;

    	if(tipo1 == "euro"){
            if(tipo2 == "dolar"){
                respuesta = cant * 1.14;
            } else if(tipo2 == "yen"){
                respuesta = cant * 128.31;
            } else if(tipo2 == "pesoMex"){
                respuesta = cant * 21.66;
            } else {
                respuesta = cant;
            }
        } else if(tipo1 == "dolar"){
            if(tipo2 == "euro"){
                respuesta = cant * 0.88;
            } else if(tipo2 == "yen"){
                respuesta = cant * 112.73;
            } else if(tipo2 == "pesoMex"){
                respuesta = cant * 20.35;
            } else {
                respuesta = cant;
            }
        } else if(tipo1 == "pesoMex"){
            if(tipo2 == "euro"){
                respuesta = cant * 0.88;
            } else if(tipo2 == "yen"){
                respuesta = cant * 112.73;
            } else if(tipo2 == "dolar"){
                respuesta = cant * 0.049;
            } else {
                respuesta = cant;
            }
        } else {
            if(tipo2 == "euro"){
                respuesta = cant * 0.0078;
            } else if(tipo2 == "dolar"){
                respuesta = cant * 0.0089;
            } else if(tipo2 == "pesoMex"){
                respuesta = cant * 0.16;
            } else {
                respuesta = cant;
            }
        }

        return respuesta;
    }

    $("#n1").keyup(function(){
        var moneda1 = $("#tipo_moneda_1").val();
        var moneda2 = $("#tipo_moneda_2").val();
        var cant1 = $("#n1").val().trim();

        var sinComas = quit(cant1);
        var cant2 = conversion(sinComas, moneda1, moneda2);
        $("#n2").val(new Intl.NumberFormat().format(cant2));
    });

    $("#tipo_moneda_1").change(function(){
        var moneda1 = $("#tipo_moneda_1").val();
        var moneda2 = $("#tipo_moneda_2").val();
        var cant1 = $("#n1").val().trim();
        var cant2 = $("#n2").val().trim();

        if(moneda1 == "euro"){
            $("#span1").html("<b>€</b>");
        } else if(moneda1 == "dolar"){
            $("#span1").html("<b>$</b>");
        } else if(moneda1 == "pesoMex"){
            $("#span1").html("<b>$</b>");
        } else {
            $("#span1").html("<b>¥</b>");
        }

        var sinComas = quit(cant1);
        var cant2 = conversion(sinComas, moneda1, moneda2);
        $("#n2").val(new Intl.NumberFormat().format(cant2));
    });

    $("#tipo_moneda_2").change(function(){
        var moneda1 = $("#tipo_moneda_1").val();
        var moneda2 = $("#tipo_moneda_2").val();
        var cant1 = $("#n1").val().trim();
        var cant2 = $("#n2").val().trim();

        if(moneda2 == "euro"){
            $("#span2").html("<b>€</b>");
        } else if(moneda2 == "dolar"){
            $("#span2").html("<b>$</b>");
        } else if(moneda2 == "pesoMex"){
            $("#span2").html("<b>$</b>");
        } else {
            $("#span2").html("<b>¥</b>");
        }

        var sinComas = quit(cant1);
        var cant2 = conversion(sinComas, moneda1, moneda2);
        $("#n2").val(new Intl.NumberFormat().format(cant2));
    });

});