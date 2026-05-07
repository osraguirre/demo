package com.example.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.entity.ContactInfo;
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
        profile.setName("Oscar");
        profile.setLastName("Aguirre");
        profile.setLocation("Nuevo Leon, Mexico");
        profile.setRole("Desarrollador Backend");

        SkillEntity s1 = new SkillEntity("Java", "Advanced", profile);
        SkillEntity s2 = new SkillEntity("Spring Boot", "Intermediate", profile);
        profile.setSkills(List.of(s1, s2));

        ContactInfo ci1 = new ContactInfo();
        ci1.setEmail("osr122g@gmail.com");
        ci1.setPhoneNumber("+528181789173");
        ci1.setLinkedin("https://www.linkedin.com/in/oscar-alberto-aguirre-gamboa/");
        ci1.setGithub("https://github.com/osraguirre");
        ci1.setProfile(profile);

        profile.setContactInfo(List.of(ci1));

        profileRepository.save(profile);
    }
    
}
