/*
 * generated by Xtext
 */
package person.zhoujg.validation

import org.eclipse.xtext.validation.Check
import person.zhoujg.feature.Atom
import person.zhoujg.feature.AttributeType
import person.zhoujg.feature.BasicExpr
import person.zhoujg.feature.Feature
import person.zhoujg.feature.FeaturePackage

import static extension person.zhoujg.util.FeatureUtil.isAttribute

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class FeatureValidator extends AbstractFeatureValidator {

	@Check
	//a group feature cannot have a (stand-alone) cardinality declaration
	def checkCardinalityForGroupFeature(Feature fea){
		if (!fea.attribute) {
			val holder = fea.eContainer
			if (holder != null) {
				val parent = holder.eContainer
				if ((parent as Feature).inCard != null && fea.outCard != null){
					error('Group feature can not declare a cardinality.',
					 		fea, FeaturePackage.Literals.FEATURE__OUT_CARD
					 	)
				}
			}		
		}	
	}
	
	@Check
	//compare whether the two operands around the operator are type compatible
	def checkBasicExpressionTying(BasicExpr expr) {
		if (expr.RExpr == null){
			//only to check whether the left operand is of bool
			val literal = expr.LExpr.literal
			if (literal == null){
				//no op for subExpression				 				
			}
			else if (literal.bool == null){
				 val feature = literal.name
				 if (feature == null || feature.attribute && feature.type != AttributeType.BOOL){
				 	error('Literal should be a bool type here',
				 		expr, FeaturePackage.Literals.BASIC_EXPR__LEXPR
				 	)
				 }		 	
			}
		}else {
			//check whether the left and right operands type match
			checkLeftAndRightType(expr.LExpr, expr.RExpr, expr)
		}	
	}
	
	private def checkLeftAndRightType(Atom atom1, Atom atom2, BasicExpr expr) {	
		if (atom1.atomType != atom2.atomType) {			
			error('Type mismatch around the operator!',
			 		expr, FeaturePackage.Literals.BASIC_EXPR__COMP_OP
			 	)
		}
	}
	
	private def getAtomType(Atom atom){
		if (atom.sub != null) {//already an logic expression which should be bool
			AttributeType.BOOL
		}else if (atom.literal.str != null){// a string literal
			AttributeType.STRING
		}else if (atom.literal.bool != null){// a bool literal
			AttributeType.BOOL
		}else if (atom.literal.name != null) {// a feature or feature attribute
			if (!atom.literal.name.attribute){// a feature implies a bool
				AttributeType.BOOL
			}else{ // return the feature attribute's type
				atom.literal.name.type 
			}
		}else {// an int literal
			AttributeType.INT
		}
	}
	
}
