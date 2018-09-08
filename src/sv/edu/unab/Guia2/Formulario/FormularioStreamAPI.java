package sv.edu.unab.Guia2.Formulario;
import  sv.edu.unab.Guia2.Dominio.Pacientes;
import  sv.edu.unab.Guia2.Formulario.FormularioClasico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FormularioStreamAPI {
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
    private JTable tblPacientes;
    public JPanel pnlPrincipal;
    private JTextField txtBusqueda;
    private JButton btnBuscar;

    List<Pacientes> listadoModel, filtradoModel;
    String Codigo;
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Diagnostico;
    Integer Telefono;
    Character Sexo;

    public FormularioStreamAPI() {

        initcomponents();
    }
    public void initcomponents(){
        tblPacientes.setFillsViewportHeight(true);
        if (listadoModel==null){
            listadoModel=new ArrayList<>();
        }
        listadoModel.add(new Pacientes(String.valueOf(new Random().nextInt()), "Karla Michelle", "Rivera", "Aleman", "Gripe",78674563, 'F'));
        listadoModel.add(new Pacientes(String.valueOf(new Random().nextInt()), "Reina Carolina", "Serrano", "Luna", "Tos",23674563, 'F'));
        listadoModel.add(new Pacientes(String.valueOf(new Random().nextInt()), "Kevin Ricardo", "Serrano", "Luna", "Gripe",79974563, 'M'));
        ActualizarDatos(listadoModel);

        btnAgregar.addActionListener(e->{
            Pacientes p=new Pacientes();
            p.setCodigo(String.valueOf(new Random().nextInt()));
            p.setNombre(txtNombre.getText());
            p.setApellidoPaterno(txtApellidoPaterno.getText());
            p.setApellidoMaterno(txtApellidoMaterno.getText());
            p.setDiagnostico(atxtDiagnostico.getText());
            p.setTelefono(Integer.parseInt(txtTelefono.getText()));
            p.setSexo(cboSexo.getSelectedItem().toString().toUpperCase().charAt(0));
            listadoModel.add(p);
            ActualizarDatos(listadoModel);
            limpiar();
        });

        btnEditar.addActionListener(e->{
            txtNombre.setText(Nombre);
            txtApellidoPaterno.setText(ApellidoPaterno);
            txtApellidoMaterno.setText(ApellidoMaterno);
            atxtDiagnostico.setText(Diagnostico);
            txtTelefono.setText(String.valueOf(Telefono));

        });

        btnGuardar.addActionListener(e->{
            listadoModel.stream().forEach(c->{
                if (c.getCodigo().equals(Codigo))
                {
                    c.setNombre(txtNombre.getText());
                    c.setApellidoPaterno(txtApellidoPaterno.getText());
                    c.setApellidoMaterno(txtApellidoMaterno.getText());
                    c.setDiagnostico(atxtDiagnostico.getText());
                    c.setTelefono(Integer.valueOf(txtTelefono.getText()));
                    c.setSexo(cboSexo.getSelectedItem().toString().charAt(0));
                }
                limpiar();
                ActualizarDatos(listadoModel);
            });
        });

        btnEliminar.addActionListener(e->{
            listadoModel.removeIf(c->c.getCodigo().equals(Codigo));
            ActualizarDatos(listadoModel);
        });

        btnBuscar.addActionListener(e->{
            List<Pacientes> busqueda=listadoModel.stream().filter(m->{
                boolean respuesta=false;
                if (m.getNombre().equals(txtNombre.getText())){
                    respuesta=true;
                }
                return  respuesta;
            }).collect(Collectors.toList());
            ActualizarDatos(busqueda);

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
    private void ActualizarDatos(List<Pacientes> listado){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("telefono");
        modelo.addColumn("Sexo");

        listado.stream().forEach(c->{
            modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getNombre(),
                    c.getApellidoPaterno(),
                    c.getApellidoMaterno(),
                    c.getDiagnostico(),
                    c.getTelefono(),
                    c.getSexo()

            });
        });
        tblPacientes.setModel(modelo);
    }
    public void limpiar(){
        txtNombre.setText(null);
        txtApellidoPaterno.setText(null);
        txtApellidoMaterno.setText(null);
        atxtDiagnostico.setText(null);
        txtTelefono.setText(null);
        cboSexo.setSelectedItem(1);
    }
}
