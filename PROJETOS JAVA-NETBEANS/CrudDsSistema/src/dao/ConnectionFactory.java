
//CONEXAO COM BANCO DE DADOS

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

    
        public Connection getConexao() throws SQLException{
      
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/cruddssistema","root","1234" );
        
      
        }
    
    
    
}
