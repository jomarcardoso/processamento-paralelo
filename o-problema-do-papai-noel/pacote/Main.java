package pacote;

public class Main {
  public static void main(String[] args) {
    System.out.println("a aplicacao comecou");

    PapaiNoel papaiNoel = new PapaiNoel();

    Rena rena1 = new Rena("rena1", papaiNoel);
    Rena rena2 = new Rena("rena2", papaiNoel);
    Rena rena3 = new Rena("rena3", papaiNoel);
    Rena rena4 = new Rena("rena4", papaiNoel);
    Rena rena5 = new Rena("rena5", papaiNoel);
    Rena rena6 = new Rena("rena6", papaiNoel);
    Rena rena7 = new Rena("rena7", papaiNoel);
    Rena rena8 = new Rena("rena8", papaiNoel);

    rena1.start();
    rena2.start();
    rena3.start();
    rena4.start();
    rena5.start();
    rena6.start();
    rena7.start();
    rena8.start();

    System.out.println("Papai Noel está cuidando a fila");

    papaiNoel.gerenciarFila();

    System.out.println("acabou a aplicação");
  }
}
