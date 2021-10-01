package pacote;

public class Main {
  public static void main(String[] args) {
    System.out.println("a aplicacao comecou");

    PapaiNoel papaiNoel = new PapaiNoel();
    papaiNoel.start();

    for (int i = 1; i <= 9; i++) {
      Rena rena = new Rena("rena" + i, papaiNoel);
      rena.start();
    }

    for (int i = 1; i <= 10; i++) {
      Elfo elfo = new Elfo("elfo" + i, papaiNoel);
      elfo.start();
    }
  }
}
