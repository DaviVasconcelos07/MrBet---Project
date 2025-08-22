package mrbet;
/**
 * Classe Time
 * @author Davi de Lucena - 124211045
 */
import java.util.*;

public class Time {

	private String id;
	private String nome;
	private String mascote;
	private ArrayList <Campeonato> campeonatos = new ArrayList<>();
	
	/**
	 * Contrutor da classe time
	 * @param id
	 * @param nome
	 * @param mascote
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
	}
	
	/**
	 * Adiciona um campeonato a lista de Campeonatos que o time participa
	 * @param c
	 */
	public void adicionaCampeonato(Campeonato c) {
		campeonatos.add(c);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMascote() {
		return mascote;
	}
	
	/**
	 * Retorna a quantidade de Campeonatos que o time está cadastrado
	 * 
	 */
	public int getQtdCampeonatos() {
		return campeonatos.size();
	}
	
	/**
	 * Formatação de todos os campeonatos
	 * @return String formatada dos campeonatos
	 */
	public String getCampeonatos() {
		String strCampeonatos = "";
		for(int i = campeonatos.size()-1; i>= 0;  i --) {
				strCampeonatos += campeonatos.get(i).toString() + " | ";
		}
		strCampeonatos = strCampeonatos.substring(0, strCampeonatos.length()-3);
		return "Time: " + id +" | Campeonatos do "+ nome+  " | " + strCampeonatos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Time))
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "["+id+"] " + nome + " / " + mascote;// + getCampeonatos();
	}
	
	
}
