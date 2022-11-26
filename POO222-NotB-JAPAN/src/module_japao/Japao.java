package module_japao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

import org.json.JSONArray;
import org.json.JSONObject;
public class Japao implements NationalTeamInfos {
	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<MembroComiteTecnico> comite = new ArrayList<MembroComiteTecnico>();
	private ArrayList<Dirigente> dirigente = new ArrayList<Dirigente>();
	private Status status = new Status();
	
	public Japao() {
		String file = "../POO222-NotB-JAPAN/json/playerInfo.json";
		try {
			String contents = new String(Files.readAllBytes(Paths.get(file)));
			JSONObject o = new JSONObject(contents);
			JSONArray players = o.getJSONArray("players");
			for(int i = 0; i < players.length(); i++) {
				parsePlayer(players.getJSONObject(i));
			}
			System.out.println(jogadores);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void parsePlayer(JSONObject  p) {
		int number  = p.getInt("number");
		String currentClub = (String) p.get("currentClub");
		String name = (String) p.get("name");
		String nickname = (String) p.get("nickname");
		float weight = p.getFloat("weight");
		String position = (String) p.get("position");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("y-M-d");
		LocalDate birthdate = LocalDate.parse((String) p.get("birthDate"),df);
		float height = p.getFloat("height");
		Jogador j = new Jogador(number, name, nickname, height, weight, birthdate, position, currentClub);
		jogadores.add(j);
	}
	
	@Override
	public int getHowManyMembers() {
		// TODO Auto-generated method stub
		return 22;
	}

	@Override
	public int getOldestPlayer() {
		Jogador oldestPlayer = jogadores.get(0);
		for(Jogador p: jogadores) {
			if(p.getAge() > oldestPlayer.getAge()) {
				oldestPlayer = p;
			}
		}
		return oldestPlayer.getNumber();
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
