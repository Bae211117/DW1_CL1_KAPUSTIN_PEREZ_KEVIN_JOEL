package pe.edu.cibertec.DSWI_CL1_GRUPO_3.repository;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.ws1.objects.Prestamo;

@Component
public class PrestamoRepository {

    public Prestamo obtenerPrestamo(double monto){
        Prestamo objprestamo = new Prestamo();
        objprestamo.setMonto(monto);
        if (monto>5000){
            objprestamo.setCuotas(3);
        }else if (monto<1000){
            objprestamo.setCuotas(1);
        }else if (monto>=2000&&monto<=3000){
            objprestamo.setCuotas(2);
        }
        else{
            objprestamo.setCuotas(5);
        }
        if(monto<4000){
            objprestamo.setInteres(0.12);
        } else {
            objprestamo.setInteres(0.10);
        }
        objprestamo.setDeudaTotal(monto+(monto*objprestamo.getInteres()));
        objprestamo.setMontoCuota(objprestamo.getDeudaTotal()/objprestamo.getCuotas());

        return objprestamo;
    }

}