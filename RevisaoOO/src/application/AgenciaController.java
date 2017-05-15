package application;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import br.edu.unoesc.revisaoOO.modelo.Cliente;
import br.edu.unoesc.revisaoOO.modelo.SimuladorBD;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AgenciaController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfNumero;

	@FXML
	private Button btnSalvar;

	@FXML
	private TableView<Agencia> tblAgencia;
	
	@FXML
	private TableColumn<Agencia, Number> tbcNumero;
	
	@FXML
	private TableColumn<Agencia, String> tbcNome;
	
	@FXML
	private TableColumn<Agencia, String> tbcCliente;
	
	@FXML
	private Button btnNovo;

	@FXML
	private Button btnExcluir;
	
	private Agencia agencia;
	private boolean editando;
	
	@FXML
	void initialize(){
		tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tblAgencia.setItems(FXCollections.observableArrayList(SimuladorBD.getAgencias()));
		novo();
	}
	
	private void novo(){
		agencia = new Agencia();
		editando = false;
		limparCampos();
	}
	
	private void limparCampos(){
		tfNome.setText("");
		tfNumero.setText("");
	}

	@FXML
	void onEditar(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
			agencia = tblAgencia.getSelectionModel().getSelectedItem();
			editando = true;
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumero().toString());
		}
	}

	@FXML
	void onExcluir(ActionEvent event) {
		tblAgencia.getItems().remove(agencia);
		SimuladorBD.remover(agencia);
		limparCampos();
	}

	@FXML
	void onNovo(ActionEvent event) {
		novo();
	}

	@FXML
	void onSalvar(ActionEvent event) {
		agencia.setNome(tfNome.getText());
		agencia.setNumero(Integer.valueOf(tfNumero.getText()));
		if(editando){
			SimuladorBD.atualizarAgencias();
			tblAgencia.refresh();
		} else {
			SimuladorBD.insert(agencia);
			tblAgencia.getItems().add(agencia);
		}
		novo();
	}
}
