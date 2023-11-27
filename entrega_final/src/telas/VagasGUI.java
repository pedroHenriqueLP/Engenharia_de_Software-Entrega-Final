package telas;

public class VagasGUI {
    private int numero;
    private boolean disponivel;

    public VagasGUI(int vagaInsert, boolean b) {
    }

    public void Vagas(int numero, boolean estado) {
        this.numero = numero;
        this.disponivel = estado;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean estado) {
        this.disponivel = estado;
    }
}
