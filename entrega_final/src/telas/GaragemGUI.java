package telas;

import javax.swing.*;

public class GaragemGUI {

    private boolean estado;
    private int qtd_vagas;
    private int qtd_vagas_ocupadas;

    public GaragemGUI(boolean estado, int qtd_vagas, int qtd_vagas_ocupadas) {
        this.estado = estado;
        this.qtd_vagas = qtd_vagas;
        this.qtd_vagas_ocupadas = qtd_vagas_ocupadas;
    }
    
    public void abrirPortao() {
        if (!estado) {
            estado = true;
            JOptionPane.showMessageDialog(null, "O portão foi aberto!");
        } else {
            JOptionPane.showMessageDialog(null, "O portão já está aberto!");
        }
    }

    public void fecharPortao() {
        if (estado) {
            estado = false;
            JOptionPane.showMessageDialog(null, "O portão foi fechado!");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "O portão já está fechado!");
            return;
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getQtd_vagas() {
        return qtd_vagas;
    }

    public void setQtd_vagas(int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
    }

    public int getQtd_vagas_ocupadas() {
        return qtd_vagas_ocupadas;
    }

    public void setQtd_vagas_ocupadas(int qtd_vagas_ocupadas) {
        this.qtd_vagas_ocupadas = qtd_vagas_ocupadas;
    }
}
