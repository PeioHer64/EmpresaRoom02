package BD_Room.Entidates;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//poner lo de foreng key como en la imagen/cod de S




@Entity(tableName = "departamento", indices = {@Index(value="nomDepartamento", unique = true)},
        foreignKeys = @ForeignKey(
                entity = Empresa.class,
                parentColumns = "codEmpresa", // Este es el nombre de Empresa
                childColumns = "codEmpresa", // Este es el nombre de esta clase
                onDelete = ForeignKey.CASCADE))




public class Departamento {


    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "codDepartamento")
    public String codDepartamento;
    @ColumnInfo(name = "nomDepartamento")
    public String nomDepartamento;
    @ColumnInfo(name = "presupuesto")
    public float presupuesto;
    @ColumnInfo(name = "codEmpresa")
    public int codEmpresa;
    @ColumnInfo(name = "codDepartamentoJefe")
    public String codDepartamentoJefe;


    public Departamento(String codDepartamento,String nomDepartamento, float presupuesto, int codEmpresa, String codDepartamentoJefe) {
        this.codDepartamento = codDepartamento;
        this.nomDepartamento = nomDepartamento;
        this.presupuesto = presupuesto;
        this.codEmpresa = codEmpresa;
        this.codDepartamentoJefe = codDepartamentoJefe;
    }
}
