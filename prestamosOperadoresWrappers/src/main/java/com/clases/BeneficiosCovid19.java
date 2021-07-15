package com.clases;

import java.util.List;

import static com.utils.constants.CERO;
import static com.utils.constants.UNO;

public class BeneficiosCovid19 {
    private String id;
    private String nombre;
    private float valorSubsidio;

    public void setId(String id) {
        this.id = String.valueOf(id);
    }

    public void setNombre(String nombre) {
        this.nombre = new String(nombre);
    }

    public void setValorSubsidio(String valorSubsidio) {
        this.valorSubsidio = Float.parseFloat(valorSubsidio);
    }

    public String getId() {
        return new String(id);
    }

    public String getNombre() {
        return new String(nombre);
    }

    public Float getValorSubsidio() {
        return Float.valueOf(valorSubsidio);
    }

    public Float getMejorbeneficios(List<BeneficiosCovid19> lista){
        float mejorBeneficio = CERO;
        for(int i = CERO; i < lista.size() - UNO; i++) {
            mejorBeneficio = (lista.get(i).getValorSubsidio() >= lista.get(i + UNO).getValorSubsidio()) ? lista.get(i).getValorSubsidio() : lista.get(i + UNO).getValorSubsidio();
        }
        return Float.valueOf(mejorBeneficio);
    }
}
