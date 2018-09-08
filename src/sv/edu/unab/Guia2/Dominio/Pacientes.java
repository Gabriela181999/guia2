package sv.edu.unab.Guia2.Dominio;

import java.util.StringJoiner;

public class Pacientes {
    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String diagnostico;
    private int telefono;
    private Character sexo;

    public Pacientes() {
    }

    public Pacientes(String codigo) {

        this.codigo = codigo;
    }

    public Pacientes(String codigo, String nombre, String apellidoPaterno, String apellidoMaterno,String diagnostico, int telefono, Character sexo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.diagnostico = diagnostico;
        this.telefono = telefono;
        this.sexo = sexo;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pacientes)) return false;

        Pacientes paciente = (Pacientes) o;

        return codigo.equals(paciente.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner("")
                .add(codigo)
                .toString();
    }

    public String toString1() {
        return new StringJoiner(", ", Pacientes.class.getSimpleName() + "[", "]")
                .add("codigo='" + codigo + "'")
                .add("nombre='" + nombre + "'")
                .add("apellidoPaterno='" + apellidoPaterno + "'")
                .add("apellidoMaterno='" + apellidoMaterno + "'")
                .add("Diagnostico='" + diagnostico + "'")
                .add("telefono=" + telefono)
                .add("sexo='" + sexo + "'")
                .toString();
    }
}
