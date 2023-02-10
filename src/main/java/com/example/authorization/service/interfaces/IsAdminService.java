package com.example.authorization.service.interfaces;

import org.springframework.stereotype.Service;

/**
 * @autor Juan David Morantes Vergara
 */

public interface IsAdminService {
    Boolean is(String token);

}
