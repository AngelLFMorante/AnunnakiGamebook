package com.annunaki.gamebook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/basePersonaje")
@Tag(name = "BasePersonaje", description = "Operations pertaining to personaje in game")
public class BasePersonajeController {

    @Operation(
        summary = "Get list of baseCharacter",
        description = "This endpoint returns a list of the character base available in the game."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        @ApiResponse(responseCode = "404", description = "No character data found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/all")
    public String getMethodName() {
        return new String("ok");
    }
    

}
