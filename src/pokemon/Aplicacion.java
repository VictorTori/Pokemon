package pokemon;

import java.io.IOException;

import javax.swing.JOptionPane;

import ui.Vista;

public class Aplicacion {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		try {
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista,modelo);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "Formato de datos no correcto", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		
		
	}
	
}
