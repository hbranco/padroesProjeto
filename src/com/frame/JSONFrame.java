package com.frame;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;

public class JSONFrame {
    String nomeMetodo;
    String inicioJSON = "{\n";
    String finalJSON = "\n}";
    String meioJSON ="";
    String JSONFormatado;
    /**
     * metodo para converte um objeto em JSON se tiver notação
     * @param o
     * @return
     */
    public String getJSON (Object o ) throws InvocationTargetException, IllegalAccessException {
        Method[] metodo = o.getClass().getDeclaredMethods();
        int tamanhoVetor = metodo.length;
        for(int i = 0 ; i < tamanhoVetor; ++i){
            Method m = metodo[i];
            if(m.getName().startsWith("get") && m.isAnnotationPresent(JSON.class)){
                nomeMetodo = m.getName().substring(3);
                nomeMetodo = nomeMetodo.substring(0,1).toLowerCase().concat(nomeMetodo.substring(1));
                meioJSON =  meioJSON.concat("  "+"\""+nomeMetodo+"\"" +" : \""+ m.invoke(o) + "\",\n");
            }
        }
        meioJSON = meioJSON.substring(0,meioJSON.length()-2);
        JSONFormatado = inicioJSON + meioJSON + finalJSON;
        System.out.println(JSONFormatado);
        return "";
    }
}
