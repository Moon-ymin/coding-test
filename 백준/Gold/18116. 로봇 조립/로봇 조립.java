import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Integer> parents = new HashMap<>();
    static HashMap<Integer, Integer> sizes = new HashMap<>();
    static int N;
    
    static int find(int a) {
        if (parents.get(a) < 0) return a;
        
        int root = find(parents.get(a));
        parents.put(a, root);  // Path compression for efficiency
        return root;
    }
    
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        
        
        // Union by size
        if (sizes.get(rootA) >= sizes.get(rootB)) {
            parents.put(rootB, rootA);
            sizes.put(rootA, sizes.get(rootA) + sizes.get(rootB));
        } else {
            parents.put(rootA, rootB);
            sizes.put(rootB, sizes.get(rootB) + sizes.get(rootA));
        }
        
        return true;
    }

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        
        for(int i = 0;i < N;i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            char oper = st2.nextToken().charAt(0);
            if(oper == 'I') {
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                
                if (!parents.containsKey(a)) {
                    parents.put(a, -1);
                    sizes.put(a, 1);
                }
                if (!parents.containsKey(b)) {
                    parents.put(b, -1);
                    sizes.put(b, 1);
                }
                
                union(a, b);
                
                //System.out.println("parents: "+ parents);
                //System.out.println("sizes: "+ sizes);
            } else if(oper == 'Q') {
                int a = Integer.parseInt(st2.nextToken());
                if(!parents.containsKey(a)) {
                    //System.out.println(1);
                    sb.append(1).append("\n");
                    //continue;
                } else {
                    //System.out.println(find(a));
                    sb.append(sizes.get(find(a))).append("\n");
                    //System.out.println(find(1));
                }
                
            }    
        }
        System.out.println(sb);
    }

}