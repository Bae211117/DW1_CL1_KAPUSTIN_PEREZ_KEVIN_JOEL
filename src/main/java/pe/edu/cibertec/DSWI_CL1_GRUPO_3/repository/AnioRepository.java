package pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository;
import org.springframework.stereotype.Component;

@Component
public class AnioRepository {
    public String validarAnioBisiesto(int anio) {
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            return "El año elegido es bisiesto";
        } else {
            return "El año elegido no es bisiesto";
        }
    }
}