package module_japao;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Japao japao = new Japao();
		JFrame frame = new JFrame();
		
		japao.getOldestPlayer();
		japao.getYoungestPlayer();
		japao.getAverageAge();
		japao.getPlayer(1);
		japao.getHowManyMembers();
		japao.getTechnicalCommittee();
		Image img = japao.getFlagImage();
		ImageIcon imgIcon  = new ImageIcon(img);
		JLabel lbl = new JLabel();
		lbl.setIcon(imgIcon);
		frame.getContentPane().add(lbl);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
