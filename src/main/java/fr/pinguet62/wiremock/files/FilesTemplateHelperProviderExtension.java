package fr.pinguet62.wiremock.files;

import com.github.jknack.handlebars.Helper;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.TemplateHelperProviderExtension;

import java.util.Map;

/**
 * a {@link TemplateHelperProviderExtension templateHelperExtension} which provides the helper for dealing the files
 */
public class FilesTemplateHelperProviderExtension implements TemplateHelperProviderExtension {

    private final FileSource fileSource;

    /**
     * @param files the main {@link FileSource fileSource}
     */
    public FilesTemplateHelperProviderExtension(FileSource files) {
        this.fileSource = files;
    }

    @Override
    public String getName() {
        return "files";
    }

    @Override
    public Map<String, Helper<?>> provideTemplateHelpers() {
        return Map.ofEntries(
            Map.entry("file-exists", new FileExistsHelper(fileSource)),
            Map.entry("file-content", new FileContentHelper(fileSource)));
    }
}
