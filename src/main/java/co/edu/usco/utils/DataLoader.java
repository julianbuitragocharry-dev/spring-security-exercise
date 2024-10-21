package co.edu.usco.utils;

import co.edu.usco.persistence.entity.RoleEntity;
import co.edu.usco.persistence.entity.UserEntity;
import co.edu.usco.persistence.repository.RoleRepository;
import co.edu.usco.persistence.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        /* Roles */
        RoleEntity user = roleRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RoleEntity editor = roleRepository.findById(2L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RoleEntity creator = roleRepository.findById(3L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        RoleEntity admin = roleRepository.findById(4L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        /* Users */
        UserEntity julianUser = UserEntity.builder()
                .username("julian.enrique")
                .password(passwordEncoder.encode("julian"))
                .isEnabled(true)
                .roles(Set.of(admin))
                .build();

        UserEntity carlosUser = UserEntity.builder()
                .username("carlos.esteban")
                .password(passwordEncoder.encode("carlos"))
                .isEnabled(true)
                .roles(Set.of(creator, editor, user))
                .build();

        UserEntity nathaliaUser = UserEntity.builder()
                .username("nathalia.avila")
                .password(passwordEncoder.encode("nathalia"))
                .isEnabled(true)
                .roles(Set.of(creator, editor))
                .build();

        UserEntity yohanUser = UserEntity.builder()
                .username("yohan.bustos")
                .password(passwordEncoder.encode("yohan"))
                .isEnabled(true)
                .roles(Set.of(creator))
                .build();

        UserEntity liangUser = UserEntity.builder()
                .username("liang.camilo")
                .password(passwordEncoder.encode("liang"))
                .isEnabled(true)
                .roles(Set.of(editor))
                .build();

        UserEntity felipeUser = UserEntity.builder()
                .username("felipe.artunduaga")
                .password(passwordEncoder.encode("felipe"))
                .isEnabled(true)
                .roles(Set.of(user))
                .build();

        userRepository.saveAll(List.of(julianUser,
                carlosUser,
                nathaliaUser,
                yohanUser,
                liangUser,
                felipeUser));
    }
}
