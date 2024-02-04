package BD_Room.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import BD_Room.Entidates.Ciudad;
import BD_Room.Entidates.Departamento;

@Dao
public interface DepartamentoDao {


    @Insert
    void insertarDepartamento(Departamento departamento);

    @Query("SELECT * FROM Departamento")
    List<Departamento> obtenerDepartamentos();

    @Query("SELECT * FROM Departamento WHERE codDepartamentoJefe = :codDepartamentoJefeE")
    List<Departamento> obtenerSubdepartamentos(String codDepartamentoJefeE);

    @Delete
    void eliminarDepartamento(Departamento departamento);



//Querys complejas extra (para examen):




}
