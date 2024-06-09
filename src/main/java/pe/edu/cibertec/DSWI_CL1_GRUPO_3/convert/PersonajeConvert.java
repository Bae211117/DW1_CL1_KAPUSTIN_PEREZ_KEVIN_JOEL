package pe.edu.cibertec.DSWI_CL1_GRUPO_3.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWI_CL1_GRUPO_3.model.Personaje;
import pe.edu.cibertec.ws.objects.Personajews;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeConvert {

    public Personaje convertPersonajewsToPersonaje(Personajews personajews){
        Personaje personaje = new Personaje();
        personaje.setIdpersonaje(personajews.getIdpersonaje());
        personaje.setNompersonaje(personajews.getNompersonaje());
        personaje.setApepersonaje(personajews.getApepersonaje());
        personaje.setFecnacpersonaje(personajews.getFecnacpersonaje());
        return personaje;

    }

    public List<Personaje> convertPersonajewsToPersonaje(List<Personajews> personajews){
        List<Personaje> personajeList = new ArrayList<>();
        personajews.forEach(dom ->{
            personajeList.add(convertPersonajewsToPersonaje(dom));
        });
        return personajeList;
    }
    public Personajews convertPersonajeToPersonajeWs(Personaje personaje){
        Personajews personajews = new Personajews();
        personajews.setIdpersonaje(personaje.getIdpersonaje());
        personajews.setNompersonaje(personaje.getNompersonaje());
        personajews.setApepersonaje(personaje.getApepersonaje());
        personajews.setFecnacpersonaje(personaje.getFecnacpersonaje());
        return personajews;
    }
    public List<Personajews> convertPersonajeToPersonajeWs(List<Personaje> personaje){
        List<Personajews> personajeList = new ArrayList<>();
        personaje.forEach(dom ->{
            personajeList.add(convertPersonajeToPersonajeWs(dom));
        });
        return personajeList;
    }

}