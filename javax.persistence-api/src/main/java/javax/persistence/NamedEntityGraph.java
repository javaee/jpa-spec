/*******************************************************************************
 * Copyright (c) 2011 - 2013 Oracle Corporation. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Linda DeMichiel - Java Persistence 2.1
 *
 ******************************************************************************/

package javax.persistence;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Used to specify the path and boundaries for a find operation or query.
 *
 * @since Java Persistence 2.1
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface NamedEntityGraph {

    /**
     * (Optional) The name of the entity graph.
     * Defaults to the entity name of the root entity.
     */
    String name() default "";

    /**
     * (Optional) A list of attributes of the entity that are included in
     *  this graph.
     */
    NamedAttributeNode[] attributeNodes() default {};

    /**
     * (Optional) Includes all of the attributes of the annotated
     * entity class as attribute nodes in the NamedEntityGraph without
     * the need to explicitly list them.  Included attributes can
     * still be fully specified by an attribute node referencing a
     * subgraph.
     */
    boolean includeAllAttributes() default false;

    /**
     * (Optional) A list of subgraphs that are included in the
     * entity graph. These are referenced by name from NamedAttributeNode
     * definitions.
     */
    NamedSubgraph[] subgraphs() default {};

    /**
     * (Optional) A list of subgraphs that will add additional
     * attributes for subclasses of the annotated entity class to the
     * entity graph.  Specified attributes from superclasses are
     * included in subclasses.
     */
    NamedSubgraph[] subclassSubgraphs() default {};
}

