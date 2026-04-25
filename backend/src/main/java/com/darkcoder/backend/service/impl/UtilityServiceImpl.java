package com.darkcoder.backend.service.impl;

import com.darkcoder.backend.service.UtilityService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("utilityService")
@Slf4j
public class UtilityServiceImpl implements UtilityService {
    private final ModelMapper modelMapper;

    public UtilityServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    @Override
    public <S, T> T map(S s, Class<T> targetClass) {
        return modelMapper.map(s, targetClass);
    }

    @Override
    public <S, T> void updateMap(S s, T t) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(s, t);
    }
}
