package model.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID codigo;
	private String descricao;
	private String unidade; //Unidade de medida da Embalagem do Item
	
	public Item() {
		
	}
	
	public Item(UUID codigo, String descricao, String unidade) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidade = unidade;
		
	}
	
	public UUID getCodigo() {
		return codigo;
	}
	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	
	
	
}
