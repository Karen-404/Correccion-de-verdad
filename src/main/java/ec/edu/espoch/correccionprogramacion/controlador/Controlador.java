/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.correccionprogramacion.controlador;

import ec.edu.espoch.correccionprogramacion.modelo.GestionProducto;
import ec.edu.espoch.correccionprogramacion.modelo.Productos;
import ec.edu.espoch.correccionprogramacion.vista.ListarProducto;
import ec.edu.espoch.correccionprogramacion.vista.VistaProducto;


/**
 *
 * @author SO-LAB1-PC24
 */
public class Controlador {

    private VistaProducto principal;
    private GestionProducto gestorTarea;
    private ListarProducto listar;

    public Controlador(VistaProducto principal, ListarProducto listar) {
        this.principal = principal;
        this.listar = listar;
        //Cambia el constructor de la clase modelo
        this.gestorTarea = new GestionProducto();
    }

    public void agregarTarea() {

        try {
            if (this.principal != null) {
                Productos objTarea = new Productos();
                objTarea.setTitulo(this.principal.getTitulo());
                objTarea.setDescripcion(this.principal.getDescripcion());
                objTarea.setEstado(this.principal.getEstado());
                String msm = gestorTarea.agregarTarea(objTarea);
                principal.error(msm);

            } else {
                principal.error("Completa los datos!");
            }
        } catch (Exception e) {
            principal.error("Error controlado:" + e);
        }
    }

    public void listarTarea() {

        try {
            String msm = "";
            Productos[] tareas = new Productos[5];
            tareas = gestorTarea.listarTareas();
            if (tareas != null) {
                String lista = "";
                for (int i = 0; i < tareas.length; i++) {
                    if (tareas[i] != null) {
                        lista = lista + "id:" + tareas[i].getId() + "\n"
                                + "Titulo:" + tareas[i].getTitulo() + "\n"
                                + "Precio:" + tareas[i].getDescripcion() + "\n"
                                + "Estado:" + tareas[i].getEstado() + "\n";
                    }
                }
                msm = lista;
            } else {
                msm = "No hay datos que mostrar";
            }
            listar.mostrarDatos(msm);

        } catch (Exception e) {
            System.out.println("Error Controlador-listarTarea: " + e);
        }
    }
}