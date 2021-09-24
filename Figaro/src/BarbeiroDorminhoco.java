import java.util.Random;

public class BarbeiroDorminhoco {

    public static void main(String args[]) throws InterruptedException {

        int qntMaxClientes = 20;
        int qntBarbeiros = 3;
        int qntSofa = 4;
        int idCliente = 1;

        Barbearia barbearia = new Barbearia(qntBarbeiros, qntMaxClientes, qntSofa);
        Random random = new Random();

        for (int i = 1; i <= qntBarbeiros; i++) {
            Barbeiro barbeiro = new Barbeiro(i, barbearia);
            barbeiro.start();
        }

        while (true) {
//            Thread.sleep(random.nextInt(300) + 100);

            Cliente cliente = new Cliente(idCliente, barbearia);
            idCliente++;
            cliente.start();
        }
    }

}
