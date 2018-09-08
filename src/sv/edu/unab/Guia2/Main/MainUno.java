package sv.edu.unab.Guia2.Main;

import sv.edu.unab.Guia2.Formulario.FormularioClasico;

import javax.swing.*;
import java.awt.*;

public class MainUno {

    public static void main(String[] args) {
        //Obteniendo resoluciones de pantalla
        Dimension resolucionPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Ajustando tamaño del formulario
        Dimension ajusteTamaño = new Dimension(resolucionPantalla.width/2,resolucionPantalla.height - 100);
        JFrame frm = new JFrame("Paciente");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setContentPane(new FormularioClasico().pnlPrincipal);
        frm.setPreferredSize(ajusteTamaño);
        frm.setResizable(false);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}
