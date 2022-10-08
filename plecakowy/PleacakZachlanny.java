package plecakowy;

/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda algorytmu zachlannego
*/


public class PleacakZachlanny
{

    final static int N = 6;                // liczba przedmiotów
    final static int MAX_V = 10;           // objetość plecaka

    final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
    final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów


    //Wersja wybierania w kolejnosci roznacych objetosci przedmiotów
    public static void pakujMale()
    {
        boolean [] rozw = new boolean[N]; //tablica na optymalny podzbior
        for (int i=0; i<N; i++) rozw[i] = false; //Na poczatku nic nie zostalo zabrane (pusty plecak)

        int sumW = 0;
        int sumV = 0;

        while(true)
        {
            int minV = Integer.MAX_VALUE; int maxPoz = -1;
            for (int i=0; i<N; i++) //Szukamy najmniejszego przedmiotu, ktory jeszcze nie zostal zabrany
            {
                if (!rozw[i]) //jesli jeszcze nie zabrany
                {
                    if ((sumV+V[i]<=MAX_V)&&(V[i]<minV))
                    {
                        minV = V[i]; maxPoz = i;
                    };
                }
            }

            if (maxPoz>-1)
            {    
                rozw[maxPoz]=true;
                sumW = sumW + W[maxPoz];
                sumV = sumV + V[maxPoz];
            }
            else break;

        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + sumW);
        System.out.print("Przedmioty w plecaku: ");

        for (int i = 0; i < N; i++)
            if (rozw[i]) System.out.print(i + " ");

        System.out.println();

    }


    //Wersja wybierania w kolejnosci malejacych wartosci predmiotow
    public static void pakujCenne()
    {

        boolean [] rozw = new boolean[N]; //tablica na optymalny podzbior
        for (int i=0; i<N; i++) rozw[i] = false; //Na poczatku nic nie zostalo zabrane (pusty plecak)

        int sumW = 0;
        int sumV = 0;

        while(true)
        {
            int maxW = 0; int maxPoz = -1;
            for (int i=0; i<N; i++) //Szukamy najcenniejszego przedmiotu, ktory jeszcze nie zostal zabrany
            {
                if (!rozw[i]) //jesli jeszcze nie zabrany
                {
                    if ((sumV+V[i]<=MAX_V)&&(W[i]>maxW))
                    {
                        maxW = W[i]; maxPoz = i;
                    };
                }
            }

            if (maxPoz>-1) 
            {             
                rozw[maxPoz]=true; 
                sumW = sumW + W[maxPoz];
                sumV = sumV + V[maxPoz];
            }
            else break;
            
        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + sumW);
        System.out.print("Przedmioty w plecaku: ");

        for (int i = 0; i < N; i++)
            if (rozw[i]) System.out.print(i + " ");

        System.out.println();

    }



    //Wersja wybierania w kolejnosci malejacych wartosci ilorazu: wartość/objętość

    public static void pakujNaIlorazie()
    {

        boolean [] rozw = new boolean[N]; //tablica na optymalny podzbior
        for (int i=0; i<N; i++) rozw[i] = false; //Na poczatku nic nie zostalo zabrane (pusty plecak)

        int sumW = 0;
        int sumV = 0;

        while(true)
        {
            double maxFrac = 0; int maxPoz = -1;
            for (int i=0; i<N; i++) //Szukamy najlepszego w sensie ilorazu, ktory jeszcze nie zostal zabrany
            {
                if (!rozw[i]) //jesli jeszcze nie zabrany
                {
                    double frac = (double)W[i]/V[i];
                    if ((sumV+V[i]<=MAX_V)&&(frac>maxFrac))
                    {
                        maxFrac = frac; maxPoz = i;
                    };
                }
            }

            if (maxPoz>-1)
            {
                rozw[maxPoz]=true;
                sumW = sumW + W[maxPoz];
                sumV = sumV + V[maxPoz];
            }
            else break;

        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + sumW);
        System.out.print("Przedmioty w plecaku: ");

        for (int i = 0; i < N; i++)
            if (rozw[i]) System.out.print(i + " ");

        System.out.println();

    }

    public static void main(String[] args)
    {

        pakujMale();
        pakujCenne();
        pakujNaIlorazie();

    }
}

