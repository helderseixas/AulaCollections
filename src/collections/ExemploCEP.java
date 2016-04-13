package collections;

import java.util.HashMap;
import java.util.Map;

public class ExemploCEP {

    public static void main(String args[]){
        Map<String,String> cep = new HashMap<String, String>();
        
        cep.put("39.480-000", "Januária/MG");
        cep.put("30.310-000", "Belo Horizonte/MG");
        cep.put("30.310-001", "Belo Horizonte/MG");
        cep.put("39.400-000", "Montes Claros/MG");
        
        String cepPesquisa = "30.310-001";
        String cidadeEncontrada = cep.get(cepPesquisa);
        
        System.out.printf("Qual cidade possui o CEP %s? %s\n",
                cepPesquisa, cidadeEncontrada);
    }
    
}
