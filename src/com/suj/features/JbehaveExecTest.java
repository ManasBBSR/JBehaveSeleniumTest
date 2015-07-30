package com.suj.features;

//import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

//import org.apache.wicket.util.convert.converter.DateConverter;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
//import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
//import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
//import org.junit.runner.RunWith;

import static org.jbehave.core.io.CodeLocations.*;

//import com.suj.steps.AnnotationJbehaveSteps;
import com.suj.steps.JbehaveSteps;
//import com.suj.steps.jbehaveUltimatix;
 
//@RunWith(JUnitReportingRunner.class)
public class JbehaveExecTest extends JUnitStories {
 
//	public JbehaveExec() {
//		super();
//	}
 
//	@Override
//	public InjectableStepsFactory stepsFactory() {
//		return new InstanceStepsFactory(configuration().parameterConverters().defaultConverters(null, null), new JbehaveSteps());
//	}
 
	//@Override
	//protected List<String> storyPaths() {
		//return Arrays.asList("JBehaveSeleniumTest/src/com/suj/features/JbehaveFeature.story");
		//}
	
//	 @Override
//	 protected List<String> storyPaths() {
//	        //Specify story paths as URLs
//		 StoryFinder finder = new StoryFinder();
//	        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));
//	          }
	private final CrossReference xref = new CrossReference();
	 
    public JbehaveExecTest() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true).doVerboseFailures(true).useThreads(2).useStoryTimeoutInSecs(60);
        //configuredEmbedder().useEmbedderControls(new PropertyBasedEmbedderControls());
    }//configuredEmbedder().useEmbedderControls(new PropertyBasedEmbedderControls());


@Override
public Configuration configuration() {
Class<? extends Embeddable> embeddableClass = this.getClass();
Properties viewResources = new Properties();
viewResources.put("decorateNonHtml", "true");
viewResources.put("reports", "ftl/jbehave-reports-with-totals.ftl");
// Start from default ParameterConverters instance
ParameterConverters parameterConverters = new ParameterConverters();
// factory to allow parameter conversion and loading from external resources (used by StoryParser too)
ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
// add custom converters
//parameterConverters.defaultConverters(null,null;
     return new MostUsefulConfiguration()
    .useStoryLoader(new LoadFromClasspath(embeddableClass))
    .useStoryParser(new RegexStoryParser(examplesTableFactory)) 
    .useStoryReporterBuilder(new StoryReporterBuilder()
        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
        .withDefaultFormats()
        .withViewResources(viewResources)
        //.withFormats(CONSOLE, TXT, HTML_TEMPLATE, XML_TEMPLATE)
        .withFailureTrace(true)
        .withFailureTraceCompression(true)                
        .withCrossReference(xref)) 
    .useParameterConverters(parameterConverters)                     
    // use '%' instead of '$' to identify parameters
    .useStepPatternParser(new RegexPrefixCapturingPatternParser(
                    "%")) 
    .useStepMonitor(xref.getStepMonitor());                               
}

@Override
public InjectableStepsFactory stepsFactory() {
	return new InstanceStepsFactory(configuration(), new JbehaveSteps());
	}

@Override
protected List<String> storyPaths() {
       //Specify story paths as URLs
	StoryFinder finder = new StoryFinder();
	//return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));
	//return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/AnnotationJbehaveFeature.story"), Arrays.asList(""));
	return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/JbehaveFeature.story"), Arrays.asList(""));
	}

}
