package plecakowy;

/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda błądzenia losowego
*/


import java.util.*;

class PlecakBladzenie
{

    static final int N = 6;                // liczba przedmiotow
    static final int MAX_V = 10;           // objetosc plecaka

    final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
    final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów

    public static void main(String[] args)
    {
        String optKonfig = new String();
        int optV = -1;
        int optW = 0;

        Random los = new Random();

        boolean [] rozw = new boolean[N]; //Inicjujemy wstepne ustawienie przedmiotow
        for (int i = 0; i < N; i++) rozw[i] = false; //Na poczatku plecak jest pusty

        for (int i = 0; i < 20; i++) //Bedzie 20 krokow bladzenia
        {
            int rndIndex = los.nextInt(N); //Losujemy miejsce zmiany
            rozw[rndIndex] = !rozw[rndIndex];

            String locKonfig = new String();
            int sumV = 0;
            int sumW = 0;

            //Badamy aktualna zawartosc plecaka
            for (int j=0; j<N; j++)
            {
                if (rozw[j])
                {
                    sumV = sumV + V[j];
                    sumW = sumW + W[j];
                    locKonfig = locKonfig + " " + j;
                }
            }

            if ((sumV<=MAX_V)&&(sumW > optW))
            {
                optW = sumW;
                optV = sumV;
                optKonfig = locKonfig;
            }
        }

        System.out.println("Calkowita obietość: " + optV);
        System.out.println("Calkowita wartosc: " + optW);
        System.out.println("Konfiguracja: " + optKonfig);
        System.out.println("Niewykorzystana objętość: " + (MAX_V - optV));
    }
}
