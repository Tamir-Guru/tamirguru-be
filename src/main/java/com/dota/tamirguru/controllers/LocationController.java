/*
 * @author : Oguz Kahraman
 * @since : 21 Ara 2021
 * <p>
 * Copyright - TamirGuru
 **/
package com.dota.tamirguru.controllers;

import com.dota.tamirguru.core.exception.ErrorData;
import com.dota.tamirguru.models.responses.locations.CityResponse;
import com.dota.tamirguru.models.responses.locations.CountryResponse;
import com.dota.tamirguru.models.responses.locations.DistrictResponse;
import com.dota.tamirguru.validators.City;
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
                            array = @ArraySchema(schema = @Schema(implementation = CountryResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/countries")
    ResponseEntity<List<CountryResponse>> getCountries();

    @Operation(summary = "Get City List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned city list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CityResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/cities")
    ResponseEntity<List<CityResponse>> getCities(@Parameter(description = "Country Code", example = "TR", required = true, name = "countryCode")
                                                 @RequestParam String countryCode);

    @Operation(summary = "Get District List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned districts list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DistrictResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting district list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/districts")
    ResponseEntity<List<DistrictResponse>> getDistricts(@Parameter(description = "City Code", example = "63", required = true, name = "cityId")
                                                        @RequestParam @City String cityId);

}
