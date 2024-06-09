package pe.edu.cibertec.DSWI_CL1_GRUPO_3.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository.NumeroRepository;
import pe.edu.cibertec.ws2.objects.NumeroRequest;
import pe.edu.cibertec.ws2.objects.NumeroResponse;

@Endpoint
@AllArgsConstructor
public class NumeroEndPoint {

    private static final String NAMESPACE_URI="http://www.cibertec.edu.pe/ws2/objects";
    private final NumeroRepository numeroRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NumeroRequest")
    @ResponsePayload
    public NumeroResponse convertirNumeroAVocal(@RequestPayload NumeroRequest request) {
        NumeroResponse response = new NumeroResponse();
        String vocal = numeroRepository.obtenerVocal(request.getNumero());
        response.setVocal(vocal);
        return response;
    }

}
