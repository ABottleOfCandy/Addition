package sakura.bw.addon.mysql;


import sakura.bw.addon.configuration.config_mysql;
import sakura.bw.addon.main;
import sakura.bw.addon.usages.WarningMessages;

import java.sql.*;

public class Mysql_usages {
    
    private String connectmode = "simple";
    private main plugin = main.getInstance();
    private WarningMessages wm = new WarningMessages();
    
    private String username = null;
    private String password = null;
    private String address = null;
    
    private Connection connection;
    private Statement statement;
    private Boolean state = false
            ;
    
    public void init(){
        config_mysql cm = new config_mysql();
        address = cm.getaddress();
        username = cm.getusername();
        password = cm.getPassword();
    }
    
    public void setconnectmode(String mode){
        if (mode.equalsIgnoreCase("simple")){
            connectmode = "simple";
        }else {
            plugin.getLogger().warning("ERROR");
        }
    }
    public void connect(){
        this.init();
        if (connectmode.equalsIgnoreCase("simple")){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                        
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            
            try{
                connection = DriverManager.getConnection(address,username,password);
                statement = connection.createStatement();
                state = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public Boolean search(String form,String keywords,String value){
        Boolean whetherftr = false;
        if (state == true){
            try {
                ResultSet resultset = statement.executeQuery("SELECT * FROM"+ form);
                while(resultset.next()){
                    if (resultset.getString(keywords).equals(value)){
                        whetherftr = true;
                    }
                }

                if (whetherftr == true){
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            plugin.getLogger().warning(wm.Mysql_NotConnected());
        }
        return false;
    }



    public void insert(String form,String keyword,String input){
        if (state == true){
            plugin.getLogger().warning("此功能暂时无法使用");
//            String query = "INSERT";
        }else {
            plugin.getLogger().warning(wm.Mysql_NotConnected());
        }
    }
}
