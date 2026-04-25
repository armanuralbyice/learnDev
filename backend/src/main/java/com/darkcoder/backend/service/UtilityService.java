package com.darkcoder.backend.service;

import java.util.List;

public interface UtilityService {
    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);
    <S, T> T map(S s, Class<T> targetClass);
    <S, T> void updateMap(S s, T t);
}
