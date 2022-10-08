import java.util.*;
class WilkKozaKapusta
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    Stan[] tab = new Stan[100];
    tab[0] = new Stan(); // stan pocz¹tkowy
    int i;
    for (i = 1; i < 100; i++)
    {
      tab[i] = tab[i-1].nastepnyStan();
      if (tab[i].stanKoncowy()) break;
    }
    if (i == 100)
      System.out.println("Nie znaleziono rozwiazania.");
    else
    {
      System.out.println("Droga do stanu koncowego:");
      for (int j = 0; j <= i; j++)
      {
        tab[j].wypiszStan();
      }
      System.out.println();
    }
  }
}
class Stan implements Cloneable
{
  private boolean wilk, koza, kapusta;
  private static Random losuj = new Random();
  boolean stanKoncowy() // czy stan koncowy ?
  {
    return wilk && koza && kapusta;
  }
  void wypiszStan()
  {
    System.out.print(wilk ? "(1," : "(0,");
    System.out.print(koza ? "1," : "0,");
    System.out.print(kapusta ? "1) " : "0) ");
  }
  Stan nastepnyStan() throws CloneNotSupportedException
  {
    Stan nastepny = (Stan)clone();    
    do
    {
      int i = losuj.nextInt(3);
      if (i == 0 && (koza ^ kapusta)) // przewiezienie wilka
      {
        nastepny.wilk = !wilk;
        break;
      }
      if (i == 1) // przewiezienie kozy
      {
        nastepny.koza = !koza;
        break;
      }
      if (i == 2 && (wilk ^ koza)) // przewiezienie kapusty
      {
        nastepny.kapusta = !kapusta;
        break;
      }
    } while(true);
    return nastepny;
  }
}