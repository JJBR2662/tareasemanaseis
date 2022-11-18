package ejercicios.matrices.y.arreglos;

import java.util.Scanner;

public class EjerciciosMatricesYArreglos {

    public static void main(String[] args) {
        Scanner mainn = new Scanner(System.in);
        String[] acumxa = new String[30];
        String[] acumxb = new String[30];
        int cont1 = 0;
        int cont2 = 0;
        int turnob = 0;
        int turnoa =0;
        String coorda="";
        String coordb="";
        System.out.println("SEAN BIENVENIDOS A BATTLESHIP");
        do{
            acumxb[turnob]=coordb;
            // esto es un array que almacena las coordenadas dichas por el usuario dependiendo al turno.
            tablerob(coordb, acumxb);
            //aqui se manda a la maquina al metodo donde se genera, llena y muestra el tablero B para el jugador 1
            for (int i = 0; i < acumxb.length; i++) {
                System.out.print(acumxb[i]+" ");
            }
            System.out.println();
            // aqui creo un array que va agarrando las coordenadas puestas por el usuario.
            System.out.print("Jugador 1 ingrese la coordenada que desea bombardear: ");
            coordb = mainn.nextLine();
            cont1 = HabradadoB(coordb,cont1);
            //aqui lo mando al metodo que verifica si le dio a un barco o no.
            turnob++;
            //sumo el turno para que vaya cambiando la posicion del array acumxb.
            System.out.println(cont1+"cont1");
            
            //literalmente lo mismo para el jugador dos 
            acumxa[turnoa]=coorda;
            tableroa(coorda, acumxa);
            System.out.print("Jugador 2 ingrese la coordenada que desea bombardear: ");
            coorda = mainn.nextLine();
            cont2 = HabradadoA(coorda, cont2);
            turnoa++;
            System.out.println(cont2+"cont2");
            if (cont1==3){
                break;
            }
            if (cont2==3){
                break;
            }
        }while(cont1<4||cont2<4);
        if (cont1==3) {
            System.out.println("Felicidades Jugador 1, usted ha ganado");
        }else{
            System.out.println("Felicidades Jugador 2, usted ha ganado");
        }
    }
    
    public static void tableroa(String coorda, String[] acumxa){
        String[][] tableroa = new String[6][5];
        //creo la matriz 
        for (int k = 0; k < 5; k++) {
            if (k==0) {
                System.out.print("  ");
            }
            System.out.print(k+"  ");
        }
        // este for de arriba es para escribir los numeros arriba de la matriz para que el usuario identifique las coordenadas.
        System.out.println();
        for (int i = 0; i < tableroa.length; i++) {
            System.out.print (i);
            // y este sout es para escribir lo mismo solo para las filas.
            for (int j = 0; j < tableroa[i].length; j++) {
                String ambos = ""+i+""+j;
                //aqui creo un String que junta los numeros de i y j para que se haga un String.
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//                if ((i==0&&j==0)||(i==1&&j==0)||(i==2&&j==0)||(i==1&&j==2)||(i==1&&j==3)||(i==3&&j==4)||(i==4&&j==4)||(i==5&&j==4)){
//                    if ("[X]".equals(tableroa[i][j])){
//                        tableroa[i][j]="[X]";
//                    }else{
//                        tableroa[i][j]="[]";
//                    }
//                }else{
//                    tableroa[i][j]="[ ]";
//                }
//------------------------------------------------------------------------------------------------------------------------------------------------------------
                tableroa[i][j]="[ ]";
                // aqui determino que para cada casilla debe haber un espacio ya que no se deben de ver los *
                if (ambos.equals(coorda)){
                    tableroa[i][j]="[X]";
                    //esto es para que a la siguiente tirada le aparezca la X del lugar donde tiro anteriormente.
                }
                if (ambos.equals(acumxa[i])) {
                    tableroa[i][j]="[X]";
                    //aqui lo que intento es comparar el String ambos que es el string de las coordenadas del for con la posicion que hay en el acumulador
                    //de coordenadas ya escritas, pero no me funciona, solo sale la X del tiro anterior no todos los anteriores, es decir, solo uno.
                }
                System.out.print(tableroa[i][j]);
                
            }
            System.out.println();
        }
    }
    
