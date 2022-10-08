class PlecakDecWyp
{
  final static int N = 6;                // liczba wszystkich przedmiotow
  final static int MAX_V = 10;           // objetosc plecaka
  final static int[] V = {6,2,3,2,3,1};  // objetosci przedmiotow
  final static int[] W = {6,4,5,7,10,2}; // wartosci przedmiotow
  static class Plecak
  {
    int wartosc;
    int[] zawartosc = new int[N];
  }
  public static void main(String[] args)
  {
    Plecak p = P(N-1,MAX_V);
    System.out.println("Wartosc plecaka: " + p.wartosc);
    System.out.print("Przedmioty w plecaku: ");
    for (int i = 0; i < N; i++)
      if (p.zawartosc[i] == 1) System.out.print(i + " ");
    System.out.println();
  }
  static Plecak P(int i, int v)
  {
    Plecak p1 = new Plecak(); // plecak, gdy bierzemy i-ty przedmiot
    Plecak p2 = new Plecak(); // plecak, gdy nie bierzemy i-tego przedmiotu
    if (i == 0 && v < V[0])
    {
      p1.zawartosc[0] = 0;
      p1.wartosc = 0;
      return p1;
    }
    if (i == 0 && v >= V[0])
    {
      p2.zawartosc[0] = 1;
      p2.wartosc = W[0];
      return p2;
    }
    p1.zawartosc = P(i-1,v).zawartosc;
    p1.zawartosc[i] = 0;
    p1.wartosc = P(i-1,v).wartosc;
    if (i > 0 && v < V[i]) return p1;
    p2.zawartosc = P(i-1,v-V[i]).zawartosc;
    p2.zawartosc[i] = 1;
    p2.wartosc = W[i] + P(i-1,v-V[i]).wartosc;
    if (p2.wartosc > p1.wartosc) // gdy i > 0 && v >= V[i]
      return p2;
    else
      return p1;
  }
}