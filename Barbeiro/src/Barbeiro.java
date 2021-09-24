public class Barbeiro extends Thread {

    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia, String nome) {
        super(nome);
        this.barbearia = barbearia;
    }

    public void atender() {
        synchronized (barbearia) {
            // Verifica se há clientes no sofá
            if (barbearia.getSofa().getFilaVazia()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Cliente clienteEmAtendimento = barbearia.getSofa().removePrimeiroCliente();
            }
        }
    }

    public void run() {
        while (true) {
            this.atender();
        }
    }

}
