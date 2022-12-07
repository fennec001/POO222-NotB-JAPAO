package module_japao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

import org.json.JSONArray;
import org.json.JSONObject;

public class Japao implements NationalTeamInfos {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<MembroComiteTecnico> comite = new ArrayList<MembroComiteTecnico>();
	private ArrayList<Dirigente> dirigentes = new ArrayList<Dirigente>();
	private ArrayList<Integer> calls = new ArrayList<Integer>();
	private Status status = new Status();
	private int howManyQuestions;

	public int getHowManyQuestions() {
		return howManyQuestions;
	}

	public void incHowManyQuestions() {
		howManyQuestions++;
	}

	// como o caminho relativo do arquivo do jar
	public Japao() {
		InputStream file = Japao.class.getResourceAsStream("/playerInfo.json");

		try {
			String contents = new String(file.readAllBytes());
			JSONObject o = new JSONObject(contents);
			parsePlayer(o);
			parseComite(o);
			parsePressOfficer(o);
			file.close();
			setCalltoPlayer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// criar um json com duas estruturas
	// uma de totalperguntas e uma o
	private void parsePlayer(JSONObject o) {
		JSONArray players = o.getJSONArray("players");
		for (int i = 0; i < players.length(); i++) {

			JSONObject p = players.getJSONObject(i);
			int number = p.getInt("number");
			String currentClub = (String) p.get("currentClub");
			String name = (String) p.get("name");
			String nickname = (String) p.get("nickname");
			float weight = p.getFloat("weight");
			String position = (String) p.get("position");
			DateTimeFormatter df = DateTimeFormatter.ofPattern("y-M-d");
			LocalDate birthdate = LocalDate.parse((String) p.get("birthDate"), df);
			float height = p.getFloat("height");

			Jogador j = new Jogador(number, name, nickname, height, weight, birthdate, position, currentClub);
			jogadores.add(j);
		}
	}

	private void parseComite(JSONObject o) {
		JSONArray committee = o.getJSONArray("committee");
		for (int i = 0; i < committee.length(); i++) {
			JSONObject p = committee.getJSONObject(i);
			String name = p.getString("name");
			String nickname = p.getString("nickname");
			String role = p.getString("role");
			int age = p.getInt("age");
			MembroComiteTecnico c = new MembroComiteTecnico(name, nickname, role, age);
			comite.add(c);
		}
	}

	private void parsePressOfficer(JSONObject o) {
		JSONArray pressOfficer = o.getJSONArray("pressOfficer");
		for (int i = 0; i < pressOfficer.length(); i++) {
			JSONObject p = pressOfficer.getJSONObject(i);
			String name = p.getString("name");
			String tel1 = p.getString("tel1");
			String tel2 = p.getString("tel2");
			String emailAccount = p.getString("emailAccount");
			Dirigente d = new Dirigente(name, tel1, tel2, emailAccount);
			dirigentes.add(d);
		}
	}

	@Override
	public int getHowManyMembers() {
		// TODO Auto-generated method stub
		incHowManyQuestions();
		return dirigentes.size() + comite.size() + jogadores.size();
	}

	@Override
	public int getOldestPlayer() {
		Jogador oldestPlayer = jogadores.get(0);
		for (Jogador p : jogadores) {
			if (p.getAge() > oldestPlayer.getAge()) {
				oldestPlayer = p;
			}
		}
		incHowManyQuestions();
		return oldestPlayer.getNumber();
	}

	@Override
	public int getYoungestPlayer() {
		Jogador youngestPlayer = jogadores.get(0);
		for (Jogador p : jogadores) {
			if (p.getAge() < youngestPlayer.getAge()) {
				youngestPlayer = p;
			}
		}
		incHowManyQuestions();
		return youngestPlayer.getNumber();
	}

	@Override
	public double getAverageAge() {
		double totalAge = 0;
		for (Jogador p : jogadores) {
			totalAge += p.getAge();
		}
		incHowManyQuestions();
		return totalAge / jogadores.size();
	}

	@Override
	public String getPlayer(int number) {
		Jogador selecionado = null;
		for (Jogador p : jogadores) {
			if (p.getNumber() == number) {
				selecionado = p;
				p.incHowManyCalls();
			}
		}
		if (selecionado != null) {
			JSONObject jsonObject = new JSONObject(selecionado);
			String myJson = jsonObject.toString();
			incHowManyQuestions();
			return myJson;
		}
		incHowManyQuestions();
		return "Jogador não encontrado";
	}

	@Override
	public String getPressOfficerContacts() {
		Dirigente dirigente = null;
		String aux = "";
		for (Dirigente d : dirigentes) {

			if (d.getName().equals("Naruto") || d.getName().equals("Sasuke")) {
				dirigente = d;

				JSONObject jsonObject = new JSONObject(dirigente);
				String myJson = jsonObject.toString();

				aux += myJson;
				aux += "\n";
			}

		}
		if (dirigente != null) {
			incHowManyQuestions();
			return aux;
		}
		incHowManyQuestions();
		return "Dirigente não encontrado";
	}

	@Override
	public String getCountryName() {
		String str = "Japao";
		incHowManyQuestions();
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
		incHowManyQuestions();
		return squir1;
	}

	public String teste() {
		String aux = "";
		MembroComiteTecnico membro = null;
		for (MembroComiteTecnico m : comite) {
			membro = m;
			JSONObject jsonObject = new JSONObject(membro);
			String myJson = jsonObject.toString();

			aux += myJson;
			aux += "\n";
		}

		return aux;
	}

	@Override
	public Path getTechnicalCommittee() {
		File file = new File("comiteTecnico.txt");
		try {
			FileWriter fw = new FileWriter(file);
			MembroComiteTecnico tecnico = null;

			for (MembroComiteTecnico m : comite) {
				if (m.getName() != null) {
					tecnico = m;
					JSONObject jsonObject = new JSONObject(tecnico);
					String myJson = jsonObject.toString();
					fw.append(myJson);
					fw.append("\n");

				}
			}
			fw.close();
			fw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Path path = Paths.get(file.getAbsolutePath());
		incHowManyQuestions();
		return path;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		Status stats = new Status();
		incHowManyQuestions();
		return stats;
	}

	public void parseQuestions() {
		JSONObject objeto = new JSONObject();

		File file = new File(".//json//playerStatus.json");

		try {
			FileWriter fw = new FileWriter(file);
			fw.append("{\n" + '"' + "stats" + '"' + ":[\n");
			JSONObject json = new JSONObject();
			json.put("HowManyQuestions", getHowManyQuestions());
			fw.append(json.toString());
			fw.append(" ],\n" + '"' + "jogadores" + '"' + ":[\n");

			for (int i = 0; i < jogadores.size(); i++) {
				Jogador j = jogadores.get(i);
				json = new JSONObject();
				json.put("camisa", j.getNumber());
				json.put("calls", j.getHowManyCalls());
				if (i == (jogadores.size() - 1)) {
					fw.append(json.toString());
				} else {
					fw.append(json.toString() + ",");
				}
			}
			fw.append("] \n }");
			fw.close();

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(file.toString());

	}

	public void setCalltoPlayer() throws FileNotFoundException {
		InputStream arquivo = new FileInputStream("./json/playerInfo.json");
		try {
			String contents = new String(arquivo.readAllBytes());
			JSONObject o = new JSONObject(contents);
			JSONArray players = o.getJSONArray("jogadores");
			for (int i = 0; i < players.length(); i++) {
				JSONObject p = players.getJSONObject(i);
				jogadores.get(i).setHowManyCalls(p.getInt("calls"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}