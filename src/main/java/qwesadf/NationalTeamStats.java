package qwesadf;


/**
 * Interface que retorna estat�sticas sobre as consultas efetuadas por meio da interface NationalTeamInfos a uma sele��o participante da Copa do Mundo 2022.
 * <br>
 * <br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/2 (BCC)
 *
 * @version 1.0.0
 *
 */

public interface NationalTeamStats {

	int getHowManyQuestions();
	

	String getHowManyCallsToPlayer(int number);

}
