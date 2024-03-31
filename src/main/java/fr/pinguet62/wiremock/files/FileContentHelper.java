package fr.pinguet62.wiremock.files;

import com.github.jknack.handlebars.Options;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.common.TextFile;
import com.github.tomakehurst.wiremock.extension.responsetemplating.helpers.HandlebarsHelper;

import java.io.File;

public class FileContentHelper extends HandlebarsHelper<String> {

    private final FileSource fileSource = new SingleRootFileSource(new File("/home/wiremock/__files"));

    @Override
    public String apply(String context, Options options) {
        TextFile textFileNamed = fileSource.getTextFileNamed(context);
        return textFileNamed.readContentsAsString();
    }
}
