package com.example.empresaroom02.Activitiies;





import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.empresaroom02.R;

import java.util.List;

import BD_Room.EmpressaDataBase;
import BD_Room.DAOs.DepartamentoDao;
import BD_Room.DAOs.CiudadDao;
import BD_Room.DAOs.EmpresaDao;
import BD_Room.Entidates.Ciudad;
import BD_Room.Entidates.Departamento;
import BD_Room.Entidates.Empresa;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView etThingBD = findViewById(R.id.editTextTextThingBD);
        Button btnBDAction = findViewById(R.id.buttonBDAction);

        Button btnSharedPP = findViewById(R.id.buttonSHaredPP);


        //hacer un metodo estatic para crear/obtener(di ya esta creada) la database como en la imagen (mira el codigo de S aparte de la imagen)
        //Cración de BD
//        AppDatabase db = Room.databaseBuilder(
//                        getApplicationContext(),
//                        AppDatabase.class,
//                        "db_empresa2.1")
//                .allowMainThreadQueries().build();
//
//
//
//
//
//
//        CiudadDao ciudadDao = db.ciudadDao();
//        EmpresaDao empresaDao = db.empresaDao();
//        DepartamentoDao departamentoDao = db.departamentoDao();







        btnSharedPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit(); // Create an editor to modify preferences
                editor.putString("keyName", "Hello, SharedPreferences!"); // Save a String value with a key
                editor.apply(); // Commit the changes

                String savedValue = sharedPreferences.getString("keyName", "DefaultValueIfKeyNotFound"); // Retrieve a String value with the key
                System.out.println(savedValue);

            }
        });











        //    https://developer.android.com/training/data-storage/room/accessing-data?hl=es-419#return-subset
        btnBDAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmpressaDataBase db = getDatabase(getApplicationContext());

                CiudadDao ciudadDao = db.ciudadDao();
                EmpresaDao empresaDao = db.empresaDao();
                DepartamentoDao departamentoDao = db.departamentoDao();

                db.clearAllTables();

                ciudadDao.insertarCiudad(new Ciudad(1,"C_Bilbo", "Bizkaia", true));
                ciudadDao.insertarCiudad(new Ciudad(2,"C_Eibar", "Gipuzkoa", false));
                ciudadDao.insertarCiudad(new Ciudad(3,"C_Donostia", "Gipuzkoa", true));

                empresaDao.insertarEmpresa(new Empresa(1,"E_Nagusia", "Kale Nagusia, 80", 1200000.0F, 1));
                empresaDao.insertarEmpresa(new Empresa(2,"E_Erialde", "Saratsuegi 32", 1150000.0F, 2));
                empresaDao.insertarEmpresa(new Empresa(3,"E_Hegoalde", "Carr.Alfaro, sn", 800000.0F, 3));

                departamentoDao.insertarDepartamento(new Departamento("D_BERRI","Berrikuntza", 400000.0F, 1, "KALI"));
                departamentoDao.insertarDepartamento(new Departamento("D_IK+DI","Ikerkuntza eta diseinua", 350000.0F, 2, "KALI"));
                departamentoDao.insertarDepartamento(new Departamento("D_KALI","Kalitatea", 180000.0F, 3, "BERRI"));


                System.out.println("***CIUDADES***");
                List<Ciudad> listaCiudades = ciudadDao.obtenerCiudades();
                for (Ciudad item:listaCiudades) {
                    System.out.println(item.codCiudad+ " " +item.nomCiudad + " " + item.provincia);
                }

                System.out.println("***EMPRESAS***");
                List<Empresa> listaEmpresas = empresaDao.obtenerEmpresas();
                for (Empresa item:listaEmpresas) {
                    System.out.println(item.codEmpresa+ " " +item.nomEmpresa + " " + item.presupuesto);
                }

                System.out.println("***DEPARTAMENTOS***");
                List<Departamento> listaDepartamentos = departamentoDao.obtenerDepartamentos();
                for (Departamento item:listaDepartamentos) {
                    System.out.println(item.codDepartamento+" "+item.codEmpresa+ " " +item.nomDepartamento + " " + item.presupuesto);
                }


                //PRUEBAS (delete, update, select...): C,E,D
                System.out.println("***PRUEBAS (delete, update, select...): C,E,D***");

                System.out.println("***PRUEBAS CIUDADES***");
                ciudadDao.actualizarCiudad();
                List<Ciudad> listaCiudadesP = ciudadDao.obtenerCiudades();
                for (Ciudad item:listaCiudadesP) {
                    System.out.println(item.codCiudad+ " " +item.nomCiudad + " " + item.provincia);
                }

                System.out.println("***PRUEBAS EMPRESA***");
                List<Empresa> listaEmpresasP = empresaDao.seleccionarEmpresaPorCiudad();
                for (Empresa item:listaEmpresasP) {
                    System.out.println(item.codEmpresa+ " " +item.nomEmpresa + " " + item.presupuesto);
                }

                System.out.println("***PRUEBAS DEPARTAMENTOS***");
                List<Departamento> listaDepartamentosP = departamentoDao.obtenerSubdepartamentos("KALI");
                for (Departamento item:listaDepartamentosP) {
                    System.out.println(item.codDepartamento+" "+item.codEmpresa+ " " +item.nomDepartamento + " " + item.presupuesto);
                }
                departamentoDao.eliminarDepartamento(new Departamento("D_BERRI","Berrikuntza", 400000.0F, 1, "KALI"));


                System.out.println("***DEPARTAMENTOS ONE DELETED***");
                List<Departamento> listaDepartamentosD = departamentoDao.obtenerDepartamentos();
                for (Departamento item:listaDepartamentosD) {
                    System.out.println(item.codDepartamento+" "+item.codEmpresa+ " " +item.nomDepartamento + " " + item.presupuesto);
                }


            }
        });




    /*
        db.clearAllTables();

        ciudadDao.insertarCiudad(new Ciudad("Bilbo", "Bizkaia", true));
        ciudadDao.insertarCiudad(new Ciudad("Eibar", "Gipuzkoa", false));
        ciudadDao.insertarCiudad(new Ciudad("Donostia", "Gipuzkoa", true));
        ciudadDao.insertarCiudad(new Ciudad("Tutera", "Nafarroa", false));
        ciudadDao.insertarCiudad(new Ciudad("Gazteiz", "Araba", true));

        empresaDao.insertarEmpresa(new Empresa("Nagusia", "Kale Nagusia, 80", 1200000.0F, 1));
        empresaDao.insertarEmpresa(new Empresa("Erialde", "Saratsuegi 32", 1150000.0F, 2));
        empresaDao.insertarEmpresa(new Empresa("Hegoalde", "Carr.Alfaro, s/n", 800000.0F, 4));


        departamentoDao.insertarDepartamento(new Departamento("BERRI","Berrikuntza", 400000.0F, 3, "KALI"));
        departamentoDao.insertarDepartamento(new Departamento("IK+DI","Ikerkuntza eta diseinua", 350000.0F, 3, "KALI"));
        departamentoDao.insertarDepartamento(new Departamento("KALI","Kalitatea", 180000.0F, 2, "ZUZEN"));
        departamentoDao.insertarDepartamento(new Departamento("NOMIN","Nominak", 400000.0F, 2, "RR.HH"));
        departamentoDao.insertarDepartamento(new Departamento("PRODU","Produkzioa", 240000.0F, 1, "ZUZEN"));
        departamentoDao.insertarDepartamento(new Departamento("RR.HH","Giza Baliabideak", 350000.0F, 1, "ZUZEN"));
        departamentoDao.insertarDepartamento(new Departamento("SALME","Salmentak", 380000.0F, 2, "ZUZEN"));
        departamentoDao.insertarDepartamento(new Departamento("ZUZEN","Zuzendaritza", 500000.0F, 1, ""));

*/

        //Delete
        //departamentoDao.eliminarDepartamento(new Departamento("PRODU","Produkzioa", 240000.0F, 1, "ZUZEN"));

        //ObtenerListaDepartamentos
        /*
        List<Departamento> listaDepartamentos= departamentoDao.obtenerSubdepartamentos("ZUZEN");

        for (Departamento lista:listaDepartamentos) {
            System.out.println(lista.nomDepartamento + " " + lista.codDepartamentoJefe);
        }
         */

        //Update
        //ciudadDao.actualizarCiudad();

        //ObtenerListaCiudades
        /*
        List<Ciudad> listaCiudades = ciudadDao.obtenerCiudades();

        for (Ciudad lista:listaCiudades) {
            System.out.println(lista.nomCiudad + " " + lista.provincia);
        }


        List<Empresa> listaEmpresas = empresaDao.seleccionarEmpresaPorCiudad();

        for (Empresa lista:listaEmpresas) {
            System.out.println(lista.nomEmpresa + " " + lista.codCiudad);
        }
 */



    }

    private static volatile EmpressaDataBase INSTANCE;
    public static EmpressaDataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (EmpressaDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    EmpressaDataBase.class, "empresa_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}