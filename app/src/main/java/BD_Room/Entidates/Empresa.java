package BD_Room.Entidates;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "empresa",
        foreignKeys = @ForeignKey(entity = Ciudad.class,
                parentColumns = "codCiudad", //nombre del atributo de la foreing key de Ciudad
                childColumns = "codCiudad", //atributo de esta clase donde tenemos dela Foreing key
                onDelete = ForeignKey.CASCADE)) //si eleiminamos una Ciudad se eliminara en cascada la empresa


public class Empresa {

    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "codEmpresa")
    public int codEmpresa;
    @ColumnInfo(name = "nomEmpresa")
    public String nomEmpresa;
    @ColumnInfo(name = "direccion")
    public String direccion;
    @ColumnInfo(name = "presupuesto")
    public float presupuesto;
    @ColumnInfo(name = "codCiudad")
    public int codCiudad;


    public Empresa(int codEmpresa,String nomEmpresa, String direccion, float presupuesto, int codCiudad) {
        this.codEmpresa = codEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
        this.codCiudad = codCiudad;
    }
}
