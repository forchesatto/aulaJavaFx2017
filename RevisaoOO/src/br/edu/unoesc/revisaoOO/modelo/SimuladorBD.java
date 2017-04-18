package br.edu.unoesc.revisaoOO.modelo;

import java.util.ArrayList;
import java.util.List;

public class SimuladorBD {

	private static List<Agencia> agencias;
	private static List<Cliente> clientes;
	
	static{
		agencias = new ArrayList<>();
		clientes = new ArrayList<>();
	}
	
	public static void insert(Agencia agencia){
		agencias.add(agencia);
	}
	
	public static void remover(Agencia agencia){
		agencias.remove(agencia);
	}
	
	public static List<Agencia> getAgencias(){
		return agencias;
	}
	//Clientes
	public static void insert(Cliente cliente){
		clientes.add(cliente);
	}
	
	public static void remover(Cliente cliente){
		clientes.remove(cliente);
	}
	
	public static List<Cliente> getClientes(){
		return clientes;
	}
}
