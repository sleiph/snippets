package estruturaDados.arvoreBinaria;

public class Node {
	String elemento;
	int quantidade;
	Node esquerda;
	Node direita;
	
	Node(String valor){
		this.elemento = valor;
		this.quantidade = 1;
		this.esquerda = null;
		this.direita = null;
	}
	void repetida() {
	    quantidade++;
	}
}
