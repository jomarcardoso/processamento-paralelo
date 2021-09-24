public class Cliente extends Thread {

    private Barbearia barbearia;

    public Cliente(String nome, Barbearia barbearia) {
        super(nome);
        this.barbearia = barbearia;
    }

    public void entrar() {
        synchronized (barbearia) {
            if (!barbearia.getSalao().getFilaLotada()) {
                barbearia.getSalao().addCliente(this);

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        this.entrar();
    }

}
