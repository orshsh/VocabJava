package example.api;

import example.entity.Word;

import java.util.List;

/**
 * Для работы с данными нужен отдельный интерфейс, который нужно будет реализовать для каждого из типов словарей
 * так как мы сохраняем в разные источники (разные файлы)
 */
public interface DictionaryRepository {

    Word save(Word word);

    Word findByKey(String key);

    List<Word> getAll();

    void delete(Word word);

}
