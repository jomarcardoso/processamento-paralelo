import java.util.LinkedList;
import java.util.Random;

public class Barbearia {

    int barbeirosLivres;
    int qntMaxClientes;
    int qntBarbeiros;
    int sofa;
    LinkedList<Cliente> clientes;
//    LinkedList<Cliente> clientesSaguao;

    Random random = new Random();

    public Barbearia(int qntBarbeiros, int qntMaxClientes, int sofa) {
        this.sofa = sofa;
        this.qntBarbeiros = qntBarbeiros;
        this.barbeirosLivres = qntBarbeiros;
        this.qntMaxClientes = qntMaxClientes;
        clientes = new LinkedList();
    }

    public void cortar(int idBarbeiro) {
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

            System.out.println("Cliente " + cliente.idCliente + " vai acordar o barbeiro " + idBarbeiro + ".");
        }

        barbeirosLivres--;

        System.out.println("Barbeiro " + idBarbeiro + " está cortando o cabelo do cliente " + cliente.idCliente + ".");

        if (clientes.size() > 0) {
            System.out.println("Barbeiro " + idBarbeiro + " vai buscar o próximo cliente.");
        }

        barbeirosLivres++;
    }

    public void add(Cliente cliente) {
        System.out.println("Cliente " + cliente.idCliente + " entrou pela porta.");

        synchronized (clientes) {
            if (clientes.size() == sofa) {
                System.out.println("O sofá está cheio");
            } else if (barbeirosLivres > 0) {
                System.out.println("Há barbeiros disponíveis então o cliente " + cliente.idCliente + " vai até eles para cortar o cabelo.");

                clientes.offer(cliente);
                clientes.notify();
            } else {
                System.out.println("Não há barbeiros disponíveis então o cliente " + cliente.idCliente + " irá esperar no sofá.");
                clientes.offer(cliente);

                if (clientes.size() == 1) {
                    clientes.notify();
                }
            }
        }
    }
}
