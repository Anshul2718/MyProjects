package AdaptorTranslate.com.assignment.question;

import AdaptorTranslate.com.assignment.question.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslateAdapter implements TranslationProviderAdapter{
    private MicrosoftTranslateApi microsoftApi = new MicrosoftTranslateApi();

    @Override
    public String translate(TranslationRequest request) {
        return microsoftApi.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    @Override
    public List<String> getSupportedLanguages() {
        return microsoftApi.getSupportedLanguages();
    }
}
