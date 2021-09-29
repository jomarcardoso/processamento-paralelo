package pacote;

public class Main {
  public static void main(String[] args) {
    System.out.println("a aplicacao comecou");

    SecretariaPapaiNoel secretariaPapaiNoel = new SecretariaPapaiNoel();
    secretariaPapaiNoel.start();

    // PapaiNoel papaiNoel = new PapaiNoel(secretariaPapaiNoel);
    // papaiNoel.start();

    for (int i = 1; i <= 8; i++) {
      Rena rena = new Rena("rena" + i, secretariaPapaiNoel);
      rena.start();
    }

    for (int i = 1; i <= 3; i++) {
      Elfo elfo = new Elfo("elfo" + i, secretariaPapaiNoel);
      elfo.start();
    }

    // System.out.println("acabou a aplicação");
  }
}
