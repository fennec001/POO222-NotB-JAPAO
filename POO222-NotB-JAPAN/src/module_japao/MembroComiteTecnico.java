package module_japao;

public class MembroComiteTecnico {
	private String name;
	private String nickname;
	private String role;
	private int age;
	
	public MembroComiteTecnico(String name, String nickname, String role, int age) {
		this.setName(nickname);
		this.setNickname(nickname);;
		this.setRole(role);
		this.setAge(age);
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
