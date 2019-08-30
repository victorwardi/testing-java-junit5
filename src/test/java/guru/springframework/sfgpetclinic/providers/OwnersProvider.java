package guru.springframework.sfgpetclinic.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class OwnersProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Victor", 34, "Saquarema"),
                Arguments.of("Ursula", 35, "Sao Pedro da Aldeia"),
                Arguments.of("Adriano", 34, "Bacaxá"),
                Arguments.of("Georghia", 35, "Rio de Janeiro"),
                Arguments.of("Belinha", 6, "Niteroi")
        );
    }
}
