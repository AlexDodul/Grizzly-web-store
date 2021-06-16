package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "first_name",columnDefinition = "VARCHAR(32)", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name",columnDefinition = "VARCHAR(32)", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "login",columnDefinition = "VARCHAR(32)", unique = true, nullable = false, updatable = false)
    private String login;

    @NotNull
    @Column(name = "password",columnDefinition = "VARCHAR(16)", nullable = false)
    private String password;

    @NotNull
    @Column(name = "email",columnDefinition = "VARCHAR(32)", unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone",columnDefinition = "VARCHAR(16)", unique = true, nullable = false)
    private String phone;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @NotNull
    @Column(name = "updated_at")
    private Date updatedAt;

    @NotNull
    @Column(name = "active",columnDefinition = "VARCHAR(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Active active;

    @NotNull
    @Column(name = "is_verified",columnDefinition = "VARCHAR(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Verification verification;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id",referencedColumnName = "id", insertable = false, updatable = false)
    private List<Address> addresses;

    public void addRole(Role role){
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public User(
            String firstName,
            String lastName,
            String login,
            String password,
            String email,
            String phone,
            Date createdAt,
            Date updatedAt
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = Active.OFF;
        this.verification = Verification.NO;
    }

    public User(long id, String firstName, String lastName, String login, String password, String email, String phone, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = Active.OFF;
        this.verification = Verification.NO;
    }

    public enum Active{
        ON,OFF
    }

    public enum Verification{
        YES, NO
    }
}
