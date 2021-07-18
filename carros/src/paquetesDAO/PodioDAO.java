package paquetesDAO;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.ConnectionPoolDataSource;

import granTurismo.Podio;

    

public class PodioDAO {
    
    private PreparedStatement pst; 

    public boolean PodioDAO(Podio podio){

        boolean satate= false;
        Connection connect  = null;
        try{
            connect= ConnectionPool.getInstance().getConnection();
            if(connect!=null){
                String sql = "INSERT INTO podio(nombre_primero, nombre_segundo,nombre_tercero) VALUES (?,?,?)";
                pst = connect.prepareStatement(sql);
                pst.setString(1, podio.getPrimero() );
                pst.setString(2, podio.getSegundo());
                pst.setString(3, podio.getTercero());

                int res= pst.executeUpdate();
                if(res > 0){
                    satate=true;
                } 

            }else{
                System.out.println("conexion fallida");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ConnectionPool.getInstance().closeConnection(connect);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        return satate;

    }
    
}
