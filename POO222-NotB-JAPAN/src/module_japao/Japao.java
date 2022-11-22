package module_japao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Japao implements NationalTeamInfos {
	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<MembroComiteTecnico> comite = new ArrayList<MembroComiteTecnico>();
	private ArrayList<Dirigente> dirigente = new ArrayList<Dirigente>();
	private Status status = new Status();
	
	@Override
	public int getHowManyMembers() {
		// TODO Auto-generated method stub
		return 22;
	}

	@Override
	public int getOldestPlayer() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public int getYoungestPlayer() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getAverageAge() {
		// TODO Auto-generated method stub
		return 22;
	}

	@Override
	public String getPlayer(int number) {
		String str = "{number:12, name:'Shuichi Gonda', nickname:'Shūichi', height:1,87, weight:83, birthDate:'1989-3-3', position:'Goalkeeper', currentClub:'Shimizu S-Pulse'}";
		return str;
	}

	@Override
	public String getPressOfficerContacts() {
		String str = "{name:'Naruto', tel1:'+5521989876543', tel2:'+974992008765', emailAccount:'naruto@viladafolha.com.br'}";
		return str;
	}

	@Override
	public String getCountryName() {
		String str = "Japao";
		return str;
	}

	@Override
	public Image getFlagImage() {
		BufferedImage flag  = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		return flag;
	}

	@Override
	public Path getTechnicalCommittee() {
		Path path = Paths.get("mockup/technicalCommittee"); 
		return path;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return status;
	}

}
