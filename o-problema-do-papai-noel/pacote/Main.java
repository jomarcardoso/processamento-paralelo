package pacote;

public class Main {
  public static void main(String[] args) {
    System.out.println("a aplicacao comecou");

    SecretariaPapaiNoel secretariaPapaiNoel = new SecretariaPapaiNoel();

    PapaiNoel papaiNoel = new PapaiNoel(secretariaPapaiNoel);
    papaiNoel.start();

    for (int i = 1; i <= 8; i++) {
      Rena rena = new Rena("rena" + i, secretariaPapaiNoel);
      rena.start();
    }

    // System.out.println("Papai Noel está cuidando a fila");

    // papaiNoel.gerenciarFila();

    System.out.println("acabou a aplicação");
  }
}
