package fr.pinguet62.wiremock.files;

import com.github.jknack.handlebars.Options;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.TextFile;
import com.github.tomakehurst.wiremock.extension.responsetemplating.helpers.HandlebarsHelper;

/**
 * Helper class which reads the contents of a file by given path.
 * The path is resolved against the global configured {@link FileSource}
 */
public class FileContentHelper extends HandlebarsHelper<String> {

    private final FileSource fileSource;

    /**
     * creates the helper using the given file source
     * @param fileSource the {@link FileSource fileSource} to resolve paths against.
     */
    public FileContentHelper(FileSource fileSource) {
        this.fileSource = fileSource;
    }

    @Override
    public Object apply(String context, Options options) {
        TextFile textFileNamed = fileSource.getTextFileNamed(context);
        return textFileNamed.readContentsAsString();
    }
}
