package com.motomoto.dao.model.user;

import com.motomoto.dao.model.Auditable;
import com.motomoto.dao.model.listing.Listing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "display_name")
    private String displayName;

    private String email;

    private String password;

    private Boolean active = true;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_observed_listings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "listing_id")
    )
    private Set<Listing> observedListings = new HashSet<>();

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public boolean verifyPassword(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, this.password);
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    public void addObservedListing(Listing listing) {
        this.observedListings.add(listing);
    }

    public void removeObservedListing(Listing listing) {
        this.observedListings.remove(listing);
    }

    public boolean isObserving(Listing listing) {
        return this.observedListings.contains(listing);
    }
}
