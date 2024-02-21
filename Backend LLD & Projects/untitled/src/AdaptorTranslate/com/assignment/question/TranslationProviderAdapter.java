package AdaptorTranslate.com.assignment.question;

import java.util.List;

public interface TranslationProviderAdapter {
    String translate(TranslationRequest request);
    List<String> getSupportedLanguages();
}
