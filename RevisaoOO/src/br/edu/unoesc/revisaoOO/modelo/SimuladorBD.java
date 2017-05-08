package br.edu.unoesc.revisaoOO.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.revisaoOO.dao.ManipuladorArquivo;

public class SimuladorBD {

	private static List<Agencia> agencias;
	private static List<Cliente> clientes;
	private static ManipuladorArquivo manipuladorArquivo;

	static {
		agencias = new ArrayList<>();
		clientes = new ArrayList<>();
		manipuladorArquivo = new ManipuladorArquivo();
	}
	
	public static void insert(Agencia agencia) {
		agencias.add(agencia);
		manipuladorArquivo.gravar(agencias, "agencia.ser");
	}

	public static void remover(Agencia agencia) {
		agencias.remove(agencia);
	}

	public static List<Agencia> getAgencias() {
		agencias = manipuladorArquivo.recuperar("agencia.ser");
		return agencias;
	}

	// Clientes
	public static void insert(Cliente cliente) {
		clientes.add(cliente);
	}

	public static void remover(Cliente cliente) {
		clientes.remove(cliente);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}
}
