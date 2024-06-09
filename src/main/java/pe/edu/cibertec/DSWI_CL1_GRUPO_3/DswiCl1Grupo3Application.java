package pe.edu.cibertec.DSWI_CL1_GRUPO_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pe.edu.cibertec.DSWI_CL1_GRUPO_3"})
public class DswiCl1Grupo3Application {

	public static void main(String[] args) {
		SpringApplication.run(DswiCl1Grupo3Application.class, args);
	}

}
