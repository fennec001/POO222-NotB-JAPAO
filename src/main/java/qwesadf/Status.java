package qwesadf;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.json.JSONObject;


public class Status implements NationalTeamStats {


     

    
    public int getHowManyQuestions() {


        try (FileWriter fw = new FileWriter("ArqTextoEx123erc1.txt")){
			fw.write("12345");
		 
		// ler os arquivos como texto
		FileReader fr = new FileReader("ArqTextoExerc1.txt");
		BufferedReader br = new BufferedReader(fr);
		br.toString();
        br.readLine();
        String aux = "";
        String line;
     
        while ((line = br.readLine()) != null) {
           aux += line;
        }
		br.close(); 
        
        
        JSONObject jsonObject = new JSONObject(aux);
return jsonObject.getInt("getHowManyQuestions:");}

        
        
       



        
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
    return 1;}
        
           
      


    
    
    
    
    @Override
    public  String getHowManyCallsToPlayer (int number) {
        // TODO Auto-generated method stub
        return "asd";    }

}
