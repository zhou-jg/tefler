/*
 * generated by Xtext
 */
package person.zhoujg;

import org.eclipse.xtext.naming.IQualifiedNameProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class FeatureRuntimeModule extends person.zhoujg.AbstractFeatureRuntimeModule {
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return FeatureQalifiedNameProvider.class;
	}
}
