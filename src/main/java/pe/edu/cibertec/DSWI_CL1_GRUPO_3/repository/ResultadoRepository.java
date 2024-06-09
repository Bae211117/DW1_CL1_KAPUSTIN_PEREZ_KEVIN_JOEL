package pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.ws3.objects.Resultado;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultadoRepository {

    public List<Resultado> calcularCuboYCuarta(int limite) {
        List<Resultado> resultados = new ArrayList<>();
        for (int i = 1; i <= limite; i++) {
            Resultado resultado = new Resultado();
            resultado.setNumero(i);
            resultado.setCubo(Math.pow(i, 3));
            resultado.setCuarta(Math.pow(i, 4));
            resultados.add(resultado);
        }
        return resultados;
    }

}
