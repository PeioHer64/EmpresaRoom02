package BD_Room.Entidates;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "ciudad")
public class Ciudad {


    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "codCiudad")
    public int codCiudad;
    @ColumnInfo(name = "nomCiudad")
    public String nomCiudad ;
    @ColumnInfo(name = "provincia")
    public String provincia;
    @ColumnInfo(name = "capital")
    public boolean capital;


    public Ciudad(int codCiudad, String nomCiudad, String provincia, boolean capital) {
        this.codCiudad = codCiudad;
        this.nomCiudad = nomCiudad;
        this.provincia = provincia;
        this.capital = capital;
    }
}
