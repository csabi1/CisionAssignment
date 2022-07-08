package com.cision.assignment.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

/**
 * Utility class for object mapping.
 *
 */
public class ObjectMapperUtils {
  /**
   * ModelMapper.
   */
  private static final ModelMapper modelMapper;

  /**
   * Model mapper property setting are specified in the following block.
   * Default property matching strategy is set to Strict see {@link MatchingStrategies}
   * Custom mappings are added using.
   * {@link ModelMapper#addMappings(PropertyMap)}
   */
  static {
    modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
    
    Converter<LocalDate, LocalDateTime> toLocalDateTime = new AbstractConverter<LocalDate, LocalDateTime>() {
        @Override
        protected LocalDateTime convert(LocalDate source) {
        	return source == null ? null : LocalDateTime.of(source, LocalTime.MIN);
        }
    };
    
    Converter<LocalDateTime, LocalDate> toLocalDate = new AbstractConverter<LocalDateTime, LocalDate>() {
        @Override
        protected LocalDate convert(LocalDateTime source) {
        	return source == null ? null : source.toLocalDate();
        }
    };
    
    modelMapper.addConverter(toLocalDate);
    modelMapper.addConverter(toLocalDateTime);
  }

  /**
   * Hide from public usage.
   */
  private ObjectMapperUtils() {
  }
  


  /**
   * <p>
   * Note: outClass object must have default constructor with no arguments.
   * </p>
   *
   * @param <D> type of result object.
   * @param <T> type of source object to map from.
   * @param entity entity that needs to be mapped.
   * @param outClass class of result object.
   * @return new object of <code>outClass</code> type.
   */
  public static <D, T> D map(final T entity, Class<D> outClass) {
    return modelMapper.map(entity, outClass);
  }

  /**
   * <p>
   * Note: outClass object must have default constructor with no arguments.
   * </p>
   *
   * @param entityList list of entities that needs to be mapped
   * @param outCLass class of result list element
   * @param <D> type of objects in result list
   * @param <T> type of entity in <code>entityList</code>
   * @return list of mapped object with D type.
   */
  public static <D, T> List<D> mapAll(final Collection<T> entityList,
      Class<D> outCLass) {
    return entityList.stream().map(entity -> map(entity, outCLass))
        .collect(Collectors.toList());
  }

  /**
   * Maps {@code source} to {@code destination}.
   *
   * @param source object to map from
   * @param destination object to map to
   * @param <S> source type
   * @param <D> destination type
   * @return D destination.
   */
  public static <S, D> D map(final S source, D destination) {
    modelMapper.map(source, destination);
    return destination;
  }
}

