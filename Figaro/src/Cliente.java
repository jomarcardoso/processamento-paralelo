public class Cliente extends Thread {

    int idCliente;
    Barbearia barbearia;

    public Cliente(int idCliente, Barbearia barbearia) {
        this.idCliente = idCliente;
        this.barbearia = barbearia;
    }

    public void run() {
        irCortarCabelo();
    }

    private synchronized void irCortarCabelo() {

        barbearia.add(this);
    }

}
