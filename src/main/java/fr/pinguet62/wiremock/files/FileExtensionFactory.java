package fr.pinguet62.wiremock.files;

import com.github.tomakehurst.wiremock.extension.Extension;
import com.github.tomakehurst.wiremock.extension.ExtensionFactory;
import com.github.tomakehurst.wiremock.extension.WireMockServices;

import java.util.List;

/**
 * the {@link ExtensionFactory factory} to create the Files extension
 */
public class FileExtensionFactory implements ExtensionFactory {

    @Override
    public List<Extension> create(WireMockServices services) {
        return List.of(new FilesTemplateHelperProviderExtension(services.getFiles()));
    }
}
