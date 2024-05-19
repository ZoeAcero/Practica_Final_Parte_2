import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import Experimento.Experimento;
import GestorDeArchivos.GestorDeArchivos;
import PoblacionDeBacterias.Poblacion;
import Simulacion.Simulacion;
import Experimento.Bacteria;
import java.util.List;

public class Main extends JFrame{
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private Experimento experimento;

    public Main() {
        setTitle("Simulación de Bacterias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(144, 238, 144));
        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");
        menuBar.add(menu);
        menuItem = new JMenuItem("Abrir experimento");
        menuItem.addActionListener(e -> abrirExperimento());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Crear nuevo experimento");
        menuItem.addActionListener(e -> crearNuevoExperimento());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Guardar experimento");
        menuItem.addActionListener(e -> guardarExperimento());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Guardar como nuevo archivo");
        menuItem.addActionListener(e -> guardarComoNuevoArchivo());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
}
