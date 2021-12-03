package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public int findSmallestTemperatureSpread(Path path) {
        return Integer.parseInt(getSmallestDifference(path, 0, 1, 2));
    }

    public String findSmallestTeamDifference(Path path) {
        return getSmallestDifference(path, 1, 6, 8);
    }

    private String getSmallestDifference(Path path, int resultTokenIndex, int tokenIndex1, int tokenIndex2) {
        List<String> lines = readLines(path);
        int minDifference = Integer.MAX_VALUE;
        String result = "";
        for (String line : lines) {
            List<String> tokens = getTokens(line);
            if (hasNumericTokensAt(tokens, tokenIndex1, tokenIndex2)) {
                int difference = Math.abs(Integer.parseInt(tokens.get(tokenIndex1)) - Integer.parseInt(tokens.get(tokenIndex2)));
                if (difference < minDifference) {
                    minDifference = difference;
                    result = tokens.get(resultTokenIndex);
                }
            }
        }
        return result;
    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }

    private List<String> getTokens(String source) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = null;
        for (int i = 0; i <= source.length(); i++) {
            if (hasTokenCharacterAt(source, i)) {
                if (currentToken == null) { currentToken = new StringBuilder(); }
                currentToken.append(source.charAt(i));
            } else if (currentToken != null) {
                tokens.add(currentToken.toString());
                currentToken = null;
            }
        }
        return tokens;
    }

    private boolean hasTokenCharacterAt(String source, int index) {
        if (index >= source.length()) { return false; }
        if (Character.isWhitespace(source.charAt(index))) { return false; }
        if (source.charAt(index) == '*') { return false; }
        return true;
    }

    private boolean hasNumericTokensAt(List<String> tokens, int... indices) {
        try {
            for (int index : indices) {
                if (index >= tokens.size()) { return false; }
                Integer.parseInt(tokens.get(index));
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
