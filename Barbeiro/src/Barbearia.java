public class Barbearia {

    private Fila sofa;
    private Fila salao;

    public Barbearia(Fila sofa, Fila salao) {
        this.sofa = sofa;
        this.salao = salao;
    }

    public Fila getSofa() {
        return this.sofa;
    }

    public Fila getSalao() {
        return this.salao;
    }
}
