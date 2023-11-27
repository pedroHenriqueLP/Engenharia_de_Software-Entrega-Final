package telas;

import javax.swing.*;

public class CameraGUI {

    private int id_Camera;
    private String hr_chegada;
    private String hr_Saida;

    public CameraGUI(int id_Camera, String hr_chegada, String hr_Saida) {
        this.id_Camera = id_Camera;
        this.hr_chegada = hr_chegada;
        this.hr_Saida = hr_Saida;
    }

    public void exibirFilmagem(String data) {
        JOptionPane.showMessageDialog(null, "Exibindo filmagem do dia " + data);
        return;
    }

    public int getId_Camera() {
        return id_Camera;
    }

    public void setId_Camera(int id_Camera) {
        this.id_Camera = id_Camera;
    }

    public String getHr_chegada() {
        return hr_chegada;
    }

    public void setHr_chegada(String hr_chegada) {
        this.hr_chegada = hr_chegada;
    }

    public String getHr_Saida() {
        return hr_Saida;
    }

    public void setHr_Saida(String hr_Saida) {
        this.hr_Saida = hr_Saida;
    }
}