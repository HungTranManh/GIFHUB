package com.t3h.demospring.repository;

import com.t3h.demospring.model.database.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Lap trinh on 5/20/2018.
 */
@Repository
public interface UserProfileRepository extends
        JpaRepository<UserProfile, Integer> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM userprofile " +
                    "WHERE user_profile.username = :username"
    )
    UserProfile findOneUsername(@Param("username") String username);
}
