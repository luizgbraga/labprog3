package com.social_network.server.entities;

import jakarta.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@Entity
@jakarta.persistence.Table(name = "kn_user", schema = "konnect")
public class KnUser {
    @EmbeddedId
    private KnUserPK id;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KnUser knUser = (KnUser) o;

        if (!id.getUserId().equals(knUser.id.getUserId())) return false;
        if (!id.getKnId().equals(knUser.id.getKnId())) return false;

        return true;
    }

    public KnUser(String userId, String knId) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.id = new KnUserPK(userId, knId);
    }

    public KnUser() {}

    @Override
    public int hashCode() {
        int result = id.getUserId().hashCode();
        result = 31 * result + id.getKnId().hashCode();
        return result;
    }
}
