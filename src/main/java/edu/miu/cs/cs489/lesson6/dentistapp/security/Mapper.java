package edu.miu.cs.cs489.lesson6.dentistapp.security;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <U, V> V mapObject(U sourceObject, Class<V> targetClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(sourceObject, targetClass);
    }

}
