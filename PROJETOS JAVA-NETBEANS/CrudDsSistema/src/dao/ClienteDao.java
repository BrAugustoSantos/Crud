
package dao;

import  java.sql.Connection;
import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDao {

private Connection conn;
private PreparedStatement stmt;
private Statement st;
private ResultSet rs;
private ArrayList<Cliente>lista=new ArrayList<Cliente>();



public ClienteDao() throws SQLException{

    conn=new ConnectionFactory().getConexao();
    
}
//INSERIR DADOS DO CLIENTE

    public void inserir(Cliente cliente){
        
    String sql="INSERT INTO cliente (Nome,Idade,Rg) VALUES(?,?,?)";
    String sqll="select LAST_INSERT_ID()";
    String mysql="INSERT INTO endereco (Rua,Cidade,Bairro,Numero) VALUES(?,?,?,?)";
    
         try{   stmt=conn.prepareStatement(sql);
         stmt.setString(1,cliente.getNome());
         stmt.setInt(2,cliente.getIdade());
         stmt.setInt(3,cliente.getRg());
       stmt.execute();
          
       stmt=conn.prepareStatement(sqll);
       stmt.execute();
       
       stmt=conn.prepareStatement(mysql);
         
         stmt.setString(1,cliente.getRua());
         stmt.setString(2,cliente.getCidade());
         stmt.setString(3,cliente.getBairro());
         stmt.setInt(4,cliente.getNumero());
     
         stmt.execute();
         stmt.close();
      
    }catch(SQLException erro){
    
    throw new RuntimeException("erro 2:" +erro);
    }                 
       

        
         
    }

    
public void excluir (int IdCliente) throws SQLException{
        
    String sql ="DELETE FROM cliente  WHERE IdCliente="+IdCliente;
   
       
              st=conn.prepareStatement(sql);
       st.execute(sql);
       st.close();
         

 
  
         
} 

// Select Para Unir as Duas tabelas, Cliente+ Endereço
    
    public ArrayList<Cliente>ListarTodos()throws SQLException {
    
    String sql="select*from cliente as C inner join endereco as E on (IdCliente=Idendereco);";
    
                 
       st=conn.createStatement();
       rs=st.executeQuery(sql);
      
       while(rs.next()){
           Cliente cliente =new Cliente();
           cliente.setIdCliente(rs.getInt("IdCliente"));
           cliente.setNome(rs.getString("Nome"));
           cliente.setIdade(rs.getInt("Idade"));
           cliente.setRg(rs.getInt("Rg"));
           
           cliente.setIdendereco(rs.getInt("Idendereco"));
           cliente.setRua(rs.getString("Rua"));
           cliente.setCidade(rs.getString("Cidade"));
           cliente.setBairro(rs.getString("Bairro"));
           cliente.setNumero(rs.getInt("Numero"));
           cliente.setId_Cliente(rs.getInt("Id_Cliente"));
           lista.add(cliente);
    
           
           
       
       }
    return lista;   

    }
    
    
    



   
   




































