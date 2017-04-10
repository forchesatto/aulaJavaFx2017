package application;

import br.edu.unoesc.revisaoOO.modelo.Cliente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClienteController {

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCpf;

	@FXML
	private DatePicker dtDataNascimento;

	@FXML
	private Button btnSalvar;

	@FXML
	private ListView<Cliente> lvCliente;
	
	private Cliente cliente;
	
	private boolean editando;

	@FXML
	public void initialize() {
		lvCliente.setItems(FXCollections.observableArrayList());
		novo();
	}

	@FXML
	void onSalvar(ActionEvent event) {
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		cliente.setDataNascimento(dtDataNascimento.getValue());
		if(editando){
			lvCliente.refresh();
		} else {
			lvCliente.getItems().add(cliente);			
		}
		novo();
	}
	
	private void novo(){
		editando = false;
		cliente = new Cliente();	
		limparCampos();
	}
	
	private void limparCampos(){
		tfNome.setText("");
		tfCpf.setText("");
		dtDataNascimento.setValue(null);
	}
	
	@FXML
	void onEditar(MouseEvent mouseEvent){
		if(mouseEvent.getEventType()
				.equals(MouseEvent.MOUSE_CLICKED)){
			cliente = lvCliente.getSelectionModel().getSelectedItem(); 
			tfNome.setText(cliente.getNome());
			tfCpf.setText(cliente.getCpf());
			dtDataNascimento.setValue(cliente.getDataNascimento());
			editando = true;
		}
	}
	
	@FXML
	void onNovo(ActionEvent event){
		novo();
	}
	
}
