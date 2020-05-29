package br.com.digx.casapopular.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public interface Mappable {

    ModelMapper mapper();

    default <T> T map(Object source, Class<T> clazz) {
        return mapper().map(source, clazz);
    }

    default <T> List<T> map(Collection<?> source, Class<T> clazz) {
        return source
                .stream()
                .map(t -> map(t, clazz))
                .collect(Collectors.toList());

    }

}
