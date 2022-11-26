package module_japao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Jogador {
	private int number;
	private String name;
	private String nickname;
	private float height;
	private float weight;
	private LocalDate birthDate;
	private String position;
	private String currentClub;
	
	public Jogador(int number, String name, String nickname, float height, float weight, LocalDate birthDate,
			String position, String currentClub) {
		this.setNumber(number);;
		this.setName(name);
		this.setNickname(nickname);
		this.setHeight(height);
		this.setWeight(weight);
		this.setBirthDate(birthDate);
		this.setPosition(position);
		this.setCurrentClub(currentClub);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCurrentClub() {
		return currentClub;
	}
	public void setCurrentClub(String currentClub) {
		this.currentClub = currentClub;
	}
	public int  getAge() {
		int age = (int) ChronoUnit.YEARS.between( 
			    this.getBirthDate() ,
			    LocalDate.now() 
			);
		return age;
	}
	
}
