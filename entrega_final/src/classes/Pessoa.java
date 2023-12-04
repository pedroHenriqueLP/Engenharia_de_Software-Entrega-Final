

package classes;

import java.util.*;

public class Pessoa {

    private List<Veiculo> veiculos;

    public void atribuirVaga(Scanner scanner, List<Pessoa> pessoas) {
        System.out.println("Insira o código da vaga desejada: ");
        int codigoVaga = scanner.nextInt();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getVaga() != null && pessoa.getVaga().getNumero() == codigoVaga) {
                System.out.println("A vaga já está atribuída a outra pessoa. Escolha outra vaga.");
                return;
            }
        }

        Vagas novaVaga = new Vagas(codigoVaga, true);
        this.setVaga(novaVaga);
        System.out.println("A vaga " + codigoVaga + " foi atribuída a você com sucesso!");
    }

    public void atribuir_Veiculo(Scanner scanner) {
        System.out.println("Atribuindo veículo.");
        System.out.println("Por favor, insira as informações abaixo.");

        System.out.print("Placa: ");
        String placa = scanner.next();

        System.out.print("Cor: ");
        String cor = scanner.next();

        System.out.print("Marca: ");
        String marca = scanner.next();

        System.out.print("Modelo: ");
        String modelo = scanner.next();

        Veiculo novoVeiculo = new Veiculo(placa, cor, marca, modelo);
        this.adicionar_Veiculo(novoVeiculo);

        System.out.println(
                "\n\nVeículo " + novoVeiculo.getMarca() + " " + novoVeiculo.getModelo() + " atribuído com sucesso!");
        veiculos.add(novoVeiculo);
        qtd_veiculos = qtd_veiculos + 1;
    }

    private String nome;
    private String cpf;
    private int n_apartamento;
    private int qtd_veiculos;
    private String genero;
    private Vagas vaga;

    public Pessoa(String nome, String cpf, int n_apartamento, int qtd_veiculos, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.n_apartamento = n_apartamento;
        this.qtd_veiculos = qtd_veiculos;
        this.genero = genero;
        this.veiculos = new ArrayList<>();
    }

    public void adicionar_Veiculo(Veiculo novoVeiculo) {
        veiculos.add(novoVeiculo);
    }

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

    public Vagas getVaga() {
        return vaga;
    }

    public void setVaga(Vagas vaga) {
        this.vaga = vaga;
    }
}
