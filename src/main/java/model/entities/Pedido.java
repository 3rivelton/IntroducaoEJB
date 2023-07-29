package model.entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID codigo;
	private Date data;
	private String status;
	private List<Item> itens = new ArrayList<>();
	
	public UUID getCodigo() {
		return codigo;
	}
	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
