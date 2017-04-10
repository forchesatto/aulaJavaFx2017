package application;

import br.edu.unoesc.revisaoOO.modelo.Agencia;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgenciaController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfNumero;

	@FXML
	private Button btnSalvar;

	@FXML
	private ListView<Agencia> lvAgencias;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnExcluir;
	
	private Agencia agencia;
	private boolean editando;
	
	@FXML
	void initialize(){
		lvAgencias.setItems(FXCollections.observableArrayList());
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
			agencia = lvAgencias.getSelectionModel().getSelectedItem();
			editando = true;
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumero().toString());
		}
	}

	@FXML
	void onExcluir(ActionEvent event) {
		lvAgencias.getItems().remove(agencia);
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
			lvAgencias.refresh();
		} else {
			lvAgencias.getItems().add(agencia);
		}
		novo();
	}
}
