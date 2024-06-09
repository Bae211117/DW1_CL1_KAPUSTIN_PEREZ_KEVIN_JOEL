package pe.edu.cibertec.DSWI_CL1_GRUPO_3.endpoint;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository.ResultadoRepository;
import pe.edu.cibertec.ws3.objects.CalculoRequest;
import pe.edu.cibertec.ws3.objects.CalculoResponse;
import pe.edu.cibertec.ws3.objects.Resultado;

import java.util.List;

@Endpoint
@AllArgsConstructor
public class ResultadoEndPoint {

    private static final String NAMESPACE_URI="http://www.alejandro-luyo.com/ws/objects";
    private final ResultadoRepository resultadoRepository;

    @PayloadRoot(namespace =NAMESPACE_URI, localPart = "CalculoRequest")
    @ResponsePayload
    public CalculoResponse calculoResponse(@RequestPayload CalculoRequest request) {
        int limite = request.getLimite();
        List<Resultado> resultados = resultadoRepository.calcularCuboYCuarta(limite);
        CalculoResponse response = new CalculoResponse();
        response.getResultados().addAll(resultados);
        return response;
    }


}
