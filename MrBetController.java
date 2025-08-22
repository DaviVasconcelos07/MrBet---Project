package mrbet;
/**
 * Classe controladora do sistema, que se relaciona e interage com as outras
 * 
 * @author Davi de Lucena - 124211045
 */
import java.util.*;
public class MrBetController {

	private HashMap <String, Time> times = new HashMap<>();
	private HashMap <String, Campeonato> campeonatos = new HashMap<>();
	private ArrayList <Aposta> apostas = new ArrayList<>();
	

	/**
	 * Construtor
	 */
	public MrBetController(){
		
	}
	

	/**
	 * cadastra um novo time
	 * @param id unico do time
	 * @param nome do time
	 * @param mascote do time
	 * @return
	 */
	public String adicionaTime(String id, String nome, String mascote) {
		if(nome == null || nome.trim().isEmpty() || id == null|| id.trim().isEmpty() || mascote == null || mascote.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(confereTime(id)) {
				Time t = new Time(id, nome, mascote);
				times.put(id, t);
				return "INCLUSAO REALIZADA!";
			}else {
				return "TIME JA EXISTE!";
			}
		}
		
	}
	
	/**
	 * confere se o time com este id já foi adicionado
	 * @param id
	 * @return se o time já existia ou não
	 */
	private boolean confereTime(String id) {
		if(times.containsKey(id)) {
			return false;
		}
		return true;
	}
	
	/**
	 * retorna algum time especifico
	 * @param id
	 * @return o toString do time
	 */
	public String getTime(String id) {
		if(id == null || id.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(times.containsKey(id)) {
				return times.get(id).toString();
			}
			return "TIME NAO EXISTE!";
		}
		
		
	}
	
	/**
	 * adiciona um novo campeonato
	 * @param nome do campeonato
	 * @param qtd de participantes
	 * @return
	 */
	public String adicionaCampeonato(String nome, int qtd) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(confereCampeonato(nome)) {
				Campeonato c = new Campeonato(nome, qtd);
				campeonatos.put(nome.toUpperCase(), c);
				return "CAMPEONATO ADICIONADO!";
			}else {
				return "CAMPEONATO JA EXISTE!";
			}
		}
	}
	
	/**
	 * segundo contrutor para campeonatos, sem a quantidade de participantes
	 * @param nome
	 * @return
	 */
	public String adicionaCampeonato(String nome) {
		if(confereCampeonato(nome)) {
			Campeonato c = new Campeonato(nome);
			campeonatos.put(nome.toUpperCase(), c);
			return "CAMPEONATO ADICIONADO!";
		}else {
			return "CAMPEONATO JA EXISTE!";
		}
	}
	
	/**
	 * confere se um campeonato específico existe
	 * @param nome
	 * @return se existe ou não
	 */
	private boolean confereCampeonato(String nome) {
		for(Campeonato c: campeonatos.values()) {
			if(c.getNome().toUpperCase().equals(nome.toUpperCase())) {
				return false;
			}
			
		}
		return true;
	}
	
	 
	
	/**
	 * adiciona algum time a um campeonato
	 * @param nome do campeonato
	 * @param id do time
	 * @return se foi possível adicionar ou não. Possível mensagem de erro
	 */
	public String adicionaTimeCampeonato(String nome, String id) {
		if(nome == null || nome.trim().isEmpty()|| id == null || id.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(confereTime(id)) {
				throw new IllegalArgumentException("O TIME NAO EXISTE!");
			}else if(confereCampeonato(nome)) {
				throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
			}else if(!campeonatos.get(nome.toUpperCase()).confereTime(id)) {
				return "O TIME JA FOI INCLUIDO ANTERIORMENTE!";
			}else if(!campeonatos.get(nome.toUpperCase()).confereLimite()){
				return "TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!";
			}else {
				campeonatos.get(nome.toUpperCase()).adicionaTimeACampeonato(id, times.get(id));
				times.get(id).adicionaCampeonato(campeonatos.get(nome.toUpperCase()));
				return "TIME INCLUIDO NO CAMPEONATO!";
			}
		}
			
	}
	
	/**
	 * verifica se algum time já está em algum campeonato
	 * @param nome do campeonato
	 * @param id do time
	 * @return se está ou não, ou possível mensagem de erro
	 */
	public String verificaTimeCampeonato(String nome, String id) {
		if(nome == null|| id == null|| nome.trim().isEmpty()|| id.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(confereTime(id)) {
				throw new IllegalArgumentException("O TIME NAO EXISTE!");
			}else if(confereCampeonato(nome)) {
				throw new IllegalArgumentException("O CAMPEONATO NAO EXISTE!");
			}else if(!campeonatos.get(nome.toUpperCase()).confereTime(id)){
				return "O TIME ESTA NO CAMPEONATO!";
			}else{
				return "O TIME NAO ESTA NO CAMPEONATO!";
			}
		}
		
		
		

	}
	
	/**
	 * retorna todos os campeonatos que um time específico participa
	 * @param id do time
	 * @return possível mensagem de erro ou lista de campeonatos
	 */
	public String mostraCampeonatosTime(String id) {
		if(id == null || id.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else if(confereTime(id)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}else if(times.get(id).getQtdCampeonatos() == 0){
			return "O TIME NAO ESTA EM NENHUM CAMPEONATO!";
		}else {
			return times.get(id).getCampeonatos();
		}
	}
	
	/**
	 * realiza aposta
	 * @param id do time
	 * @param campeonato
	 * @param colocacao do time na aposta
	 * @param valor apostado
	 * @return
	 */
	public String tentarSorte(String id, String campeonato, int colocacao, double valor) {
		if(id == null|| campeonato == null|| id.trim().isEmpty()|| campeonato.trim().isEmpty()) {
			throw new IllegalArgumentException("Nao pode adicionar o vazio");
		}else {
			if(!times.containsKey(id)){
				throw new IllegalArgumentException("O TIME NAO EXISTE!");
			}else if(!campeonatos.containsKey(campeonato.toUpperCase())){
				throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
			}else if(campeonatos.get(campeonato.toUpperCase()).getParticipantesNumeros() < colocacao || colocacao <= 0 ){
				return"APOSTA NAO REGISTRADA!";
			}else if(campeonatos.get(campeonato.toUpperCase()).confereTime(id)){
				return "O TIME NAO ESTA NO CAMPEONATO!";
			}else {
				Aposta a = new Aposta(id, times.get(id).getNome(), campeonato, colocacao, valor, times.get(id).getMascote(), campeonatos.get(campeonato.toUpperCase()).getParticipantesNumeros());
				apostas.add(a);
				return "APOSTA REGISTRADA!";
			}
		}
		
	}
	
	/**
	 * @return todas as apostas 
	 */
	public String statusAposta() {
		String strApostas = "Apostas: | ";
		if(apostas.size() == 0) {
			return "NAO TEM APOSTAS REGISTRADAS!";
		}else {
			for(int i = 0; i< apostas.size(); i++) {
					strApostas += i+1 + ". " +apostas.get(i).toString() +" | ";
				
				 
			}
			strApostas = strApostas.substring(0, strApostas.length()-3);
			return strApostas;
		}
		
	}
	
	
}
