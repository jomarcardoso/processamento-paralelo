package noel;

public class Rena extends Thread {
  PapaiNoel papaiNoel;
  String nome;

  public Rena(String nome, PapaiNoel papaiNoel) {
    super();

    this.papaiNoel = papaiNoel;
    this.nome = nome;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(nome + " de ferias");
    Thread.sleep((int)(25000 + Math.random() * 5000));
  }

  private void irParaFila() throws InterruptedException {
    papaiNoel.adicionarRenaAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        aproveitarFerias();
        irParaFila();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
