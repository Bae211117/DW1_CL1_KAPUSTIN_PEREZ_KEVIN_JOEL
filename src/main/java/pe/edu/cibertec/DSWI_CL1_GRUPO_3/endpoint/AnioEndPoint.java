package pe.edu.cibertec.DSWI_CL1_GRUPO_3.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository.AnioRepository;
import pe.edu.cibertec.ws5.objects.AnioRequest;
import pe.edu.cibertec.ws5.objects.AnioResponse;

@Endpoint
@AllArgsConstructor
public class AnioEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws5/objects";
    private final AnioRepository anioRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AnioRequest")
    @ResponsePayload
    public AnioResponse anioResponse(@RequestPayload AnioRequest request) {
        int anio = request.getAnio();
        String mensaje = anioRepository.validarAnioBisiesto(anio);

        AnioResponse response = new AnioResponse();
        response.setBisiesto(mensaje);

        return response;
    }

}
