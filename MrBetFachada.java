package mrbet;
/**
 * Fachada principal do sistema MrBet, responsavel por gerenciar os eventos que
 * chegam para o sistema, direcionando para as classes adequadas.
 * 
 * @author Monitores/LP2
 */
import easyaccept.EasyAccept;

public class MrBetFachada {
	
	//declara controller
	
	MrBetController mrbet = new MrBetController();
	
	public MrBetFachada() {
		//instancia controller
	}
	
	/**
     * Inclui um novo campeonato no sistema.
     * 
     * @param nome Nome do campeonato.
     * @param participantes Numero maximo de participantes no campeonato.
     * @return Mensagem indicando o sucesso ou falha na inclusao.
     */
	public String incluirCampeonato(String nome, int participantes) {
		return mrbet.adicionaCampeonato(nome, participantes);
	}
	
	/**
     * Inclui um novo time no sistema.
     * 
     * @param codigo Codigo identificador do time.
     * @param nome Nome do time.
     * @param mascote Nome do mascote do time.
     * @return Mensagem indicando se a inclusao foi realizada ou se o time ja existe.
     */
	public String incluirTime(String codigo, String nome, String mascote) {
		return mrbet.adicionaTime(codigo, nome, mascote);
	}
	
	/**
     * Recupera as informacoes de um time a partir do seu codigo identificador.
     * 
     * @param codigo Codigo do time.
     * @return Informacoes do time ou mensagem indicando que o time nao existe.
     */
	public String recuperarTime(String codigo) {
		return mrbet.getTime(codigo);
	}
	
	/**
     * Inclui um time em um campeonato especifico.
     * 
     * @param codTime Codigo do time.
     * @param nomeCamp Nome do campeonato.
     * @return Mensagem indicando o resultado da inclusao.
     */
	public String incluirTimeCampeonato(String codTime, String nomeCamp) {
		return mrbet.adicionaTimeCampeonato(nomeCamp, codTime);
	}
	
	/**
     * Verifica se um time faz parte de um campeonato.
     * 
     * @param codTime Codigo do time.
     * @param nomeCamp Nome do campeonato.
     * @return Mensagem informando se o time estao ou nao no campeonato.
     */
	public String verificaTimeCampeonato(String codTime, String nomeCamp) {
		return mrbet.verificaTimeCampeonato(nomeCamp, codTime);
	}
	
	/**
     * Retorna os campeonatos em que um time esta participando.
     * 
     * @param codigo Codigo do time.
     * @return Lista de campeonatos em que o time participa ou mensagem informando que ele não está em nenhum campeonato.
     */
	public String campsParticipando(String codigo) {
		return mrbet.mostraCampeonatosTime(codigo);
	}
	
	/**
     * Registra uma aposta no sistema.
     * 
     * @param codTime Codigo do time apostado.
     * @param nomeCamp Nome do campeonato em que a aposta foi realizada.
     * @param colocacao Posicao apostada para o time.
     * @param preco Valor da aposta.
     * @return Mensagem indicando o sucesso ou falha ao registrar a aposta.
     */
	public String tentarSorte(String codTime, String nomeCamp, int colocacao, double preco) {
		return mrbet.tentarSorte(codTime, nomeCamp, colocacao, preco);
	}
	
	/**
     * Retorna o status das apostas registradas no sistema.
     * 
     * @return Lista das apostas realizadas ou mensagem informando que nao ha apostas registradas.
     */
	public String statusAposta() {
		return mrbet.statusAposta();
	}
	
	public static void main(String[] args) {
		args = new String[] {"mrbet.MrBetFachada", 
				"testes_aceitacao/use_case_test_incluirTime.txt",
				"testes_aceitacao/use_case_test_recuperarTime.txt",
				"testes_aceitacao/use_case_test_incluirCampeonato.txt",
				"testes_aceitacao/use_case_test_incluirTimeCampeonato.txt",
				"testes_aceitacao/use_case_test_verificaTimeCampeonato.txt",
				"testes_aceitacao/use_case_test_campsParticipando.txt",
				"testes_aceitacao/use_case_test_statusApostas.txt",
				"testes_aceitacao/use_case_test_tentarSorte.txt",
				};
		EasyAccept.main(args);
	}
}
