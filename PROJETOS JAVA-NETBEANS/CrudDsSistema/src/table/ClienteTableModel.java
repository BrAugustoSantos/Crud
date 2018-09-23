
package table;

import javax.swing.table.AbstractTableModel;
import model.Cliente;
import java.util.ArrayList;


public class ClienteTableModel extends AbstractTableModel{

    public static final int  COL_CODIGO_CLIENTE=0;
       public static final int  COL_NOME=1;
         public static final int  COL_IDADE=2;
                   public static final int  COL_RG=3;
                   
 public static final int  COL_CODIGO_ENDERECO=4;
 public static final int  COL_RUA=5;
 public static final int  COL_CIDADE=6;
 public static final int  COL_BAIRRO=7; 
 public static final int  COL_NUMERO=8;
public static final int  COL_ID_CLIENTE=9;
 
 public ArrayList<Cliente> lista;
   
 public ClienteTableModel(ArrayList<Cliente>l){
 
 lista=new ArrayList<Cliente>(l);
 }
 
 
                   
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 10;
    }

    // PEGANDO OS DADOS DA TABELA
    @Override
    public Object getValueAt(int linhas, int colunas) {
      
        Cliente cliente= lista.get(linhas);
        if(colunas==COL_CODIGO_CLIENTE)return cliente.getIdCliente();
         if(colunas==COL_NOME)return cliente.getNome();
          if(colunas==COL_IDADE)return cliente.getIdade();
           if(colunas==COL_RG)return cliente.getRg();
           
           
           if(colunas==COL_CODIGO_ENDERECO)return cliente.getIdendereco();
           if(colunas==COL_RUA)return cliente.getRua();
           if(colunas==COL_CIDADE)return cliente.getCidade();
           if(colunas==COL_BAIRRO)return cliente.getBairro();
           if(colunas==COL_NUMERO)return cliente.getNumero();
           if(colunas==COL_ID_CLIENTE)return cliente.getIdCliente();
                     
           return "";
    }
       
    @Override

    //NOMES DAS COLUNAS
    
    public String getColumnName(int colunas){
    
          if(colunas==COL_CODIGO_CLIENTE)return "IdCLiente";
         if(colunas==COL_NOME)return "Nome";
          if(colunas==COL_IDADE)return "Idade";
           if(colunas==COL_RG)return "Rg";
        
            if(colunas==COL_CODIGO_ENDERECO)return "IdEndereco";
             if(colunas==COL_RUA)return "Rua";
              if(colunas==COL_CIDADE)return "Cidade";
               if(colunas==COL_BAIRRO)return "Bairro";
                if(colunas==COL_NUMERO)return "Numero";
                 if(colunas==COL_ID_CLIENTE)return "Id_CLiente";
        return "";
                      
                 
    }
    
    
}
