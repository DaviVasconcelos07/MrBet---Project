package mrbet;
/**
 * Classe de Aposta
 * @author Davi de Lucena - 124211045
 */
public class Aposta {

	private String timeApostado;
	private String idTime;
	private String campeonato;
	private int colocacao;
	private double valor;
	private String mascote;
	private int participantes;
	
	/**
	 * Constrututor da Classe
	 * @param id, do time apostado
	 * @param time, Nome do time apostado
	 * @param campeonato, Nome do campeonato apostado
	 * @param colocacao, Colocacao do time na aposta
	 * @param valor, valor apostado
	 * @param mascote, do time apostado
	 * @param participantes, String formatada para o toString
	 */
	public Aposta(String id, String time, String campeonato, int colocacao, double valor, String mascote, int participantes) {
		this.timeApostado = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valor = valor;
		this.idTime = id;
		this.mascote = mascote;
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "["+idTime+"] " + timeApostado + " / " + mascote + " | " + campeonato + " - " + colocacao +"/"+participantes +" | "+"R$"+valor;
	}
	
	
}
