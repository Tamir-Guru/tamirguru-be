/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.controllers;

import com.dota.tamirguru.core.exception.ErrorData;
import com.dota.tamirguru.entitites.City;
import com.dota.tamirguru.entitites.Country;
import com.dota.tamirguru.entitites.District;
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

@Tag(name = "Location operations", description = "This endpoint performs city operations")
public interface LocationController {

    @Operation(summary = "Get Country List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned country list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Country.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/countries")
    ResponseEntity<List<Country>> getCountries();

    @Operation(summary = "Get City List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned city list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = City.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/cities")
    ResponseEntity<List<City>> getCities(@Parameter(description = "Country Code", example = "TR", required = true, name = "countryCode")
                                         @RequestParam String countryCode);

    @Operation(summary = "Get District List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned districts list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = District.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting district list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/districts")
    ResponseEntity<List<District>> getDistricts(@Parameter(description = "City Code", example = "ORDU", required = true, name = "cityId")
                                                @RequestParam String cityId);

}
