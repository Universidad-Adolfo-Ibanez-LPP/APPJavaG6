package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.BookNotFoundException;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.ui.utils.*;
import org.apache.commons.text.CaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
*
* Dado que solo necesitare una instancia de esta clase
* la convierto en SIngleton https://refactoring.guru/design-patterns/singleton
*
 */
public class DataManager {

    //private List<Libro> data;
    private HashSet<Libro> data;

    private HashSet<String> sedeTEMP;
    private HashSet<Integer> pisoTEMP;
    private HashSet<String> seccionTEMP;

    private static DataManager instance;

    // todos los singletons
    // tienen constructores privados
    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
            SearchManager.getInstance();
        }
        return instance;
    }

    //public List<Libro> getData() {return data;}
    public HashSet<Libro> getData() {return data;}

    public Map<String, Set<Libro>> getPeopleByColum(Tittles columName) {
        // ahora instancio un mapa con esas claves
        Map<String, Set<Libro>> resultados = new HashMap<>();
        for (Libro p : this.data) {
            // primero debo saber que atributo
            // es para saber a que get llamare
            // esto se denomina llamar
            // a metodos por reflexion
            Class<?> classObj = p.getClass();
            Method printMessage = null;
            try {
                String camelCase = CaseUtils.toCamelCase(columName.getVal(), true);
                printMessage = classObj.getDeclaredMethod("get" + camelCase);
                String filterName = String.valueOf(printMessage.invoke(p));
                Set<Libro> ciudadanos = resultados.get(filterName);
                // Significa que debo crear si es true
                if (AppUtils.isNull(ciudadanos)) {
                    // uso un set para evitar repetidos
                    ciudadanos = new HashSet<Libro>();
                }
                ciudadanos.add(p);
                resultados.put(filterName, ciudadanos);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return resultados;
    }

  //  public void setData(List<Libro> data) {this.data = data;}
    public void setData(HashSet<Libro> data) {
      this.data = data;
  }

    //public void setDatatemp(List<Libro> dataa){
    public void setDatatemp(HashSet<Libro> dataa){
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        HashSet<Integer> set3 = new HashSet<Integer>();
        for (Libro p : dataa){

            String Newsede=p.getSede();
            int Newpiso=p.getPiso();
            String Newseccion=p.getEstante_seccion();

            set1.add(Newsede);
            set2.add(Newseccion);
            set3.add(Newpiso);
        }
        this.sedeTEMP=set1;
        this.seccionTEMP=set2;
        this.pisoTEMP=set3;

    }

    public String getDataAsString() throws DataNotLoadedException {
        // verifico que la data exista y sino devuelvo excepcion
        if (AppUtils.isNull(data)) {
            throw new DataNotLoadedException();
        }
        // Creo un string para ir sumando ahi la data
        StringBuilder sb = new StringBuilder(data.size() * 50);
        for (Libro p : data) {
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getTitulos() {
        String aux=null;
        StringBuilder sb= new StringBuilder(data.size() * 50);
        for (Libro s : data) {
            aux = s.getTitulo();
            sb.append(aux);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getSedeTEMP() {
        String aux=null;
        StringBuilder sb= new StringBuilder(sedeTEMP.size() * 50);
        for (String element :this.sedeTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getPisoTEMP() {
        Integer aux=null;
        StringBuilder sb= new StringBuilder(sedeTEMP.size() * 50);
        for (String element :this.sedeTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getSeccionTEMP() {
        String aux=null;
        StringBuilder sb= new StringBuilder(seccionTEMP.size() * 50);
        for (String element :this.seccionTEMP){
            sb.append(element);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void agregarLibro(Libro p) {
        this.data.add(p);
    }

    public void agregarSede(Libro p) {
        this.sedeTEMP.add(p.getSede());
        }

    public Integer removerLibro(Libro p) {
        Libro index = null;
        Integer num = 0;
        for (Libro s : data) {
            if (s.compareTo(p) == 0) {
                index = s;
                num = 1;
            }
        }

        this.data.remove(index);
        return num;
    }


    public void removerLibros(Collection<Libro> libros) {
        this.data.removeAll(libros);
    }

    public Libro buscarLibro(Libro titulo) throws BookNotFoundException {


        for (Libro s : data) {
            if (s.compareTo(titulo) == 0) {
                return s;
            }
        }
        throw new BookNotFoundException();
    }

   public void overwrite(Libro origin,Libro nuevo) {
       removerLibro(origin);
       agregarLibro(nuevo);
       System.out.println("Se han realizado los cambios");
    }
}
