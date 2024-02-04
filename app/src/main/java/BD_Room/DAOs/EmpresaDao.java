package BD_Room.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import BD_Room.Entidates.Departamento;
import BD_Room.Entidates.Empresa;


@Dao
public interface EmpresaDao {

    @Insert
    void insertarEmpresa(Empresa empresa);

    @Query("SELECT * FROM Empresa")
    List<Empresa> obtenerEmpresas();

    @Query("SELECT * FROM Empresa JOIN Ciudad ON Empresa.codCiudad = Ciudad.codCiudad WHERE Ciudad.nomCiudad = 'C_Eibar'")
    List<Empresa> seleccionarEmpresaPorCiudad();





//Querys complejas extra (para examen):

}
