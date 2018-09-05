package com.branco;

import com.frame.JSONFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, IOException, ClassNotFoundException {
        // write your code here
        Pessoa p = new Pessoa();
        p.setCpf("123.123.123-11");
        p.setDataNascimento(new Date());
        p.setNome("meu nome");
        p.setOrgaoEspedido("ssp");
        p.setRG("123412344");

        JSONFrame jsonFrame = new JSONFrame();
        jsonFrame.getJSON(p);

        //taiana

//        new Main().imprimeInformaçõesObjetos(p);
//        new Main().carregaJar();
    }

    /**
     * Metodo para imprimir informações de um objeto
     * @param o
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void imprimeInformaçõesObjetos(Object o) throws IllegalAccessException, InvocationTargetException {
        for (Method m : o.getClass().getDeclaredMethods()) {
            System.out.print("Metodo: " + m.getName() + "(");
            for (Parameter p : m.getParameters()) {
                System.out.println(p.getType() + " " + p.getName() + ", ");
            }
            if (m.getName().startsWith("get")) {
                Object ret = m.invoke(o);
                System.out.println(")" + ret.toString());
            } else {
                System.out.print(")");
            }
        }
    }

    /**
     * Metodo para ler um arquivo
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private Collection<Class> carregaJar() throws ClassNotFoundException, IOException {
        Collection<Class> ret = new ArrayList<>();
        JFileChooser fc = new JFileChooser();
        if (fc.showDialog(new Frame(), "ok") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            JarFile jar = new JarFile(f);
            Enumeration<JarEntry> en = jar.entries();
            while (en.hasMoreElements()) {
                JarEntry entry = en.nextElement();
                if (entry.getName().endsWith(".class")) {
                    String nome = entry.getName().replaceAll("/", ".").replaceAll(".class", "");
                    ret.add(Class.forName(nome));

                } else {
                    System.out.println(entry.getName());

                }

            }
        }
        return ret;
    }
}
