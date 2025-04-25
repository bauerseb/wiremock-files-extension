package fr.pinguet62.wiremock.files;

import com.github.jknack.handlebars.Options;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.responsetemplating.helpers.HandlebarsHelper;

/**
 * Helper class which checks if file exists ant given path.
 * The path is resolved against the global configured {@link FileSource}
 */
public class FileExistsHelper extends HandlebarsHelper<String> {


    private final FileSource fileSource;

    /**
     * creates the helper with the given file source
     * @param fileSource the {@link FileSource source} to resolve paths against
     */
    public FileExistsHelper(FileSource fileSource) {
        this.fileSource = fileSource;
    }

    @Override
    public Object apply(String context, Options options) {
        return fileSource.child(context).exists();
    }
}
