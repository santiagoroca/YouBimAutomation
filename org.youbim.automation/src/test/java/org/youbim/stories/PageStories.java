package org.youbim.stories;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.youbim.steps.LogInSteps;
import org.youbim.steps.Viewer2DSteps;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.XML;

public class PageStories extends JUnitStories {
    public String storyName = "";

    @Override
    public Configuration configuration() {

        Class<? extends Embeddable> embeddableClass = this.getClass();

        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();

        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);

        // add custom converters
        parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory));
                return new MostUsefulConfiguration()
                    .useStoryLoader(new LoadFromClasspath(embeddableClass))
                    .useStoryParser(new RegexStoryParser(examplesTableFactory))
                    .useStoryReporterBuilder(new StoryReporterBuilder().withCodeLocation(codeLocationFromClass(embeddableClass))
                            .withDefaultFormats()
                            .withFormats(CONSOLE, TXT, HTML, XML))
                    .useParameterConverters(parameterConverters);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromPath("src/test/resources"), "**/*.story", "");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new LogInSteps(),
                new Viewer2DSteps()
        );
    }

}