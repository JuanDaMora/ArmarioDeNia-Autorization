package com.example.authorization.service.interfaces;

import com.example.authorization.dto.ColorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Service
public interface IColorService {
    List<ColorDTO> getAllColors(String token);
}
