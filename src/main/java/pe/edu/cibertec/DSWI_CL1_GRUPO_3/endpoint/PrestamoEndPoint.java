package pe.edu.cibertec.DSWI_CL1_GRUPO_3.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository.PrestamoRepository;
import pe.edu.cibertec.ws1.objects.Prestamo;
import pe.edu.cibertec.ws1.objects.PrestamoRequest;
import pe.edu.cibertec.ws1.objects.PrestamoResponse;

@Endpoint
@AllArgsConstructor
public class PrestamoEndPoint {

    private static final String NAMESPACE_URI="http://www.cibertec.edu.pe/ws1/objects";
    private PrestamoRepository prestamoRepository;

    @PayloadRoot(namespace =NAMESPACE_URI, localPart="PrestamoRequest")
    @ResponsePayload
    public PrestamoResponse getPrestamo(@RequestPayload PrestamoRequest request) {
        double monto = request.getMonto();
        Prestamo prestamo = prestamoRepository.obtenerPrestamo(monto);
        PrestamoResponse response = new PrestamoResponse();
        response.setCuotas(prestamo.getCuotas());
        response.setMontoCuota(prestamo.getMontoCuota());
        response.setInteres(prestamo.getInteres());
        response.setDeudaTotal(prestamo.getDeudaTotal());
        return response;
    }


}
