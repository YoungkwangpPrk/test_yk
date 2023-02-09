package com.com4in.testbackend.mapper;

import com.com4in.testbackend.dto.WpiDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WpiMapper {
    List<WpiDto> getWpiList();
}
