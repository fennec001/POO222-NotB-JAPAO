package module_japao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

import org.json.JSONArray;
import org.json.JSONObject;
public class Japao implements NationalTeamInfos {
	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<MembroComiteTecnico> comite = new ArrayList<MembroComiteTecnico>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<Dirigente>();
	private Status status = new Status();
	
	public Japao() {
		InputStream file = Japao.class.getResourceAsStream("/playerInfo.json");
		try {
			String contents = new String(file.readAllBytes());
			JSONObject o = new JSONObject(contents);
			parsePlayer(o);
			parseComite(o);
			parsePressOfficer(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void parsePlayer(JSONObject  o) {
		JSONArray players = o.getJSONArray("players");
		for(int i = 0; i < players.length(); i++) {
			JSONObject p = players.getJSONObject(i);
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
	}
	
	private void parseComite(JSONObject  o) {
		JSONArray committee = o.getJSONArray("committee");
		for(int i = 0; i < committee.length(); i++) {
			JSONObject p = committee.getJSONObject(i);
			String name  = p.getString("name");
			String nickname = p.getString("nickname");
			String role =  p.getString("role");
			int age = p.getInt("age");
			MembroComiteTecnico c = new MembroComiteTecnico(name,nickname,role,age);
			comite.add(c);
		}
	}
	
	private void parsePressOfficer(JSONObject  o) {
		JSONArray pressOfficer = o.getJSONArray("pressOfficer");
		for(int i = 0; i < pressOfficer.length(); i++) {
			JSONObject p = pressOfficer.getJSONObject(i);
			String name  = p.getString("name");
			String tel1 = p.getString("tel1");
			String tel2 = p.getString("tel2");
			String emailAccount =  p.getString("emailAccount");
			Dirigente d = new Dirigente(name,tel1,tel2,emailAccount);
			dirigentes.add(d);
		}
	}
	
	@Override
	public int getHowManyMembers() {
		// TODO Auto-generated method stub
		return dirigentes.size()+comite.size()+jogadores.size();
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
		Jogador youngestPlayer = jogadores.get(0);
		for(Jogador p: jogadores) {
			if(p.getAge() < youngestPlayer.getAge()) {
				youngestPlayer = p;
			}
		}
		return youngestPlayer.getNumber();
	}

	@Override
	public double getAverageAge() {
		double totalAge = 0;
		for(Jogador p: jogadores) {
			totalAge+= p.getAge();
		}
		return totalAge/jogadores.size();
	}

	@Override
	public String getPlayer(int number) {
		Jogador selecionado = null;
		for(Jogador p: jogadores) {
			if(p.getNumber() == number) {
				selecionado = p;
			}
		}
		if(selecionado != null) {
			JSONObject jsonObject = new JSONObject(selecionado);
			String myJson = jsonObject.toString();
			return myJson;
		}
		return "Jogador não encontrado";
	}

	@Override
	public String getPressOfficerContacts() {
		Dirigente dirigente = null;
		for(Dirigente d: dirigentes) {
			if(d.getName().equals("Naruto")) {
				dirigente = d;
			}
		}
		if(dirigente != null) {
			return dirigente.toString();			
		}
		return "Dirigente não encontrado";
	}

	@Override
	public String getCountryName() {
		String str = "Japao";
		return str;
	}

	@Override
	public Image getFlagImage() {
		InputStream file = Japao.class.getResourceAsStream("/Flag_of_Japan.svg.png");
		BufferedImage squir1 = null;
		try {
			squir1 = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return squir1;
	}

	@Override
	public Path getTechnicalCommittee() {
		// método precisa ser feito após dúvida com professor ser sanada
		Path path = null;
		return path;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
	Status stats = new Status();
		return stats;
	}
	

}
