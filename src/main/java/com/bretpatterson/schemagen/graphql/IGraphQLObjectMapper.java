package com.bretpatterson.schemagen.graphql;

import com.bretpatterson.schemagen.graphql.datafetchers.ITypeFactory;
import graphql.schema.GraphQLInputType;
import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLType;

import java.lang.reflect.Type;
import java.util.Set;

/**
 * A GraphQLObjectMapper that knows how to build a GraphQLDefinition for objects.
 */
public interface IGraphQLObjectMapper {

	/**
	 * Get the object responsible for naming GraphQL types.
	 * @return
	 */
	ITypeNamingStrategy getTypeNamingStrategy();

	/**
	 * Get an input definition for the specified type.
	 * @param type
	 */
	GraphQLInputType getInputType(Type type);

	/**
	 * Get an output definition for the specified type.
	 * @param type
	 */
	GraphQLOutputType getOutputType(Type type);

	/**
	 * Get the Input Type cache. This is useful for custom type mappers who
	 * might need to add TypeReference's to the cache when they need to process
	 * an object that contains a two way dependency between itself and another object.
	 */
	IGraphQLTypeCache<GraphQLInputType> getInputTypeCache();

	/**
	 * Get the Input Type cache. This is useful for custom type mappers who
	 * might need to add TypeReference's to the cache when they need to process
	 * an object that contains a two way dependency between itself and another object.
	 */
	IGraphQLTypeCache<GraphQLOutputType> getOutputTypeCache();

	/**
	 * Returns the object responsible for object type conversion.
	 * @return
	 */
	ITypeFactory getObjectMapper();

	/**
	 * Get the raw type of this object for generic types
	 * @param type
	 * @return
	 */
	public Class getClassFromType(Type type);

	/**
	 * Returns all input types created.
	 * @return
	 */
	public Set<GraphQLType> getInputTypes();
}
