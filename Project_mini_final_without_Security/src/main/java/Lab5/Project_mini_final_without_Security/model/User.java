package Lab5.Project_mini_final_without_Security.model;

import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.sound.midi.Sequence;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@Document(collection = "users")
public class User implements UserDetails {
    @Id// оказывается mongo автоматом создает айди
    private BigInteger user_id;

    private String username;
    private String password;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime create_of;

    @DBRef
    private List <Task> tasks = new ArrayList<>();

    public User (){}

    // не пишу задачи в конструктор чтобы они не были обязательными
    public User(BigInteger user_id, String username, String password, String email, LocalDateTime create_of) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.create_of = create_of;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreate_of() {
        return create_of;
    }

    public void setCreate_of(LocalDateTime create_of) {
        this.create_of = create_of;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Если у вас нет ролей, возвращаем пустой список
        return new ArrayList<>();
    }

}