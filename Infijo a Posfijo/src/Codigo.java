import java.util.Stack;
import java.util.*;
public class Codigo {
    public static void main(String[] args)
    {
        String infijo = "B*(X|B+D*E)+G";
        String postfix = InfijoAPosfijo(infijo);
        System.out.println("El resultado de nuestra cadena de Posfijos es: "+postfix);
    }
    public static boolean   Definicion(char c)
    {
        // Aqui defino el rango de los valore que tomo como referencia
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
    //En este metodo hare la conversion de infijo a posfijo
    public static String InfijoAPosfijo(String infijo)
    {
        if (infijo == null || infijo.length() == 0) {
            return infijo;
        }
        //En esta parte creo mi Stack vacio
        Stack<Character> solucion = new Stack<>();
        String posfijo = "";
        //Aqui comenzare a procesar todos los datos que tenga coleccionados
        for (char cadena: infijo.toCharArray())
        {
            if (cadena == '(') {
                solucion.add(cadena);
            } else if (cadena == ')')
            { while (solucion.peek() != '(') {
                    posfijo += solucion.pop();
                } solucion.pop(); }
            else if (Definicion(cadena)) {
                posfijo += cadena;
            } else {
                while (!solucion.isEmpty() && cadena(cadena) >= cadena(solucion.peek())) {
                    posfijo += solucion.pop();
                }solucion.add(cadena);}
        }
        while (!solucion.isEmpty()) {
            posfijo += solucion.pop();}
        return posfijo;
        //Aqui se guardan todos mis metodos matematicos
    } public static int cadena(char Operacion)
    {
        // Sumas y restas
        if (Operacion == '+' || Operacion == '-') {
            return 4;
        }
        //Toma de valores en conjunto con operador and
        if (Operacion == '&') {
            return 8;
        }
        //Potencias
        if (Operacion == '^') {
            return 9;
        }
        // Divisiones y Multiplicaciones
        if (Operacion == '*' || Operacion == '/') {
            return 3;
        }
        //Operación or- o tomo un valor o tomo el otro
        if (Operacion == '|') {
            return 10;
        }
        return Integer.MAX_VALUE;	
    } }
