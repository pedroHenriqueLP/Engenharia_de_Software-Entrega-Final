package telas;

import javax.swing.*;
import java.util.*;

public class PessoaGUI {

    private List<VeiculoGUI> veiculos;
    private List<VagasGUI> vaga;

    private String nome;
    private String cpf;
    private int n_apartamento;
    private int qtd_veiculos;
    private String genero;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getN_apartamento() {
        return n_apartamento;
    }
    public void setN_apartamento(int n_apartamento) {
        this.n_apartamento = n_apartamento;
    }
    public int getQtd_veiculos() {
        return qtd_veiculos;
    }
    public void setQtd_veiculos(int qtd_veiculos) {
        this.qtd_veiculos = qtd_veiculos;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public PessoaGUI(String nome, String cpf, int n_apartamento, int qtd_veiculos, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.n_apartamento = n_apartamento;
        this.qtd_veiculos = qtd_veiculos;
        this.genero = genero;
        this.veiculos = new ArrayList<>();
        this.vaga = new ArrayList<>();
    }

    public void requisitarVagas() {
        JTextField vagaField = new JTextField();

        Object[] message = {
                "Insira um número de vaga:", vagaField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Requisitar Vagas", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int vagaInsert = Integer.parseInt(vagaField.getText());
           
            VagasGUI novaVaga = new VagasGUI(vagaInsert, true);
            adicionar_Vaga(novaVaga);

            String mensagem = "A vaga " + vagaInsert + " foi atribuída a você.";
            JOptionPane.showMessageDialog(null, mensagem, "Veículo Atribuído", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void atribuirVeiculo() {
        JTextField placaField = new JTextField();
        JTextField corField = new JTextField();
        JTextField marcaField = new JTextField();
        JTextField modeloField = new JTextField();

        Object[] message = {
                "Placa:", placaField,
                "Cor:", corField,
                "Marca:", marcaField,
                "Modelo:", modeloField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Atribuir Veículo", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String placa = placaField.getText();
            String cor = corField.getText();
            String marca = marcaField.getText();
            String modelo = modeloField.getText();

            VeiculoGUI novoVeiculo = new VeiculoGUI(placa, cor, marca, modelo);
            adicionar_Veiculo(novoVeiculo);

            String mensagem = "Veículo " + marca + " " + modelo + " atribuído com sucesso!";
            JOptionPane.showMessageDialog(null, mensagem, "Veículo Atribuído", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void adicionar_Veiculo(VeiculoGUI novoVeiculo) {
        veiculos.add(novoVeiculo);
        qtd_veiculos = qtd_veiculos + 1;
    }

    public void adicionar_Vaga(VagasGUI novaVaga) {
        vaga.add(novaVaga);
    }
}
