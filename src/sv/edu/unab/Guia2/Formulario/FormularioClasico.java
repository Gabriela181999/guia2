package sv.edu.unab.Guia2.Formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import  sv.edu.unab.Guia2.Dominio.Pacientes;

public class FormularioClasico {
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextArea atxtDiagnostico;
    private JTextField txtTelefono;
    private JComboBox cboSexo;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnGuardar;
    private JButton btnBuscar;
    private JTable tblPacientes;
    private JTextField txtBusqueda;
    public JPanel pnlPrincipal;

    ArrayList<Pacientes> listado=new ArrayList<>();
    ArrayList<Pacientes> Filtrado=new ArrayList();
    String Codigo;
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Diagnostico;
    Integer Telefono;
    Character Sexo;

    public FormularioClasico(){
        initcomponents();
        tblPacientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i= tblPacientes.getSelectedRow();
                Codigo =(tblPacientes.getValueAt(i,0).toString());
                Nombre=(tblPacientes.getValueAt(i,1).toString());
                ApellidoPaterno=(tblPacientes.getValueAt(i,2).toString());
                ApellidoMaterno=(tblPacientes.getValueAt(i,3).toString());
                Diagnostico=(tblPacientes.getValueAt(i,4).toString());
                Telefono=Integer.parseInt(tblPacientes.getValueAt(i,5).toString());
                Sexo=(tblPacientes.getValueAt(i,6).toString().charAt(0));

            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pacientes p=new Pacientes();
                p.setCodigo(String.valueOf(new Random().nextInt()));
                p.setNombre(txtNombre.getText());
                p.setApellidoPaterno(txtApellidoMaterno.getText());
                p.setApellidoMaterno(txtApellidoMaterno.getText());
                p.setDiagnostico(atxtDiagnostico.getText());
                p.setTelefono(Integer.parseInt(txtTelefono.getText()));
                p.setSexo(cboSexo.getSelectedItem().toString().charAt(0));
                listado.add(p);
                Actualizar(listado);
                limpiarcomponentes();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText(Nombre);
                txtApellidoPaterno.setText(ApellidoPaterno);
                txtApellidoMaterno.setText(ApellidoMaterno);
                atxtDiagnostico.setText(Diagnostico);
                txtTelefono.setText(String.valueOf(Telefono));

                if (Sexo.equals('F')){
                    cboSexo.setSelectedItem(0);
                }
                else{
                    cboSexo.setSelectedItem(1);
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<listado.size();i++){
                    if (Codigo.equals(listado.get(i).getCodigo())){
                        listado.get(i).setNombre(txtNombre.getText());
                        listado.get(i).setApellidoPaterno(txtApellidoPaterno.getText());
                        listado.get(i).setApellidoMaterno(txtApellidoMaterno.getText());
                        listado.get(i).setDiagnostico(atxtDiagnostico.getText());
                        listado.get(i).setTelefono(Integer.valueOf(txtTelefono.getText()));
                        listado.get(i).setSexo(cboSexo.getSelectedItem().toString().charAt(0));
                    }
                }
                Actualizar(listado);
                limpiarcomponentes();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<listado.size(); i++){
                    if(Codigo==listado.get(i).getCodigo()){
                        listado.remove(i);
                    }
                    Actualizar(listado);
                    limpiarcomponentes();
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parametroNombre=txtBusqueda.getText();
                Filtrado.clear();
                for (int i=0;i<listado.size();i++){
                    if (parametroNombre.equals(listado.get(i).getNombre())){
                        Pacientes pa=new Pacientes();
                        pa.setCodigo(listado.get(i).getCodigo());
                        pa.setNombre(listado.get(i).getNombre());
                        pa.setApellidoPaterno(listado.get(i).getApellidoPaterno());
                        pa.setApellidoMaterno(listado.get(i).getApellidoMaterno());
                        pa.setDiagnostico(listado.get(i).getDiagnostico());
                        pa.setTelefono(listado.get(i).getTelefono());
                        pa.setSexo(listado.get(i).getSexo());
                        Filtrado.add(pa);
                    }
                }
                Actualizar(Filtrado);
            }
        });

        tblPacientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i=tblPacientes.getSelectedRow();
                Codigo =(tblPacientes.getValueAt(i,0).toString());
                Nombre=(tblPacientes.getValueAt(i,1).toString());
                ApellidoPaterno=(tblPacientes.getValueAt(i,2).toString());
                ApellidoMaterno=(tblPacientes.getValueAt(i,3).toString());
                Diagnostico=(tblPacientes.getValueAt(i,4).toString());
                Telefono=Integer.parseInt(tblPacientes.getValueAt(i,5).toString());
                Sexo=(tblPacientes.getValueAt(i,6).toString().charAt(0));

            }
        });

    }

    private void initcomponents() {
        listado.add(new Pacientes(String.valueOf(new Random().nextInt()), "Karla Michelle", "Rivera", "Aleman", "Gripe",78674563, 'F'));
        listado.add(new Pacientes(String.valueOf(new Random().nextInt()), "Reina Carolina", "Serrano", "Luna", "Tos",23674563, 'F'));
        listado.add(new Pacientes(String.valueOf(new Random().nextInt()), "Kevin Ricardo", "Serrano", "Luna", "Gripe",79974563, 'M'));

        Actualizar(listado);
    }

    public void Actualizar(ArrayList<Pacientes> listado){
        String matriz[][] = new String[listado.size()][8];
        for(int i = 0; i<listado.size(); i++){
            matriz[i][0]= listado.get(i).getCodigo();
            matriz[i][1]= listado.get(i).getNombre();
            matriz[i][2]= listado.get(i).getApellidoPaterno();
            matriz[i][3]= listado.get(i).getApellidoMaterno();
            matriz[i][4]= listado.get(i).getDiagnostico();
            matriz[i][5]= Integer.toString(listado.get(i).getTelefono());
            matriz[i][6]= String.valueOf(listado.get(i).getSexo().toString().charAt(0));
        }
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]
                {"Codigo","Nombre","Apellido Paterno","Apellido Materno", "Diagnostico","Telefono","Sexo"}));


    }
    public void limpiarcomponentes(){
        txtNombre.setText(null);
        txtApellidoPaterno.setText(null);
        txtApellidoMaterno.setText(null);
        atxtDiagnostico.setText(null);
        txtTelefono.setText(null);
        cboSexo.setSelectedItem(0);
    }
}
