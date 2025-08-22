package mrbet;
/**
 * Classe main
 * @author Davi de Lucena - 124211045
 */
import java.util.Scanner;
public class MrBetMain {

	public static void main(String[] args) {
		MrBetController mrbet = new MrBetController();
		mrbet.adicionaTime("a","flamengo", "urubu");
		mrbet.adicionaCampeonato("brasil", 10);
		mrbet.adicionaTimeCampeonato("brasil", "a");
		mrbet.mostraCampeonatosTime(null);
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, mrbet, scanner);
		}
	}
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(M)Minha inclusão de times\n" + 
						"(R)Recuperar time\n" +
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" + 
						"(E)Exibir campeonatos que o time participa\n" + 
						"(T)Tentar a sorte e status\n" + 
						"(!)Já pode fechar o programa!\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, MrBetController mrbet, Scanner scanner) {
		switch (opcao) {
		case "M":
			adicionaTime(mrbet, scanner);
			break;
		case "R":
			recuperaTime(mrbet, scanner);
			break;
		case ".":
			adicionaCampeonato(mrbet, scanner);
			break;
		case "B":
			incluiVerificaTimeCampeonato(mrbet, scanner);
			break;
		case "E":
			exibeCampeonatosTime(mrbet, scanner);
			break;
		case "T":
			tentarSorteStatus(mrbet, scanner);
			break;
		case "!":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	private static void sai() {
		System.out.println("Por isso é só, pessoal!");
		System.exit(0);
		
	}

	private static void tentarSorteStatus(MrBetController mrbet, Scanner scanner) {
		System.out.println("\n(A)Apostar ou (S)Status das Apostas? ");
		String decisao = scanner.next().toUpperCase();
		switch(decisao) {
		case"A":
			apostar(mrbet, scanner);
			break;
		case"S":
			statusApostas(mrbet, scanner);
			break;
		default:
			System.out.println("Opção inválida");;
		}
		
	}

	private static void statusApostas(MrBetController mrbet, Scanner scanner) {
		System.out.println(mrbet.statusAposta());
		
	}

	private static void apostar(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCodigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println("\nCampeonato: ");
		String nome = scanner.nextLine();
		System.out.println("\nColocação: ");
		int colocacao = scanner.nextInt();
		scanner.nextLine();
		System.out.println("\nValor: ");
		double valorAposta = scanner.nextDouble();
		scanner.nextLine();
		System.out.println(mrbet.tentarSorte(id, nome, colocacao, valorAposta));
		
	}

	private static void exibeCampeonatosTime(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCodigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println(mrbet.mostraCampeonatosTime(id));
		
	}

	private static void incluiVerificaTimeCampeonato(MrBetController mrbet, Scanner scanner) {
		System.out.println("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String decisao = scanner.next().toUpperCase();
		switch(decisao) {
		case"I":
			incluiTimeCampeonato(mrbet, scanner);
			break;
		case"V":
			verificaTimeCampeonato(mrbet, scanner);
			break;
		default:
			System.out.println("Opção inválida");;
		}

	}

	private static void verificaTimeCampeonato(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCodigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println("\nCampeonato: ");
		String nome = scanner.nextLine();
		System.out.println(mrbet.verificaTimeCampeonato(nome, id));
		
	}

	private static void incluiTimeCampeonato(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCodigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println("\nCampeonato: ");
		String nome = scanner.nextLine();
		System.out.println(mrbet.adicionaTimeCampeonato(nome, id));
		
	}

	private static void adicionaCampeonato(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCampeonato: ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.println("\nParticipantes: ");
		int participantes = scanner.nextInt();
		scanner.nextLine();
		System.out.println(mrbet.adicionaCampeonato(nome, participantes));
		
	}

	private static void recuperaTime(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCódigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println(mrbet.getTime(id));
		
	}

	private static void adicionaTime(MrBetController mrbet, Scanner scanner) {
		System.out.println("\nCódigo: ");
		scanner.nextLine();
		String id = scanner.nextLine();
		System.out.println("\nNome: ");
		String nome = scanner.nextLine();
		System.out.println("\nMascote: ");
		String mascote = scanner.nextLine();
		System.out.println(mrbet.adicionaTime(id, nome, mascote));
		
	}
	
}
