/**
 * generated by Xtext
 */
package person.zhoujg.scoping;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class FeatureScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
  @Override
  protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, final boolean ignoreCase) {
    return super.internalGetImportedNamespaceResolvers(context, ignoreCase);
  }
}
