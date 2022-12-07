package module_japao;

import fifa.NationalTeamStats;

public class teste {

	public static void main(String[] args) {

		Japao japao = new Japao();
		// japao.setCalltoPlayer
		NationalTeamStats Stats = japao.getStatsResponsible();
		System.out.println(Stats.getHowManyCallsToPlayer(27));
	}

}
