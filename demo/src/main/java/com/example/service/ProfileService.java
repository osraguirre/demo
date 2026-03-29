package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.entity.Profile;
import com.example.repository.ProfileRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProfileService {
    
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfileById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Profile ID cannot be null");
        }else {
            return profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
        }
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
