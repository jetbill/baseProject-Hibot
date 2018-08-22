package co.com.cliente.proyecto.test.api;

import co.com.sofka.test.jmeter.ExecutionJmeter;

public class TestApiConnection extends ExecutionJmeter{

    static final String NOMBRE_SCRIPT="ScriptPrueba";

    public void metodoPrueba()throws Exception{

        String[] aux=execJmeter(NOMBRE_SCRIPT,null,"www.google.com.co",";");

        for (int i = 0; i < aux.length; i++) {
            System.out.println(aux[i]);
        }
    }

    public static void main(String[] args) {
        TestApiConnection api = new TestApiConnection();
        try {
            api.metodoPrueba();
        }catch (Exception e){
            System.out.println("Falloooooo");
        }

    }
}
