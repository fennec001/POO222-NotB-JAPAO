package module_japao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import fifa.NationalTeamStats;

public class Status implements NationalTeamStats {

	@Override
	public int getHowManyQuestions() {
		InputStream arquivo;
		try {
			arquivo = new FileInputStream("./json/playerStatus.json");
			String contents = new String(arquivo.readAllBytes());
			JSONObject o = new JSONObject(contents);
			JSONArray players = o.getJSONArray("stats");
			JSONObject p = players.getJSONObject(0);
			return p.getInt("HowManyQuestions");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getHowManyCallsToPlayer(int number) {
		InputStream arquivo;
		try {
			arquivo = new FileInputStream("./json/playerStatus.json");
			String contents = new String(arquivo.readAllBytes());
			JSONObject o = new JSONObject(contents);
			JSONArray players = o.getJSONArray("jogadores");
			for (int i = 0; i < players.length(); i++) {
				JSONObject p = players.getJSONObject(i);
				if (p.getInt("camisa") == number) {
					return p.getInt("calls");
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
