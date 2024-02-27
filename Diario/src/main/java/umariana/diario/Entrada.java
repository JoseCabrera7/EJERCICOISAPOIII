package umariana.diario;
//DESARROLLADORES: JOSE CABRERA - MAYK CAICEDO
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Entrada {

    ArrayList<Entrada> misEntradas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int idEntrada;
    private String descripcion;
    private Date fecha;

    public Entrada(int idEntrada, String descripcion, Date fecha) {
        this.idEntrada = idEntrada;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Entrada() {

    }

   
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void mostrarMenu() {

        boolean activo = true;

        do {
            System.out.println(" ________________________");
            System.out.println("|                        |");
            System.out.println("|     DIARIO PERSONAL    |");
            System.out.println("|________________________|");
            System.out.println("|                        |");
            System.out.println("|   1. AGREGAR ENTRADA   |");
            System.out.println("|________________________|");
            System.out.println("|                        |");
            System.out.println("|  2. CONSULTAR ENTRADA  |");
            System.out.println("|________________________|");
            System.out.println("|                        |");
            System.out.println("|  3. MODIFICAR ENTRADA  |");
            System.out.println("|________________________|");
            System.out.println("|                        |");
            System.out.println("|   4. ELIMINAR ENTRADA  |");
            System.out.println("|________________________|");
            System.out.println("|                        |");
            System.out.println("|       5. SALIR         |");
            System.out.println("|________________________|");


            int opcion = sc.nextInt();
            switch (opcion) {

                case 1:
                    agregarEntrada();
                    break;
                case 2:
                    consultarEntrada();
                    break;
                case 3:
                    modificarEntrada();
                    break;
                case 4:
                    eliminarEntrada();
                    break;
                case 5:
                    activo = false;
                    System.out.println("PROGRAMA TERMINADO");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");

            }
        } while (activo);
    }

    public void agregarEntrada() {
        int tamanoLista = misEntradas.size();
        int nuevoIdEntrada = 1; 

        if (tamanoLista > 0) {
            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
            nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }

        System.out.println("INGRESE NUEVO ID:  " + nuevoIdEntrada);

        System.out.println("INGRESE NUEVA DESCRIPCION:");
        sc.nextLine(); 
        String descripcion = sc.nextLine();

        Date fecha = new Date();
        DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("FECHA DE ENTRADA ");
        System.out.println(formateadorFechaLarga.format(fecha));
      

        Entrada nuevaEntrada = new Entrada(nuevoIdEntrada, descripcion, fecha);
        misEntradas.add(nuevaEntrada);
        System.out.println("ENTRADA CORRECTAMENTE AGREGADA");
    }

    public void consultarEntrada() {
        System.out.println("LISTA DE ENTRADAS:");
        for (Entrada entrada : misEntradas) {
            System.out.println("ID: " + entrada.getIdEntrada());
            System.out.println("DESCRIPCION: " + entrada.getDescripcion());
            System.out.println("FECHA: " + entrada.getFecha());
        }
    }

  public void eliminarEntrada() {
        System.out.println(" ID QUE DESEA ELIMINAR");
        int id = sc.nextInt();
        Iterator<Entrada> it = misEntradas.iterator();

        while (it.hasNext()) {
            Entrada e = it.next();
            if (e.getIdEntrada() == id) {
                  it.remove();
                System.out.println("ENTRADA DE ID " + id + " FUE ELIMINADO");
            } else {
                System.out.println("NO EXISTE ID");
              
            }
            
        }
    }

    public void modificarEntrada() {
    System.out.println("ID QUE DESEA MODIFICAR:");
    int id = sc.nextInt();
    sc.nextLine(); 

    Entrada entradaModificada = null;

    for (Entrada entrada : misEntradas) {
        if (entrada.getIdEntrada() == id) {
            entradaModificada = entrada;
            break;
        }
    }

    if (entradaModificada != null) {
        System.out.println("INGRESE DESCRIPCION NUEVA:");
        String nuevaDescripcion = sc.nextLine();
        entradaModificada.setDescripcion(nuevaDescripcion);
        System.out.println("DESCRIPCION ACTUALIZADA");
    } else {
        System.out.println("NO EXISTE ID INGRESADO");
         }
    }
}
