package fr.pinguet62.wiremock.files;

import com.github.jknack.handlebars.Helper;
import com.github.tomakehurst.wiremock.extension.TemplateHelperProviderExtension;

import java.util.Map;

public class FilesTemplateHelperProviderExtension implements TemplateHelperProviderExtension {

    @Override
    public String getName() {
        return "files";
    }

    @Override
    public Map<String, Helper<?>> provideTemplateHelpers() {
        return Map.ofEntries(
            Map.entry("file-exists", new FileExistsHelper()),
            Map.entry("file-content", new FileContentHelper()));
    }
}
