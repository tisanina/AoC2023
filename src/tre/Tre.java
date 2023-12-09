package tre;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tre {

    public List<String> getLinee() throws IOException {
        var fileName = "src/tre/tre.txt";
        var path = Path.of(fileName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public void gioco() throws IOException {
        ArrayList<int[]> nums = new ArrayList<>();
        HashMap<String, Character> symb = new HashMap<>();
        HashMap<String, Integer> gears = new HashMap<>();
        int part1 = 0;
        int part2 = 0;

        var linee = this.getLinee();
        int y = 0;
        for (var linea : linee) {
            char[] p = linea.toCharArray();
            int x = 0;

            while (x < p.length) {
                char c = p[x];

                if (Character.isDigit(c)) {
                    int x1 = x - 1;
                    int num = c - '0';

                    while ((x + 1 < p.length) && Character.isDigit(p[x + 1])) {
                        x++;
                        num = num * 10 + (p[x] - '0');
                    }

                    nums.add(new int[]{y, x1, x + 1, num});
                } else if (c != '.') {
                    symb.put(y + "#" + x, c);
                }

                x++;
            }
            y++;
        }

        for (int[] row : nums) {
            y = row[0];
            int x1 = row[1];
            int x2 = row[2];
            int num = row[3];
            boolean ok = false;

            ArrayList<String> border = new ArrayList<>();
            border.add(y + "#" + x1);
            border.add(y + "#" + x2);

            for (int i = x1; i <= x2; i++) {
                border.add((y - 1) + "#" + i);
                border.add((y + 1) + "#" + i);
            }

            for (String b : border) {
                if (!symb.containsKey(b)) continue;
                ok = true;

                if (symb.get(b) == '*') {
                    if (gears.containsKey(b)) part2 += gears.get(b) * num;
                    else gears.put(b, num);
                }
            }

            if (ok) part1 += num;
        }

        System.out.println( part1);
        System.out.println( part2);
    }
}
