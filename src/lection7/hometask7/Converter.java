package lection7.hometask7;

@FunctionalInterface
public interface Converter<T> {
    /**
     * Converts T object
     * @param t type T object to convert
     * @return converted object of type T
     */
    T convert(T t);
}
