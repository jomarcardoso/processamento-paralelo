import java.util.LinkedList;

public class Barbearia {

    Integer maquininhasLivres;
    int barbeirosLivres;
    int qntMaxClientes;
    int qntBarbeiros;
    int sofa;
    LinkedList<Cliente> clientes;

    public Barbearia(int qntBarbeiros, int qntMaxClientes, int sofa, int qntMaquininhas) {
        this.sofa = sofa;
        this.qntBarbeiros = qntBarbeiros;
        this.barbeirosLivres = qntBarbeiros;
        this.maquininhasLivres = qntMaquininhas;
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

        System.out.println("Barbeiro " + idBarbeiro + " cortou o cabelo do cliente " + cliente.idCliente + ".");

        System.out.println("Barbeiro " + idBarbeiro + " vai tentar receber o pagamento do cliente " + cliente.idCliente + ".");

        pagamento(idBarbeiro, cliente);
    }

    public void pagamento(int idBarbeiro, Cliente cliente) {
        synchronized (maquininhasLivres) {
            while (maquininhasLivres <= 0) {
                System.out.println("Não há maquininhas livres, o barbeiro " + idBarbeiro + " irá esperar para receber o pagamento do cliente " + cliente.idCliente + ".");

                try {
                    maquininhasLivres.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Há " + maquininhasLivres + " maquininhas livres, o barbeiro " + idBarbeiro + " receber o pagamento do cliente " + cliente.idCliente + ".");

            maquininhasLivres--;

            System.out.println("O cliente " + cliente.idCliente + " pagou pelo corte com o barbeiro " + idBarbeiro + " e vai embora.");

            maquininhasLivres++;
            maquininhasLivres.notify();

            System.out.println("O barbeiro " + idBarbeiro + " deixou a maquininha no balcão novamente.");
        }

        if (clientes.size() > 0) {
            System.out.println("O barbeiro " + idBarbeiro + " vai buscar o próximo cliente.");
        }

        barbeirosLivres++;
    }

    public void add(Cliente cliente) {
        System.out.println("Cliente " + cliente.idCliente + " entrou pela porta.");

        synchronized (clientes) {
            System.out.println("Há " + clientes.size() + " clientes na barberia.");
            if (clientes.size() < sofa && barbeirosLivres > 0) {
                System.out.println("Há barbeiros disponíveis então o cliente " + cliente.idCliente + " vai até eles para cortar o cabelo.");

                clientes.offer(cliente);
                clientes.notify();
            } else if (clientes.size() < sofa && barbeirosLivres <= 0) {
                System.out.println("Não há barbeiros disponíveis então o cliente " + cliente.idCliente + " irá esperar no sofá.");
                clientes.offer(cliente);

                if (clientes.size() == 1) {
                    clientes.notify();
                }
            } else if (clientes.size() >= sofa && clientes.size() < qntMaxClientes) {
                System.out.println("O sofá está cheio, o cliente " + cliente.idCliente + " irá esperar no saguão.");

                clientes.offer(cliente);
            } else if (clientes.size() >= sofa && clientes.size() >= qntMaxClientes) {
                System.out.println("A barbearia está cheia, o cliente " + cliente.idCliente + " irá embora.");
            }
        }
    }
}
