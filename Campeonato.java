package mrbet;
/**
 * Classe campeonato
 * @author Davi de Lucena - 124211045
 */
import java.util.HashMap;
import java.util.Objects;

public class Campeonato {

	private String nome;
	private int participantes;
	private HashMap <String, Time> times = new HashMap<>();
	
	/**
	 * Construtor da Classe Campeonato
	 * @param nome
	 * @param participantes, quantidade de participantes
	 */
	public Campeonato(String nome, int participantes) {
		this.nome = nome;
		this.participantes = participantes;
	}
	
	/**
	 * Segundo Construtor, sem a quantidade de participantes
	 * @param nome
	 */
	public Campeonato(String nome) {
		this.nome = nome;
		this.participantes = 10;
	}
	
	/**
	 * Cadastra um time ao campeonato
	 * @param id, codigo do time
	 * @param t, Time
	 * @return se foi adicionado ou não
	 */
	public boolean adicionaTimeACampeonato(String id, Time t) {
		if(confereLimite() && confereTime(id)) {
			times.put(id, t);
			return true;
		}
		return false;
		
	}
	
	/**
	 * confere Se o limite de participantes já foi extrapolado
	 * 
	 */
	public boolean confereLimite() {
		if(times.size()>= participantes) {
			return false;
		}
		return true;
		
	}
	
	/**
	 * Confere se um time já está cadastrado no campeonato
	 */
	public boolean confereTime(String id) {
		if(times.containsKey(id)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return os participantes Formatado, a relação entre o o total de participantes e as vagas preenchidas
	 */
	public String getParticipantes() {
		return times.size()+"/"+participantes;
	}
	
	/**
	 * 
	 * @return número crú de participantes
	 */
	public int getParticipantesNumeros() {
		return participantes;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Campeonato))
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "* "+ nome+" - " + getParticipantes();
	}
	
	
}
