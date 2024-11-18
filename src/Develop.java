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

            for (int row = 0; row < linhas; row++) {
                linha = br.readLine();
                String[] hexValues = linha.split(" ");
                // Supomos que valores são separados por espaço

                for (int col = 0; col < hexValues.length; col++) {
                    // 4. Converta hexadecimal para binário (4 bits)
                    String hex = hexValues[col];
                    boolean temLetraMaiuscula = false;
                    for (Character c : hex.toCharArray()) {
                        if (Character.isUpperCase(c)) {
                            temLetraMaiuscula = true;
                            switch (c) {
                                case 'A':
                                    coordenadaBinaria.append("Anão ");
                                    break;
                                case 'B':
                                    coordenadaBinaria.append("Bruxa ");
                                    break;
                                case 'C':
                                    coordenadaBinaria.append("Cavaleiro ");
                                    break;
                                case 'D':
                                    coordenadaBinaria.append("Duende ");
                                    break;
                                case 'E':
                                    coordenadaBinaria.append("Elfo ");
                                    break;
                                case 'F':
                                    coordenadaBinaria.append("Feijão");
                                    break;
                                default:
                                coordenadaBinaria.append(c);
                            }
                            break;
                        }
                    }
                    if (!temLetraMaiuscula) {
                        try{
                        int decimal = Integer.parseInt(hex, 16);
                        String binary = String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0');
                        matrizLabirinto[row][col] = coordenadaBinaria.append(binary).toString();
                        } catch (NumberFormatException e) {
                            matrizLabirinto[row][col] = "erro"; 
                    } 
                }else {
                        matrizLabirinto[row][col] =coordenadaBinaria.toString().trim();
                    }
                    coordenadaBinaria.setLength(0);
                }
            }
            br.close();
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
