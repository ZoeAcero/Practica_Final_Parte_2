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
        menu = new JMenu("Población");
        menuBar.add(menu);
        menuItem = new JMenuItem("Añadir nueva población");
        menuItem.addActionListener(e -> añadirNuevaPoblacion());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Listar poblaciones");
        menuItem.addActionListener(e -> listarPoblaciones());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Eliminar población");
        menuItem.addActionListener(e -> eliminarPoblacion());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Ver detalles de población");
        menuItem.addActionListener(e -> verDetallesPoblacion());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menu = new JMenu("Simulación");
        menuBar.add(menu);
        menuItem = new JMenuItem("Realizar simulación");
        menuItem.addActionListener(e -> realizarSimulacion());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        menuItem = new JMenuItem("Visualizar simulación");
        menuItem.addActionListener(e -> visualizarSimulacion());
        menuItem.setFont(new Font("Arial", Font.BOLD, 14));
        menu.add(menuItem);
        this.setJMenuBar(menuBar);
    }

    public void abrirExperimento() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            experimento = GestorDeArchivos.cargarExperimento(selectedFile.getPath());
        }
    }

    public void crearNuevoExperimento() {
        experimento = new Experimento(new ArrayList<>(), 0);
    }

    public void guardarExperimento() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            GestorDeArchivos.guardarExperimento(experimento, selectedFile.getPath());
        }
    }

    public void guardarComoNuevoArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            GestorDeArchivos.guardarExperimentoComoNuevoArchivo(experimento, selectedFile.getPath());
        }
    }

    public void añadirNuevaPoblacion() {
        Poblacion nuevaPoblacion = new Poblacion("nombre", new Date(), new ArrayList<>());
        experimento.agregarNuevaPoblacion(nuevaPoblacion);
    }

    public void listarPoblaciones() {
        for (Poblacion poblacion : experimento.getPoblaciones()) {
            System.out.println(poblacion.getNombre());
        }
    }

    public void eliminarPoblacion() {
    }

    public void verDetallesPoblacion() {
    }

    public void realizarSimulacion() {
        Simulacion simulacion = new Simulacion();
        simulacion.realizarSimulacionDiaria();
        StringBuilder resultados = new StringBuilder();
        List<Bacteria> bacterias = simulacion.getBacterias();
        for (Bacteria bacteria : bacterias) {
            resultados.append("Bacteria en posición: ").append(bacteria.getX()).append(", ").append(bacteria.getY()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultados.toString());
    }
}
