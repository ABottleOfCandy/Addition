package sakura.bw.addon.mysql;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import sakura.bw.addon.configuration.config_mysql;
import sakura.bw.addon.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Connect {
    private main plugin = main.getInstance();
    private String addr = null;
    private String username = null;
    private String password = null;
    private String connectmode = "simple";


    private Connection connection;
    private Statement statement;

    public void init(){
        config_mysql cm = new config_mysql();
        addr = cm.getaddress();
        username = cm.getusername();
        password = cm.getPassword();

    }

    public void setconnectmode(String mode){

        if (mode.equalsIgnoreCase("simple")){
            plugin.getLogger().info("Tht mode has changed successfully");
            connectmode = "simple";
        }else {
            plugin.getLogger().warning("ERROR exception mode please change");
        }
    }

    @Deprecated
    public void connecttoserver(){

        this.init();

        if (connectmode.equalsIgnoreCase("simple")){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                connection = (Connection) DriverManager.getConnection(addr,username,password);
                statement = connection.createStatement();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
