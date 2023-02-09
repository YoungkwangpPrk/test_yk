package com.com4in.testbackend.service;

import com.com4in.testbackend.dto.WpiDto;
import com.com4in.testbackend.mapper.WpiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WpiServiceImpl implements WpiService {
    private final WpiMapper wpiMapper;

    @Override
    public List<WpiDto> getWpiList() {
        return wpiMapper.getWpiList();
    }
}
