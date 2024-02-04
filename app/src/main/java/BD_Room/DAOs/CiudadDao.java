package BD_Room.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import BD_Room.Entidates.Ciudad;



@Dao
public interface CiudadDao {

    @Insert
    void insertarCiudad(Ciudad ciudad);

    @Query("SELECT * FROM Ciudad")
    List<Ciudad> obtenerCiudades();

    @Query("UPDATE Ciudad SET nomCiudad = 'BilbaoOo' WHERE provincia = 'Bizkaia'")
    void actualizarCiudad();



//Querys complejas extra (para examen):


}
