package sv.edu.unab.Guia2.Main;

import sv.edu.unab.Guia2.Formulario.FormularioStreamAPI;

import javax.swing.*;
import java.awt.*;

public class MainDos {
    public static void main(String[] args) {
        //Obteniendo resoluciones de pantalla
        Dimension resolucionPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ajusteTamaño = new Dimension(resolucionPantalla.width/2,resolucionPantalla.height - 100);
        JFrame frm = new JFrame("Gestio de Clientes Fashion mod con Stream API");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setContentPane(new FormularioStreamAPI().pnlPrincipal);
        frm.setPreferredSize(ajusteTamaño);
        frm.setResizable(false);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}
