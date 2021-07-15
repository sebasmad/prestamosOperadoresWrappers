package com.clientes;

import com.clases.BeneficiosCovid19;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.utils.constants.*;
import static com.utils.messages.*;

public class Main {

    private static List<BeneficiosCovid19> lista1;
    private static List<BeneficiosCovid19> lista2;

    public static void main(String[] args) {
        Float mejorBeneficiLista1;
        Float mejorBeneficiLista2;
        lista1 = new ArrayList<>();
        BeneficiosCovid19 beneficios1 = new BeneficiosCovid19();
        beneficios1.setNombre(SIN_EMPLEO);
        beneficios1.setValorSubsidio(CIENTO_CINCUENTA_MIL);
        beneficios1.setId(getIdBeneficio());
        lista1.add(beneficios1);

        beneficios1 = new BeneficiosCovid19();
        beneficios1.setNombre(TRABAJADORES_SALUD_CON_COVID);
        beneficios1.setValorSubsidio(TRECIENTOS_VEINTICINCO_MIL);
        beneficios1.setId(getIdBeneficio());
        lista1.add(beneficios1);

        beneficios1 = new BeneficiosCovid19();
        beneficios1.setNombre(POBLACION_CON_COMORVILIDADES);
        beneficios1.setValorSubsidio(CIENTO_VEINTICINCO_MIL);
        beneficios1.setId(getIdBeneficio());
        lista1.add(beneficios1);
        mejorBeneficiLista1 = beneficios1.getMejorbeneficios(lista1);

        lista2 = new ArrayList<>();
        BeneficiosCovid19 beneficios2 = new BeneficiosCovid19();
        beneficios2.setNombre(TERCERA_EDAD_DAMNIFICADOS);
        beneficios2.setValorSubsidio(DOCIENTOS_MIL);
        beneficios2.setId(getIdBeneficio());
        lista2.add(beneficios2);

        beneficios2 = new BeneficiosCovid19();
        beneficios2.setNombre(TRABAJADORES_SALUD_ATIENDEN_COVID);
        beneficios2.setValorSubsidio(DOCIENTOS_TREINTA_MIL);
        beneficios2.setId(getIdBeneficio());
        lista2.add(beneficios2);
        mejorBeneficiLista2 = beneficios2.getMejorbeneficios(lista2);

        getMejorbeneficios(mejorBeneficiLista1, mejorBeneficiLista2);
    }

    public static void getMejorbeneficios(Float mejorBeneficiLista1, Float mejorBeneficiLista2){
        Float mejorBeneficio = ((mejorBeneficiLista1 >= mejorBeneficiLista2) ? mejorBeneficiLista1 : mejorBeneficiLista2);
        int idBeneficio = (getIdMejorbeneficio(lista1 ,mejorBeneficio) != CERO) ? getIdMejorbeneficio(lista1 ,mejorBeneficio) : getIdMejorbeneficio(lista2 ,mejorBeneficio);
        System.out.println("El mejor beneficio es el que tiene el id: " + idBeneficio + " por un valor de: " + mejorBeneficio);
    }

    public static int getIdMejorbeneficio(List<BeneficiosCovid19> lista, Float mejorBeneficio){
        for (BeneficiosCovid19 beneficiosCovid19 : lista) {
            if (beneficiosCovid19.getValorSubsidio().equals(mejorBeneficio)) {
                return Integer.parseInt(beneficiosCovid19.getId());
            }
        }
        return CERO;
    }

    private static String getIdBeneficio(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(UNO, RANGO_MAXIMO + UNO));
    }
}
