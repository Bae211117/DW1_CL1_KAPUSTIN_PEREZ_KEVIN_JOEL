package pe.edu.cibertec.DSWI_CL1_GRUPO_3.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository.CompraRepository;
import pe.edu.cibertec.ws4.objects.Compra;
import pe.edu.cibertec.ws4.objects.CompraRequest;
import pe.edu.cibertec.ws4.objects.CompraResponse;

@Endpoint
@AllArgsConstructor
public class CompraEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws4/objects";
    private final CompraRepository compraRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CompraRequest")
    @ResponsePayload
    public CompraResponse calcularTotal(@RequestPayload CompraRequest request) {
        double precioUnitario = request.getPrecioUnitario();
        int cantidad = request.getCantidad();

        Compra detalleCompra = compraRepository.calcularTotal(precioUnitario, cantidad);

        CompraResponse response = new CompraResponse();
        response.setDetalleCompra(detalleCompra);

        return response;
    }

}
