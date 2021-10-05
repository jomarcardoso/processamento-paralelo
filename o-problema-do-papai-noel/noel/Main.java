package noel;

public class Main {
  public static void main(String[] args) {
    System.out.println("A aplicacao comecou");

    PapaiNoel papaiNoel = new PapaiNoel();
    papaiNoel.start();

    for (int i = 1; i <= 9; i++) {
      Rena rena = new Rena("Rena " + i, papaiNoel);
      rena.start();
    }

    for (int i = 1; i <= 10; i++) {
      Elfo elfo = new Elfo("Elfo " + i, papaiNoel);
      elfo.start();
    }
  }
}
