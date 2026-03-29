package com.example.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Profile;
import com.example.service.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/profiles")
@Tag(name = "Profiles API", description = "Endpoints for managing profiles")
public class ProfilesController {
    
    private final ProfileService profileService;

    public ProfilesController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Get profile by ID", description = "Returns a profile by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profile found"),
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Profile not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @Operation(summary = "Get all profiles", description = "Returns a list of all profiles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profiles retrieved successfully"),
        @ApiResponse(responseCode = "204", description = "No profiles found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }
    
    
}
