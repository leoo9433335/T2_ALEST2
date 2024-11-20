package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Develop {
    private static Map<Integer, String> arqtxt;
    static {
        arqtxt = new HashMap<>();
        arqtxt.put(1, "src/casos2/caso40_2.txt");
        arqtxt.put(2, "src/casos2/caso80_2.txt");
        arqtxt.put(3, "src/casos2/caso100_2.txt");
        arqtxt.put(4, "src/casos2/caso120_2.txt");
        arqtxt.put(5, "src/casos2/caso150_2.txt");
        arqtxt.put(6, "src/casos2/caso180_2.txt");
        arqtxt.put(7, "src/casos2/caso200_2.txt");
        arqtxt.put(8, "src/casos2/caso250_2.txt");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número do arquivo que deseja ler (de 1 a 8): ");
        int num = sc.nextInt();
        String relativePath = arqtxt.get(num);
        if (relativePath == null) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.println("Arquivo selecionado: " + relativePath);
        String absolutePath = new File(relativePath).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + absolutePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            String primeiraLinha = br.readLine();
            // Divide a linha por espaço
            String[] dimensoes = primeiraLinha.split(" ");
            // Converte as dimensões para números inteiros
            int linhas = Integer.parseInt(dimensoes[0].trim());
            int colunas = Integer.parseInt(dimensoes[1].trim());
            System.out.println("Linhas: " + linhas);
            System.out.println("Colunas: " + colunas);

            StringBuilder coordenadaBinaria = new StringBuilder();
            String[][] matrizLabirinto = new String[linhas][colunas];

            int totalAnao = 0, totalBruxa = 0, totalCavaleiro = 0, totalDuende = 0, totalElfo = 0, totalFeijao = 0;

            for (int row = 0; row < linhas; row++) {
                linha = br.readLine();
                String[] hexValues = linha.split(" ");
                // Supomos que valores são separados por espaço

                for (int col = 0; col < hexValues.length; col++) {
                    // 4. Converta hexadecimal para binário (4 bits)
                    String hex = hexValues[col];
                    int contAnao = 0;
                    int contBruxa = 0;
                    int contCavaleiro = 0;
                    int contDuende = 0;
                    int contElfo = 0;
                    int contFeijao = 0;
                    for (Character c : hex.toCharArray()) {
                        if (Character.isUpperCase(c)) {

                            switch (c) {
                                case 'A':
                                    contAnao++;
                                    break;
                                case 'B':
                                    contBruxa++;
                                    break;
                                case 'C':
                                    contCavaleiro++;
                                    break;
                                case 'D':
                                    contDuende++;
                                    break;
                                case 'E':
                                    contElfo++;
                                    break;
                                case 'F':
                                    contFeijao++;
                                    break;
                            }
                        }
                    }
                    totalAnao += contAnao;
                    totalBruxa += contBruxa;
                    totalCavaleiro += contCavaleiro;
                    totalDuende += contDuende;
                    totalElfo += contElfo;
                    totalFeijao += contFeijao;

                    int decimal = Integer.parseInt(hex, 16);
                    String binary = String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0');
                    matrizLabirinto[row][col] = coordenadaBinaria.append(binary).toString();
                    coordenadaBinaria.setLength(0);

                }
            }
            String serMaisFrequente;
            int maiorContagem = Math.max(
                    Math.max(
                            Math.max(totalAnao, totalBruxa),
                            Math.max(totalCavaleiro, totalDuende)),
                    Math.max(totalElfo, totalFeijao));

            if (maiorContagem == totalAnao) {
                serMaisFrequente = "Anão";
            } else if (maiorContagem == totalBruxa) {
                serMaisFrequente = "Bruxa";
            } else if (maiorContagem == totalCavaleiro) {
                serMaisFrequente = "Cavaleiro";
            } else if (maiorContagem == totalDuende) {
                serMaisFrequente = "Duende";
            } else if (maiorContagem == totalElfo) {
                serMaisFrequente = "Elfo";
            } else {
                serMaisFrequente = "Feijão";
            }

            System.out.println("ser mais frequente: " + serMaisFrequente);

            // *iMPRIMI MATRIZ COM COORDENADAS */
            System.out.println("Matriz do labirinto: ");
            for (int r = 0; r < linhas; r++) {
                for (int c = 0; c < colunas; c++) {
                    System.out.print(matrizLabirinto[r][c] + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
