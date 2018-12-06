package bio2vec.rdf4j;

import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

import bio2vec.Functions;

public class SimilarityFunction implements Function {

    public String getURI() {
	return Functions.NAMESPACE + "similarity";
    }

    public Value evaluate(ValueFactory valueFactory, Value... args)
	throws ValueExprEvaluationException {
	if (args.length != 2) {
	    throw new ValueExprEvaluationException("similarity function requires"
						   + "exactly 2 arguments, got "
						   + args.length);
	}
	double sim = Functions.sim(args[0].stringValue(), args[1].stringValue());
	return valueFactory.createLiteral(sim);
    }
}