    public static int HabradadoA (String coorda, int cont2){
        String[][] tableroa = new String[6][5];
        boolean sera=false;
        for (int k = 0; k < 5; k++) {
            if (k==0) {
            }
        }
        for (int i = 0; i < tableroa.length; i++) {
            for (int j = 0; j < tableroa[i].length; j++) {
                String ambos = i+""+j;
                if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 2 && j == 0) || (i == 1 && j == 2) || (i == 1 && j == 3) || (i == 3 && j == 4) || (i == 4 && j == 4) || (i == 5 && j == 4)) {
                    tableroa[i][j] = "[*]";
                    if (coorda.equals(ambos)) {
                        cont2++;
                        sera = true;
                        i=7680;
                        //le puse ese valor para que no vuelva a entrar al ciclo.
                        break;
                    } else {
                        tableroa[i][j] = "[ ]";
                        sera = false;
                    }
                }
            }
        }
        if (sera) {
            System.out.println("Uy, un barco ha sido bombardeado");
        } else {
            System.out.println("Bomba al agua");
        }
        return cont2;
    }
    
   public static void tablerob (String coordb, String[] acumxb){
       String[][] tablerob = new String[6][5];
        for (int k = 0; k < 5; k++) {
            if (k==0) {
                System.out.print("  ");
            }
            System.out.print(k+"  ");
        }
        System.out.println();
        for (int i = 0; i < tablerob.length; i++) {
            System.out.print (i);
            for (int j = 0; j < tablerob[i].length; j++) {
                String ambos = ""+i+""+j;
//                if ((i==1&&j==3)||(i==2&&j==3)||(i==3&&j==1)||(i==3&&j==3)||(i==4&&j==1)||(i==5&&j==1)||(i==5&&j==3)||(i==5&&j==4)){
//                    if ("[X]".equals(tablerob[i][j])){
//                        tablerob[i][j]="[X]";
//                    }else{
//                        tablerob[i][j]="[*]";
//                    }
//                }else{
//                    tablerob[i][j]="[ ]";
//                }
                tablerob[i][j]="[ ]";
                if (ambos.equals(coordb)){
                    tablerob[i][j]="[X]";
                }
                if (ambos.equals(acumxb[i])) {
                    tablerob[i][j] = "[X]";
                }
                System.out.print(tablerob[i][j]);
            }
            System.out.println();
        }
   }
   
   public static int HabradadoB (String coordb, int cont1){
       String[][] tableroa = new String[6][5];
        boolean sera2=false;
        for (int k = 0; k < 5; k++) {
            if (k==0) {
            }
        }
        for (int i = 0; i < tableroa.length; i++) {
            for (int j = 0; j < tableroa[i].length; j++) {
                String ambos = i+""+j;
                if ((i==1&&j==3)||(i==2&&j==3)||(i==3&&j==1)||(i==3&&j==3)||(i==4&&j==1)||(i==5&&j==1)||(i==5&&j==3)||(i==5&&j==4)){
                    tableroa[i][j]="[*]";
                    //aqui les digo cuales son las coordenadas que tienen los barcos.
                    if (coordb.equals(ambos)){
                        cont1++;
                        // se suma el contador que identifica las veces que le ha dado a un barco.
                        sera2 = true;
                        i=7890;
                        // en el caso de que acierta lo saca del for y le dice que le dio.
                        //le puse ese valor para que no vuelva a entrar al ciclo.
                        break;
                    } else {
                        tableroa[i][j] = "[ ]";
                        // en caso de ser falso solo lo deja como un [ ] y le dice que le dio al agua.
                        sera2 = false;
                    }
                }
            }
        }
        if (sera2) {
            System.out.println("Uy, un barco ha sido bombardeado");
        } else {
            System.out.println("Bomba al agua");
        }
        return cont1;
   }
}
