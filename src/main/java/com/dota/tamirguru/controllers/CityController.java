/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.controllers;

import com.dota.tamirguru.core.exception.ErrorData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "City operations", description = "This endpoint performs city operations")
public interface CityController {

    @Operation(summary = "Get City List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned city list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(description = "City Name", example = "ORDU")))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/cities")
    ResponseEntity<List<String>> getCities();

    @Operation(summary = "Get District List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned districts list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(description = "District Name", example = "GÜRGENTEPE")))}),
            @ApiResponse(responseCode = "400", description = "Getting district list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/districts")
    ResponseEntity<List<String>> getDistricts(@Parameter(description = "City Name", example = "ORDU", required = true, name = "cityName")
                                              @RequestParam String cityName);

}
