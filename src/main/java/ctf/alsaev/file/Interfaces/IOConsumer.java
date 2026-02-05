package ctf.alsaev.file.Interfaces;

import java.io.IOException;

/**
 * Функциональный интерфейс, который может генерировать исключение {@link IOException},
 * написан на основе {@link java.util.function.Consumer},
 *
 * @param <T> тип входного аргумента операции.
 * @author Alsaev Dmitry
 */
@FunctionalInterface
public interface IOConsumer<T> {
    /**
     * Выполняет операцию над переданным аргументом.
     *
     * @param value входной аргумент.
     * @throws IOException если при выполнении возникла ошибка вывода.
     */
    void accept(T value) throws IOException;
}
