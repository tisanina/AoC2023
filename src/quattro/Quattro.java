package quattro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

    public class Quattro {

        private static final String FILE_NAME = "src/quattro/quattro.txt";
        private static final String CARD_PREFIX = "Card";
        private static final String LINE_SPLITTER = ": ";
        private static final String LINE_SPLITTER_SECOND = " \\| ";

        public List<String> readLines() throws IOException {
            Path path = Path.of(FILE_NAME);
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        }

        private int getCard(String line) {
            return Integer.parseInt(line.split(LINE_SPLITTER)[0].replace(CARD_PREFIX, "").trim()) - 1;
        }

        private String[] parseWinningNumbers(String line) {
            return line.split(LINE_SPLITTER)[1].split(LINE_SPLITTER_SECOND)[0].split(" ");
        }

        private String[] parseAttempts(String line) {
            return line.split(LINE_SPLITTER)[1].split(LINE_SPLITTER_SECOND)[1].split(" ");
        }

        private int processWinningAttempts(String[] winningNumbers, String[] attempts) {
            return Arrays.stream(attempts)
                    .filter(attempt -> Arrays.asList(winningNumbers).contains(attempt) && !attempt.isEmpty())
                    .mapToInt(x -> 1)
                    .sum();
        }

        public void gioco() throws IOException {
            List<String> lines = this.readLines();

            int sum = 0;

            for (String line : lines){
                String[] winningNumbers = parseWinningNumbers(line);
                String[] attempts = parseAttempts(line);

                var points = processWinningAttempts(winningNumbers, attempts);
                var result = Math.pow(2, points - 1d);
                sum += (int) result;
            }

            System.out.println(sum);
        }

        public void gioco2() throws IOException {
            List<String> lines = this.readLines();
            Integer[] cards = new Integer[lines.size()];
            Arrays.fill(cards, 1);

            int sum = 1;

            for (String line : lines){
                int cardIndex = getCard(line);
                String[] winningNumbers = parseWinningNumbers(line);
                String[] attempts = parseAttempts(line);

                int points = processWinningAttempts(winningNumbers, attempts);

                for (int i = 1; i <= points; i++){
                    if (lines.size() >= cardIndex + i){
                        cards[cardIndex + i] += cards[cardIndex];
                    }
                    if (cardIndex != 0){
                        sum += cards[cardIndex];
                    }
                }
            }

            int total = Arrays.stream(cards).reduce(0, Integer::sum);

            System.out.println(total);
        }
    }

