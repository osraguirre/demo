package com.example.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.entity.Profile;
import com.example.entity.SkillEntity;
import com.example.repository.ProfileRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProfileRepository profileRepository;
    public DataLoader(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Aquí puedes cargar datos iniciales en la base de datos si es necesario
        System.out.println("DataLoader ejecutado al iniciar la aplicación");
        Profile profile = new Profile();
        profile.setName("John");
        profile.setLastName("Doe");
        profile.setLocation("New York");
        profile.setRole("Developer");

        SkillEntity s1 = new SkillEntity("Java", "Advanced", profile);
        SkillEntity s2 = new SkillEntity("Spring Boot", "Intermediate", profile);
        profile.setSkills(List.of(s1, s2));

        profileRepository.save(profile);
    }
    
}
