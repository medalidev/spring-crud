package com.example.challenge1.entites;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt", "user"})
@NoArgsConstructor
@Table(name = "user-details")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.PUBLIC)
    private long id;

    @NonNull
    @Column(name = "github-profile-link")
    private String githubProfileLink;
    @NonNull
    @Column(name = "linkedin-profile-link")
    private String linkedinProfileLink;

    // OneTOOne Relations

    // OneToOne Relations
    @OneToOne(mappedBy = "details")
    private User user;
}
