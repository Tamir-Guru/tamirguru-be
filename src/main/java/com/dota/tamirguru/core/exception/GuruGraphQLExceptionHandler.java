/*
 * @author : Oguz Kahraman
 * @since : 31 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.core.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Component
public class GuruGraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrors) {
        return graphQLErrors.stream().map(this::handleGraphQLError).toList();
    }

    private GraphQLError handleGraphQLError(GraphQLError error) {
        if (error instanceof GraphQLException err) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "GraphQLException", err);
        } else if (error instanceof ValidationError err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validation Error " + err);
        } else if (error instanceof ExceptionWhileDataFetching err && err.getException() instanceof AccessDeniedException ade) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User don't have required permission", ade);
        } else {
            log.error("Another error {}", error);
            return error;
        }
    }

}
