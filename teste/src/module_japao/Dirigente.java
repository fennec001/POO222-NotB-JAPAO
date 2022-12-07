package module_japao;

public class Dirigente {
	private String name;
	private String tel1;
	private String tel2;
	private String emailAccount;

	public Dirigente(String name, String tel1, String tel2, String emailAccount) {
		this.setName(name);
		this.setTel1(tel1);
		this.setTel2(tel2);
		this.setEmailAccount(emailAccount);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getEmailAccount() {
		return emailAccount;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}

	public String descreva() {
		String aux = "";
		aux += getName() + " " + getTel1() + " " + getTel2() + " " + getEmailAccount();

		return aux;
	}

}
