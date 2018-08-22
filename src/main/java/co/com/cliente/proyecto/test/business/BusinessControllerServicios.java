package co.com.cliente.proyecto.test.business;


import co.com.sofka.test.files.ManagementPropertiesFiles;
import co.com.sofka.test.jmeter.ExecutionJmeter;

public class BusinessControllerServicios {
    public String consumirServiciosTRM() throws Exception{
        String[] respuestaServicio;
        ManagementPropertiesFiles managementPropertiesFiles = new ManagementPropertiesFiles();
        ExecutionJmeter executionJmeter = new ExecutionJmeter();
        String data = managementPropertiesFiles.getFieldProperties("endPointConsultaTRM");
        respuestaServicio=executionJmeter.execJmeter("WSCAMBIODOLARES","",data,",");
        return  respuestaServicio[0];
    }
    public static void main (String[] arqs) throws Exception{
        BusinessControllerServicios businessControllerServicios = new BusinessControllerServicios();
        System.out.println(businessControllerServicios.consumirServiciosTRM());
    }
}
