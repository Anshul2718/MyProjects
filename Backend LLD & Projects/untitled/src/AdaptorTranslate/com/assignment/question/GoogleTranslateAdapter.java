package AdaptorTranslate.com.assignment.question;

import AdaptorTranslate.com.assignment.question.external.GoogleTranslateApi;
import AdaptorTranslate.com.assignment.question.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslateAdapter implements TranslationProviderAdapter{
    private GoogleTranslateApi googleApi = new GoogleTranslateApi();
    @Override
    public String translate(TranslationRequest request) {
        GoogleTranslationRequest googleRequest = new GoogleTranslationRequest(request.getText(), request.getSourceLanguage(),
                request.getTargetLanguage(), request.getConfidenceThreshold());
        return googleApi.convert(googleRequest);
    }

    @Override
    public List<String> getSupportedLanguages() {
        return googleApi.getLanguages();
    }
}
