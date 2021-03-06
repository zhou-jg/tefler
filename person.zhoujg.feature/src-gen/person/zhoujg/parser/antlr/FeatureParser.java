/*
 * generated by Xtext
 */
package person.zhoujg.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import person.zhoujg.services.FeatureGrammarAccess;

public class FeatureParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private FeatureGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected person.zhoujg.parser.antlr.internal.InternalFeatureParser createParser(XtextTokenStream stream) {
		return new person.zhoujg.parser.antlr.internal.InternalFeatureParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "RootDeclaration";
	}
	
	public FeatureGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(FeatureGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
