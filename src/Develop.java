package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        arqtxt.put(9, "src/casos2/teste.txt");
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
                   

            UninfindLabirinto UF= new UninfindLabirinto(linhas*colunas);
            for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                String cell = matrizLabirinto[i][j];
                int currentId = i * colunas + j;
                int cellValue = Integer.parseInt(cell, 2); // Convert binary string to int

                // Verificar passagens e conectar:
                if ((cellValue & 1) == 0 && i > 0) { // Superior
                    int neighborId = (i - 1) * colunas + j;
                    UF.union(currentId, neighborId);
                }
                if ((cellValue & 2) == 0 && j < colunas - 1) { // Direita
                    int neighborId = i * colunas + (j + 1);
                    UF.union(currentId, neighborId);
                }
                if ((cellValue & 4) == 0 && i < linhas - 1) { // Inferior
                    int neighborId = (i + 1) * colunas + j;
                    UF.union(currentId, neighborId);
                }
                if ((cellValue & 8) == 0 && j > 0) { // Esquerda
                    int neighborId = i * colunas + (j - 1);
                    UF.union(currentId, neighborId);
                }
            }
        }

        // Contar regiões isoladas (raízes únicas no Union-Find):
        Set<Integer> regions = new HashSet<>();
        for (int i = 0; i < linhas * colunas; i++) {
            regions.add(UF.find(i));
        }
        System.out.println("Regiões isoladas: " + regions.size());
        ;
            String serMaisFrequente="";
            int maiorContagem = Math.max(
                    Math.max(
                            Math.max(totalAnao, totalBruxa),
                            Math.max(totalCavaleiro, totalDuende)),
                    Math.max(totalElfo, totalFeijao));

            if (maiorContagem == totalAnao) {
                   if(!serMaisFrequente.isEmpty()){
                       serMaisFrequente += "e";
                   }
                serMaisFrequente += "Anão";
            } else if (maiorContagem == totalBruxa) {
                if (!serMaisFrequente.isEmpty()) {
                    serMaisFrequente += "e";   
                }
                serMaisFrequente += "Bruxa";
            } else if (maiorContagem == totalCavaleiro) {
                if(!serMaisFrequente.isEmpty()){
                    serMaisFrequente += "e";
                }
                serMaisFrequente += "Cavaleiro";
            } else if (maiorContagem == totalDuende) {
                if (!serMaisFrequente.isEmpty()) {
                    serMaisFrequente += "e";     
                }
                serMaisFrequente += "Duende";
            } else if (maiorContagem == totalElfo) {
                if (!serMaisFrequente.isEmpty()) {
                    serMaisFrequente += "e";        
                }
                serMaisFrequente += "Elfo";
            } if (maiorContagem == totalFeijao) {
                if (!serMaisFrequente.isEmpty()) {
                    serMaisFrequente += "e";        
                }
                serMaisFrequente = "Feijão";
            }

            System.out.println("ser mais frequente: " + serMaisFrequente);

            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
