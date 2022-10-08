package plecakowy;


/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda przeszukiwania z nawrotami
*/


public class PlecakNawroty
{
    final static int N = 6;                // liczba przedmiotów
    final static int MAX_V = 10;           // objetość plecaka

    final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
    final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów

    private static int[] tab = new int[N]; //pomocnicza tablica na aktualny podzbior
    private static int[] rozw = new int[N]; //tablica na optymalny podzbior

    private static int maxW = 0; //Pole na maksymalna obietosc

    
    static void pakowanie(int i,int sumV,int sumW)
    {        
        for (int j = 0; j < N; j++)
        {
            int k;
            for (k = 0; k < i; k++)
            {
                if (tab[k] == j) break;
            }

            if (k == i)
            {
                int newSumV = sumV + V[j];
                if (newSumV<=MAX_V)
                {
                    tab[k] = j;
                    int newSumW = sumW + W[j];
                    pakowanie(i + 1,newSumV,newSumW);
                }
                else
                {
                    if (sumW>maxW)
                    {
                        maxW = sumW;
                        for (int l = 0; l < N; l++) rozw[l] = 0;
                        for (int l = 0; l <= i; l++) rozw[tab[l]] = 1;
                    }
                }
            }
        }        
    }

    public static void main(String[] args)
    {
        pakowanie(0,0,0);

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + maxW);
        System.out.print("Przedmioty w plecaku: ");

        for (int i = 0; i < N; i++)
            if (rozw[i] == 1) System.out.print(i + " ");

        System.out.println();
    }
}
