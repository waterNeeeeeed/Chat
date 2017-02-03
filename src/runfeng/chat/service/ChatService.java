package runfeng.chat.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ChatService {
	private static ChatService instance;
	private static Properties userList;
	private static int instance_test = 0;
	
	public static int getInstance_test() {
		return instance_test;
	}

	public static void setInstance_test(int instance_test) {
		ChatService.instance_test = instance_test;
	}

	private ChatService(){
		
	}
	
	public static ChatService getInstance(){
		if (null == instance){
			instance = new ChatService();
			instance_test++;
		}
		
		return instance;
	}
	
	public boolean addUser(String username, String password) throws Exception{
		userList = loadUserlist();
		
		if (userList.contains(username)){
			return false;
		}
		
		userList.setProperty(username, password);
		saveUserlist();
		return true;
	}
	
	public boolean validLogin(String username, String password){
		String pass = loadUserlist().getProperty(username);
		if (pass.equals(password) && pass != null){
			return true;
		}
		return false;
	}
	
	public Properties loadUserlist(){
		try{
			File f = new File("user.properties");
			if (!f.exists()){
				f.createNewFile();
			}
			userList = new Properties();
			userList.load(new FileInputStream(f));
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public boolean saveUserlist(){
		if (null == userList){
			return false;
		}
		
		try {
			File f = new File("user.properties");
			userList.store(new FileOutputStream(f), "user save");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
