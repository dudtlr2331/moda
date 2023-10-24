package com.moda.moda.join.service;

import com.moda.moda.join.dto.JoinDTO;
import com.moda.moda.join.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    public void save(JoinDTO joinDTO) {
    }
}