package src;
public class UninfindLabirinto {
    private int [] paren,rank;

    public UninfindLabirinto(int n){
        paren = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            paren[i] = i;
            
        }
    }
    public int find(int x) {
        if (paren[x] != x) {
            paren[x] = find(paren[x]); // Compressão de caminho
        }
        return paren[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                paren[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                paren[rootX] = rootY;
            } else {
                paren[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    
}