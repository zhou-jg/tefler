/*
 * generated by Xtext
 */
package person.zhoujg.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import person.zhoujg.ui.document.FeatureDocumentationProvider;
import person.zhoujg.ui.hover.FeatureHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class FeatureUiModule extends person.zhoujg.ui.AbstractFeatureUiModule {
	public FeatureUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return FeatureDocumentationProvider.class;
	}
	
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return FeatureHoverProvider.class;
	}
}
