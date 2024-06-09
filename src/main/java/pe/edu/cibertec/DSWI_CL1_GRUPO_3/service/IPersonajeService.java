package pe.edu.cibertec.DSWI_CL1_GRUPO_3.service;

import pe.edu.cibertec.ws.objects.Personajews;

import java.util.List;

public interface IPersonajeService {

    List<Personajews> listarPersonajes();
    Personajews obtenerPersonajexId(int id);
    Personajews registrarActualizarPersonaje(Personajews personaje);

}


