package BD_Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import BD_Room.DAOs.CiudadDao;
import BD_Room.DAOs.DepartamentoDao;
import BD_Room.DAOs.EmpresaDao;
import BD_Room.Entidates.Ciudad;
import BD_Room.Entidates.Departamento;
import BD_Room.Entidates.Empresa;

@Database(
        entities = {Departamento.class, Empresa.class, Ciudad.class},
        version = 4
)
public abstract class EmpressaDataBase extends RoomDatabase {


    public abstract DepartamentoDao departamentoDao();
    public abstract EmpresaDao empresaDao();
    public abstract CiudadDao ciudadDao();






}
