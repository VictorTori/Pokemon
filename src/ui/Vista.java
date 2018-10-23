package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import bbdd.Pokemon;

public class Vista {

	JFrame ventana;
	
	JLabel pokemon = new JLabel("POKEMON: ");
	JLabel nivel = new JLabel("NIVEL: ");
	JLabel nombre = new JLabel("NOMBRE*: ");
	JLabel peso = new JLabel("PESO: ");
	JLabel tipo = new JLabel("TIPO: ");
	public JLabel lbImagen = new JLabel("");
	
	public JButton btAnadir = new JButton("Añadir");
	public JButton btBorrar = new JButton("Borrar");
	public JButton btBorrarTodo = new JButton("Borrar Todo");
	
	public JComboBox<Pokemon.Tipo> cbTipo = new JComboBox();
	
	public JTextField nivelT = new JTextField(15);
	public JTextField nombreT = new JTextField(15);
	public JTextField pesoT = new JTextField(15);
	public DefaultListModel<Pokemon> mPokemons;
	public JList lpokemones = new JList();
	
	JPanel panel = new JPanel();
	
	SpringLayout sl = new SpringLayout();
	
	public Vista() {
		
		ventana = new JFrame();
		ventana.setSize(600,600);
		ventana.setVisible(true);
		
		ventana.getContentPane().setLayout(sl);
		
		for(JLabel lbImagen: new JLabel [] {pokemon,nivel,nombre,peso,tipo}) {
			
			lbImagen.setPreferredSize(new Dimension(100,20));
			
		}
		
		cbTipo = new JComboBox<>();
		cbTipo.setPreferredSize(new Dimension(150,20));
		
		// TEXTO POKEMON
		
		sl.putConstraint(SpringLayout.NORTH, pokemon, 50, SpringLayout.NORTH, ventana);
		sl.putConstraint(SpringLayout.WEST, pokemon, 20, SpringLayout.WEST, ventana);
		
		// NIVEL
	
		sl.putConstraint(SpringLayout.NORTH, nivel, 50, SpringLayout.NORTH, nombreT);
		sl.putConstraint(SpringLayout.WEST, nivel, 20, SpringLayout.WEST, ventana);
		
		sl.putConstraint(SpringLayout.NORTH, nivelT, 50, SpringLayout.NORTH, nombreT);
		sl.putConstraint(SpringLayout.WEST, nivelT, 20, SpringLayout.EAST, nivel);
		
		// NOMBRE
		
		sl.putConstraint(SpringLayout.NORTH, nombre, 50, SpringLayout.NORTH, pokemon);
		sl.putConstraint(SpringLayout.WEST, nombre, 20, SpringLayout.WEST, ventana);
		
		sl.putConstraint(SpringLayout.NORTH, nombreT, 50, SpringLayout.NORTH, pokemon);
		sl.putConstraint(SpringLayout.WEST, nombreT, 20, SpringLayout.EAST, nombre);
		
		// PESO
		
		sl.putConstraint(SpringLayout.NORTH, peso, 50, SpringLayout.NORTH, nivelT);
		sl.putConstraint(SpringLayout.WEST, peso, 20, SpringLayout.WEST, ventana);
		
		sl.putConstraint(SpringLayout.NORTH, pesoT, 50, SpringLayout.NORTH, nivelT);
		sl.putConstraint(SpringLayout.WEST, pesoT, 20, SpringLayout.EAST, peso);
		
		// TIPO
		
		sl.putConstraint(SpringLayout.NORTH, tipo, 50, SpringLayout.NORTH, pesoT);
		sl.putConstraint(SpringLayout.WEST, tipo, 20, SpringLayout.WEST, ventana);
		
		sl.putConstraint(SpringLayout.NORTH, cbTipo, 50, SpringLayout.NORTH, pesoT);
		sl.putConstraint(SpringLayout.WEST, cbTipo, 20, SpringLayout.EAST, tipo);
		
		// BOTON
		
		sl.putConstraint(SpringLayout.NORTH, btAnadir, 50, SpringLayout.NORTH, cbTipo);
		sl.putConstraint(SpringLayout.WEST, btAnadir, 20, SpringLayout.WEST, ventana);
		btAnadir.setActionCommand("anadir");
		
		sl.putConstraint(SpringLayout.NORTH, btBorrar, 0, SpringLayout.NORTH, btAnadir);
		sl.putConstraint(SpringLayout.WEST, btBorrar, 0, SpringLayout.WEST, nombreT);
		btBorrar.setActionCommand("borrar");
		ventana.getContentPane().add(btBorrar);
		
		
		sl.putConstraint(SpringLayout.NORTH, btBorrarTodo, 0, SpringLayout.NORTH, btAnadir);
		sl.putConstraint(SpringLayout.WEST, btBorrarTodo, 13, SpringLayout.EAST, btBorrar);
		btBorrarTodo.setActionCommand("borrartodo");
		ventana.getContentPane().add(btBorrarTodo);
		
		
		sl.putConstraint(SpringLayout.NORTH, lbImagen, 17, SpringLayout.SOUTH, btAnadir);
		sl.putConstraint(SpringLayout.WEST, lbImagen, 32, SpringLayout.WEST, ventana.getContentPane());
		sl.putConstraint(SpringLayout.SOUTH, lbImagen, -33, SpringLayout.SOUTH, ventana.getContentPane());
		sl.putConstraint(SpringLayout.EAST, lbImagen, -267, SpringLayout.EAST, ventana.getContentPane());
		lbImagen.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\Desktop\\images.jpg"));
		ventana.getContentPane().add(lbImagen);
		
		
		ventana.getContentPane().add(pokemon);
		ventana.getContentPane().add(nombre);
		ventana.getContentPane().add(nivel);
		ventana.getContentPane().add(peso);
		ventana.getContentPane().add(tipo);
		ventana.getContentPane().add(btAnadir);
		ventana.getContentPane().add(cbTipo);
		ventana.getContentPane().add(nivelT);
		ventana.getContentPane().add(nombreT);
		ventana.getContentPane().add(pesoT);
		
		JScrollPane scrollPane = new JScrollPane();
		sl.putConstraint(SpringLayout.NORTH, scrollPane, 100, SpringLayout.NORTH, ventana.getContentPane());
		sl.putConstraint(SpringLayout.WEST, scrollPane, 77, SpringLayout.EAST, cbTipo);
		sl.putConstraint(SpringLayout.SOUTH, scrollPane, 330, SpringLayout.NORTH, ventana.getContentPane());
		sl.putConstraint(SpringLayout.EAST, scrollPane, 277, SpringLayout.EAST, cbTipo);
		ventana.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(lpokemones);
		
		mPokemons = new DefaultListModel<>();
		lpokemones.setModel(mPokemons);
		
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.repaint();
		
	}
}
