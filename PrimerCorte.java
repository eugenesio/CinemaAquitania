package primer.corte;
import java.util.Scanner;//para poder usar scanners
//import java.awt.Robot;
public class PrimerCorte {
    public static void main(String[] args) 
    {
    	int opcion;//variable de menu
    	int sillas[][]= new int [4][10];//matriz de tamaño especifico
        Limpiar(sillas);//llama al metodo que iguala matriz a cero
    	Scanner lector = new Scanner(System.in);//scanner llamado lector tipo entradas para opciones
	System.out.println("\nControl de sillas sala de cine Aquitania");
        do{//ejecute lo que sigue mientras que (algo que se define abajo)
            System.out.println("\n1. Limpiar sala");
            System.out.println("2. Crear una reserva");
            System.out.println("3. Cancelar una reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = lector.nextInt();//igualo la variable opcion a lo que captura el lector
		switch (opcion)//ejecuta la opcion que corresponda al valor capturado en opcion
                {
		case 0:
                    break;
		case 1:
                    Limpiar(sillas);//ejecuta un metodo
                    break;//devuelve al do while (mientras que)
		case 2:
                    Asignar(sillas);
                    break;
                case 3:
                    Liberar(sillas);
                    break;
 		default:
                    System.out.println("\n¡¡¡Opcion no valida!!!\n");
                    break;
		}
           // keyRelease event (Ctrl+L);
	}
        while(opcion!=0);//ejecute lo que incluye el do mientras opcion no sea cero
    }
    public static void Limpiar(int sillas[][]){//iguala  matriz a cero en cualquier momento
    	for (int i=0;i<4;i++){
    		for (int j=0;j<10;j++){
                    sillas[i][j]=0;//aca asigna 0 a cada posicion 
    		}
    	}
        Mostrar(sillas);
    }
    public static void Mostrar(int sillas[][]){//imprime la matriz en cualquier momento
        System.out.println("\n******PANTALLA******");
    	for (int i=0;i<4;i++){
            for (int j=0;j<10;j++){
    		System.out.print(sillas[i][j]+" ");
            }
            System.out.print("\n");
    	}
        int suma=0;
        for (int i=0;i<4;i++){
            for (int j=0;j<10;j++){
    		suma=suma+sillas[i][j];//cuenta la cantida de reservas
            }
        }
        int resto =(4*10)-suma;//cuenta la cantida de sillas libres
        System.out.print("-------------------------");
        System.out.print("\nHan reservado ");
        System.out.print(suma+" sillas\n");
        System.out.print("Quedan ");
        System.out.print(resto+" sillas libres\n");
        System.out.print("-------------------------");
    }
    public static void Asignar(int sillas[][]){//asigna valor en posicion deseada
    	int f,c;//variables fila y columna
        Scanner leasilla = new Scanner(System.in);//creo un scanner llamado leasilla
    	System.out.print("Elija Numero de Fila [1-4]:\n");
    	f = leasilla.nextInt();//igualo f al valor capturado por scanner
    	System.out.print("Elija Numero de Columna [1-10]:\n");
    	c = leasilla.nextInt();//igualo c al valor capturado por scanner
    	if(sillas[f-1][c-1]==0){//si la posicion es igual a cero
            sillas[f-1][c-1]=1;//iguale a 1
        }
        else{
            System.out.println("\n¡¡¡¡¡Silla ocupada!!!!\n");//
            }
    	Mostrar(sillas);
    }
     public static void Liberar(int sillas[][]){//asigna valor en posicion deseada
    	int f,c;//variables fila y columna
        Scanner leasilla = new Scanner(System.in);//creo un scanner llamado leasilla
    	System.out.print("Elija Numero de Fila que desea cancelar [1-4]:\n");
    	f = leasilla.nextInt();//igualo f al valor capturado por scanner
    	System.out.print("Elija Numero de Columna que desea cancelar [1-10]:\n");
    	c = leasilla.nextInt();//igualo c al valor capturado por scanner
    	if(sillas[f-1][c-1]==1){
        sillas[f-1][c-1]=0;//iguale a 1
        System.out.println("\nReserva cancelada\n");//
        }
        else{
            System.out.println("\nSilla esta vacia\n");//
        }
        Mostrar(sillas);
     }
}
