package br.com.senai.filter;

public class VagaFilter {
	private String order;
	private String titulo;
	private String cidade;
	private String estado;
	private String empresa;
	private Double remuneracaoMinima;
	private Double remuneracaoMaxima;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Double getRemuneracaoMinima() {
		return remuneracaoMinima;
	}
	public void setRemuneracaoMinima(Double remuneracaoMinima) {
		this.remuneracaoMinima = remuneracaoMinima;
	}
	public Double getRemuneracaoMaxima() {
		return remuneracaoMaxima;
	}
	public void setRemuneracaoMaxima(Double remuneracaoMaxima) {
		this.remuneracaoMaxima = remuneracaoMaxima;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
