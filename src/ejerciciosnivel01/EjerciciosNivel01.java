/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosnivel01;

import java.util.Arrays;

/**
 *
 * @author Joel García Valhondo
 */
public class EjerciciosNivel01 {
    
    
    /**
     * PRIMER EJERCICIO MAXIMOS
     * @param lista array de numeros que va comparando.
     * @return el arraymaximos, los dos números más altos.
     */
    public int[] maximos(int[] lista){
        int[] arrayMaximos = {lista[0],lista[0]};
        for(int i=0; i<lista.length; i++){
            if(lista[i] > arrayMaximos[0]){
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            }
            else if(lista[i] > arrayMaximos[1]){
                arrayMaximos[1] = lista[i];
            }
        }
        
        return arrayMaximos;
    }
    //Segundo ejercicio : PALÍNDROMO
    //Para hacer este ejercicio necesito hacer primero una función que
    //limpie el string para quitarle los acentos y espacios en blanco.
    
    private String limpiaFrase(String frase){
        frase = frase.toLowerCase(); //paso la frase a minúsculas.
        //quitamos las tildes.
        frase = frase.replace('á', 'a');
        frase = frase.replace('é', 'e');
        frase = frase.replace('í', 'i');
        frase = frase.replace('ó', 'o');
        frase = frase.replace('ú', 'u');
        //quito también los espacios en blanco.
        frase = frase.replace(" ","");
        
        return frase;
    }
    
    public boolean esPalindromo(String frase){
        frase = limpiaFrase(frase);//quita acentos y espacios en blanco.
        
        int indiceIzquierdo = 0;
        int indiceDerecho = frase.length()-1;
        
        while(frase.charAt(indiceIzquierdo) == frase.charAt(indiceDerecho) && indiceIzquierdo <= indiceDerecho){
            indiceIzquierdo++;
            indiceDerecho--;
        }
        if(indiceIzquierdo > indiceDerecho){
            return true;
        }
        else return false;
    }
    
    /**
     * Tercer ejercicio : ISOGRAMA
     * @param palabra que metemos para comprobar si es un isograma.
     * @return 
     */
    
    public boolean esIsograma(String palabra){
        palabra = limpiaFrase(palabra); //quita acentos y espacios en blanco.
        for(int i=0; i < palabra.length()-1; i++){ //el -1 quita mirar la ultima
            for(int j=i+1; j < palabra.length(); j++){
                if(palabra.charAt(i) == palabra.charAt(j)){
                    return false;
                }
            }    
        }
        return true;
    }
    
    /**
     *Cuarto Ejercicio : ACRÓNIMO
     * @param frase que metemos para que saque su acrónimo.
     * @return 
     */
    
    public String acronimo(String frase){
        //suponemos que hay una letra en la frase.
        frase = frase.toUpperCase();
        String[] palabras = frase.split(" ");
        String resultado = "";
        for(int i=0; i < palabras.length; i++){  
            if (!(palabras[i].equals("Y") || palabras[i].equals("E") || palabras[i].equals("DE") || palabras[i].equals("LA") || palabras[i].equals("LAS"))){
                resultado = resultado + palabras[i].charAt(0);
            } 
        }
        return resultado;  
    }
    
    public static void main(String[] args) {
        //test primer ejercicio.
        int[] numeros = {99,37,7,54,13};
        int[] numeros2 = {-1,100,8,84,103,100005,77};
        int[] numeros3 = {-18648654,-100,-8,-84,-103,-100005,-77};
        EjerciciosNivel01 e = new EjerciciosNivel01();
        System.out.println(Arrays.toString(e.maximos(numeros)));
        System.out.println(Arrays.toString(e.maximos(numeros2)));
        System.out.println(Arrays.toString(e.maximos(numeros3)));
        //test segundo ejercicio.
        System.out.println(e.esPalindromo("Acaso hubo buhos acá")); //true
        //test tercer ejercicio.
        System.out.println(e.esIsograma("Tijera")); //true
        System.out.println(e.esIsograma("Pájaro")); //false
        System.out.println(e.esIsograma("Golondrina")); //false
        //test cuarto ejercicio.
        System.out.println("Acronimo (Alta Velicidad Española): " + e.acronimo("Alta Velocidad Española"));
        System.out.println("Acronimo (TIC): " + e.acronimo("Tecnologías de la Información y de la Comunicación"));
        
    }
    
}
