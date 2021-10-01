import java.util.LinkedList;
import java.util.Random;

public class Barbearia {

    Integer maquininhasLivres;
    int barbeirosLivres;
    int qntMaxClientes;
    int qntBarbeiros;
    int sofa;
    LinkedList<Cliente> clientes;
    Random random;

    public Barbearia(int qntBarbeiros, int qntMaxClientes, int sofa, int qntMaquininhas) {
        this.sofa = sofa;
        this.qntBarbeiros = qntBarbeiros;
        this.barbeirosLivres = qntBarbeiros;
        this.maquininhasLivres = qntMaquininhas;
        this.qntMaxClientes = qntMaxClientes;
        clientes = new LinkedList();
        random = new Random();
    }

    public void cortar(int idBarbeiro) throws InterruptedException {
        Cliente cliente;

        synchronized (clientes) {
            while(clientes.size() == 0) {
                System.out.println("O barbeiro " + idBarbeiro + " está dormindo.");

                try {
                    clientes.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            cliente = clientes.poll();
        }

        System.out.println("Cliente " + cliente.idCliente + " vai acordar o barbeiro " + idBarbeiro + ".");

        incrementarOuDecrementarBarbeiros(false);

        Thread.sleep(random.nextInt(5));

        System.out.println("Barbeiro " + idBarbeiro + " cortou o cabelo do cliente " + cliente.idCliente + ".");
        System.out.println("Barbeiro " + idBarbeiro + " vai receber o pagamento do cliente " + cliente.idCliente + ".");

        pagamento(idBarbeiro, cliente);
    }

    public void pagamento(int idBarbeiro, Cliente cliente) throws InterruptedException {
        usarMaquininha(cliente, idBarbeiro);

        if (clientes.size() > 0) {
            System.out.println("O barbeiro " + idBarbeiro + " vai buscar o próximo cliente.");
        }

        incrementarOuDecrementarBarbeiros(true);
        Thread.sleep(random.nextInt(5));
    }

    public synchronized void incrementarOuDecrementarBarbeiros(boolean incOrDec) {
        if (incOrDec) {
            barbeirosLivres++;
        } else {
            barbeirosLivres--;
        }
    }

    public synchronized void usarMaquininha(Cliente cliente, int idBarbeiro) throws InterruptedException {
        System.out.println("O cliente " + cliente.idCliente + " pagou pelo corte com o barbeiro " + idBarbeiro + " e vai embora.");

        Thread.sleep(random.nextInt(5));
    }

    public void add(Cliente cliente) {
        System.out.println("Cliente " + cliente.idCliente + " entrou pela porta.");

        System.out.println("Há " + clientes.size() + " clientes na barberia.");

        if (clientes.size() < sofa && barbeirosLivres > 0) {
            System.out.println("Há barbeiros disponíveis então o cliente " + cliente.idCliente + " vai até eles para cortar o cabelo.");

            synchronized (clientes) {
                clientes.offer(cliente);

                clientes.notify();
            }
        } else if (clientes.size() < sofa && barbeirosLivres <= 0) {
            System.out.println("Não há barbeiros disponíveis então o cliente " + cliente.idCliente + " irá esperar no sofá.");

            synchronized (clientes) {
                clientes.offer(cliente);

                if (clientes.size() == 1) {
                    clientes.notify();
                }
            }

        } else if (clientes.size() >= sofa && clientes.size() < qntMaxClientes) {
            System.out.println("O sofá está cheio, o cliente " + cliente.idCliente + " irá esperar no saguão.");

            synchronized (clientes) {
                clientes.offer(cliente);
            }
        } else if (clientes.size() >= sofa && clientes.size() >= qntMaxClientes) {
            System.out.println("A barbearia está cheia, o cliente " + cliente.idCliente + " irá embora.");
        }
    }
}
