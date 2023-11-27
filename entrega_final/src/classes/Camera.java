package classes;

import java.util.Scanner;

public class Camera {

    public void exibir_Filmagem(Scanner scanner) {
        System.out.println("Insira a data para exibir a filmagem:");
        String data = scanner.next();
        System.out.println("Exibindo filmagem do dia " + data + ". Pressione Enter para parar e voltar ao menu de ADM.");
        scanner.nextLine();
        scanner.nextLine();
    }

    private int id_Camera;
    private String hr_chegada;
    private String hr_Saida;

    public Camera(int id_Camera, String hr_chegada, String hr_Saida) {
        this.id_Camera = id_Camera;
        this.hr_chegada = hr_chegada;
        this.hr_Saida = hr_Saida;
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