/*
 * @author : Oguz Kahraman
 * @since : 23 Ara 2021
 *
 * Copyright - TamirGuru
 */
package com.dota.tamirguru.controllers;

import com.dota.tamirguru.core.exception.ErrorData;
import com.dota.tamirguru.models.internals.merchant.MerchantTypeName;
import com.dota.tamirguru.models.requests.merchant.MerchantCreateRequest;
import com.dota.tamirguru.models.requests.merchant.MerchantFilter;
import com.dota.tamirguru.models.responses.merchant.MerchantResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import java.util.List;

@Tag(name = "Merchant operations", description = "This endpoint performs merchant operations")
public interface MerchantController {

    @Operation(summary = "Get Merchant Types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned merchant list",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MerchantTypeName.class)))}),
            @ApiResponse(responseCode = "400", description = "Getting city list error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/merchants/types")
    ResponseEntity<List<MerchantTypeName>> getMerchantTypes();


    @Operation(summary = "Create Merchant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created merchant",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MerchantResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Merchant create error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @PostMapping(value = "/merchants")
    ResponseEntity<MerchantResponse> createMerchant(@RequestBody MerchantCreateRequest request);

    @Operation(summary = "Get Merchant List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned merchants",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MerchantResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Merchant list get error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorData.class))})})
    @GetMapping(value = "/merchants")
    ResponseEntity<List<MerchantResponse>> findMerchantsFromDistrictId(MerchantFilter filter,
                                                                       @Parameter(description = "Page Number", example = "1", name = "pageNumber")
                                                                       @RequestParam(defaultValue = "1", required = false) @Min(1) Integer pageNumber,
                                                                       @Parameter(description = "Page Size", example = "5", name = "pageSize")
                                                                       @RequestParam(defaultValue = "5", required = false) @Min(1) Integer pageSize);


}
