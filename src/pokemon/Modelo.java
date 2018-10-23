package pokemon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import bbdd.Pokemon;

public class Modelo {

	private HashMap <String, Pokemon> pokemones = new HashMap();
	private final String filepokemon = "pokemon.dat";
	
	public Modelo() throws ClassNotFoundException, IOException {
		if(new File(filepokemon).exists()) {
			cargarPokemones();
		}
		else {
		pokemones = new HashMap<String, Pokemon>();
		}
	}

	public void guardar(Pokemon pokemon) throws IOException {
		
		pokemones.put(pokemon.getNombre(), pokemon);
		serializar();
	}
	
	public void borrar(Pokemon pokemon) {
		
		
		
	}

	private void serializar() throws IOException{
			
			ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(filepokemon));	
			serializador.writeObject(pokemones);
			serializador.close();
	}
	@SuppressWarnings({ "unused", "unchecked" })
	private void cargarPokemones() throws IOException, ClassNotFoundException{
		
		ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(filepokemon));
		pokemones = (HashMap<String, Pokemon>) deserializador.readObject();
		deserializador.close();
	}
	
	public void modificarPokemon(String nombre, Pokemon pokemon) {
		
		
	}
	
	public ArrayList<Pokemon> getPokemones() {
		
		return new ArrayList<Pokemon>(pokemones.values());
	}
	
	public ArrayList<Pokemon> getPokemones(String busqueda){
		
		return null;
	}
	
	public void eliminarTodo() {
		
	}

	
}
