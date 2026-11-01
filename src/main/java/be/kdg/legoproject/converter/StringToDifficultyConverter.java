package be.kdg.legoproject.converter;

import be.kdg.legoproject.domain.Difficulty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Locale;

// Converts form text to a Difficulty.
// Tolerant: ignores upper/lower case and spaces.
// Unknown or empty text becomes null, so @NotNull shows a clear message.
public class StringToDifficultyConverter implements Converter<String, Difficulty> {

    private static final Logger log =
            LoggerFactory.getLogger(StringToDifficultyConverter.class);

    @Override
    public Difficulty convert(String source) {
        log.debug("Converting '{}' to Difficulty", source);

        String text = source.trim().toUpperCase(Locale.ROOT);

        return Arrays.stream(Difficulty.values())
                .filter(difficulty -> difficulty.name().equals(text))
                .findFirst()
                .orElse(null);
    }
}