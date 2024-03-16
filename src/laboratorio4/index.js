function calcularValorVenta() {
    var valorCompra = parseFloat(document.getElementById("valor_compra").value);
    var utilidad = parseFloat(document.querySelector('input[name="utilidad"]:checked').value);
    var iva = parseFloat(document.querySelector('input[name="iva"]:checked').value);

    var valorVenta = valorCompra + valorCompra * (utilidad + iva);

    alert("El valor de venta es: " + valorVenta.toFixed(2));
}