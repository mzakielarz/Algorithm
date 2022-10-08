package plecakowy;

/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda Monte-Carlo
*/


import java.util.*;

class PlecakowyMonteCarlo
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

        for (int i = 0; i < 10; i++) //Bedzie 10 prob losowania
        {
            int[] ustaw = new int[N]; //Inicjujemy wstepne ustawienie przedmiotow
            for (int j = 0; j < N; j++) ustaw[j] = j;
            
            for (int j = 0; j < N; j++) //tasowanie przedmiotow
            {
                int rndIndex = los.nextInt(N);
                if (rndIndex != j)
                {
                    int pom = ustaw[j]; //Zamiana elementow
                    ustaw[j] = ustaw[rndIndex];
                    ustaw[rndIndex] = pom;
                }
            }


            String locKonfig = new String();
            int sumV = 0;
            int sumW = 0;
            int j = 0;

            //Bierzemy przedmioty do plecaka od poczatku tablicy dopoki sie mieszcza
            while ((j < N) && (sumV + V[ustaw[j]] <= MAX_V))
            {
                sumV = sumV + V[ustaw[j]];
                sumW = sumW + W[ustaw[j]];
                locKonfig = locKonfig + " " + ustaw[j];
                j++;
            }

            if (sumW > optW)
            {
                optW = sumW;
                optV = sumV;
                optKonfig = locKonfig;
            }

        }

        System.out.println("Calkowita objetość: " + optV);
        System.out.println("Calkowita wartosc: " + optW);
        System.out.println("Konfiguracja: " + optKonfig);
        System.out.println("Niewykorzystana objętość: " + (MAX_V - optV));
    }
}
