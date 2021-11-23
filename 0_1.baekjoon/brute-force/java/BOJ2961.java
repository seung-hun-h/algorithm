import java.io.*;
import java.util.*;
public class BOJ2961 {
    static class Ingredient {
        int sour, bitter;
        Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }

        public String toString() {
            return "sour = " + sour +"\n"
                + "bitter = " + bitter;
        }
    }
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Ingredient[] ingredients = new Ingredient[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken())
                                            , Integer.parseInt(st.nextToken()));
        
        }

        dfs(ingredients, 0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void dfs(Ingredient[] ingredients, int idx, List<Ingredient> result) {            
        if (idx == ingredients.length) {
            if (!result.isEmpty())
                answer = Math.min(answer, getDiff(result));
            return;
        }

        dfs(ingredients, idx + 1, result);
        List<Ingredient> list = new ArrayList<>(result);
        list.add(ingredients[idx]);
        dfs(ingredients, idx + 1, list);
    }

    private static int getDiff(List<Ingredient> result) {
        int sours = 1 , bitters = 0;

        for (Ingredient ingredient : result) {
            sours *= ingredient.sour;
            bitters += ingredient.bitter;
        }
        return Math.abs(sours - bitters);
    }
}
