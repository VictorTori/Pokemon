package pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import bbdd.Pokemon;
import bbdd.Pokemon.Tipo;
import ui.Vista;

public class Controlador implements ActionListener, MouseListener{
	
	private Vista vista;
	private Modelo modelo;
	
	private File ficheroSeleccionado;
	
	public Controlador(Vista vista, Modelo modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		
		addListeners();
		poblarTiposPokemon();
		refrescarLista();
	}
	
	private void refrescarLista() {
		vista.mPokemons.removeAllElements();
		for(Pokemon pokemon:modelo.getPokemones()) {
			vista.mPokemons.addElement(pokemon);
		}
	}
	
	
	private void poblarTiposPokemon() {
		
		for(Tipo tipo: Tipo.values()) {
			vista.cbTipo.addItem(tipo);
		}
	}
	
	private void addListeners() {
		
		vista.btAnadir.addActionListener(this);
		vista.btBorrar.addActionListener(this);
		vista.lbImagen.addMouseListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case "anadir":
			
			
			if(vista.nombreT.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo NOMBRE es obligatorio", "error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(vista.nivelT.getText().equals(""))
				vista.nivelT.setText("0");
			if(vista.pesoT.getText().equals(""))
				vista.pesoT.setText("0");
			
			if(!vista.nivelT.getText().matches("[0-9]*")) {
				JOptionPane.showMessageDialog(null, "El nivel tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
				vista.nivelT.selectAll();
				vista.nivelT.requestFocus();
				return;
			}
			
			String nombre = vista.nombreT.getText();
			Tipo tipo = (Tipo) vista.cbTipo.getSelectedItem();
			int nivel = Integer.parseInt(vista.nivelT.getText());
			float peso = Float.parseFloat(vista.pesoT.getText());
			String imagen = vista.lbImagen.getText();
			
			Pokemon pokemon = new Pokemon();
			pokemon.setNombre(nombre);
			pokemon.setNivel(nivel);
			pokemon.setPeso(peso);
			pokemon.setTipo(tipo);
			pokemon.setImagen(imagen);
			try {
				modelo.guardar(pokemon);
				vista.mPokemons.addElement(pokemon);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Erro al guardar", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			vista.nivelT.setText("");
			vista.nombreT.setText("");
			vista.pesoT.setText("");
			
			break;
		case "borrar": 
		default:
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
			return;
		ficheroSeleccionado = jfc.getSelectedFile();
		vista.lbImagen.setIcon(new ImageIcon(ficheroSeleccionado.getAbsolutePath()));
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
